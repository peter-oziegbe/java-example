package org.example.hackkarank;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        //String statusQuery = "MALFUNCTIONING"; // Example status query
        //int threshold = 3; // Example threshold value
        //String date = "05-2019"; // Example date





        //int totalDevices = getTotalDevices(statusQuery, threshold, date);
        //System.out.println("Total devices meeting the criteria: " + totalDevices);

        Main main = new Main();
        Class<?> clazz = main.getClass();
        Class<?> mainClass = Main.class;
    }

    public static int getTotalDevices(String statusQuery, int threshold, String date) throws IOException {
        String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery;
        int totalDevices = 0;
        int currentPage = 1;
        int totalPages = 1; // Initialize totalPages to ensure the loop runs at least once

        while (currentPage <= totalPages) {
            String jsonResponse = fetchJsonResponse(apiUrl + "&page=" + currentPage);
            DevicesPage devicesPage = parseJsonResponse(jsonResponse);
            totalDevices += countDevices(statusQuery, devicesPage.getData(), threshold, date);

            currentPage++;
            totalPages = devicesPage.getTotalPages();
        }

        return totalDevices;
    }

    public static String fetchJsonResponse(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Read response
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder responseBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            return responseBuilder.toString();
        }
    }

    public static DevicesPage parseJsonResponse(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, DevicesPage.class);
    }

    public static int countDevices(String statusQuery, List<Device> devices, int threshold, String date) {
        int count = 0;
        for (Device device : devices) {
            if (formatToMMYYYY(Long.parseLong(device.getTimestamp())).equals(date)
                    && device.getStatus().contains(statusQuery)
                    && device.getOperatingParams().getRootThreshold() > threshold) {
                count++;
            }
        }


        return count;
    }


    public static String formatToMMYYYY(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-YYYY");
        String formattedDate = dateFormat.format(date);

        return formattedDate;
    }

    static class DevicesPage {
        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private List<Device> data;

        public List<Device> getData() {
            return data;
        }

        public int getTotalPages() {
            return total_pages;
        }
    }

    static class Device {
        private String timestamp;
        private String status;
        private RootThreshold operatingParams;

        public String getTimestamp() {
            return timestamp;
        }

        public String getStatus() {
            return status;
        }

        public RootThreshold getOperatingParams() {
            return operatingParams;
        }
    }

    static class RootThreshold {
        private int rotorSpeed;
        private double slack;
        private double rootThreshold;

        public double getRootThreshold() {
            return rootThreshold;
        }

        public int getRotorSpeed() {
            return rotorSpeed;
        }

        public double getSlack() {
            return slack;
        }
    }
}
