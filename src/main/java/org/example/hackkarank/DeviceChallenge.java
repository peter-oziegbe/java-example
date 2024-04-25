package org.example.hackkarank;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DeviceChallenge {
    public static void main(String[] args) throws IOException {
        String statusQuery = "MALFUNCTIONING"; // Example status query
        int threshold = 3; // Example threshold value
        String date = "05-2019"; // Example date
        int totalDevices = getTotalDevices(statusQuery, threshold, date);
        System.out.println("Total devices meeting the criteria: " + totalDevices);
    }

    public static int getTotalDevices(String statusQuery, int threshold, String date) throws IOException {
        String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery;
        int totalDevices = 0;
        int currentPage = 1;
        int totalPages = 1;
        while (currentPage <= totalPages) {
            URL url = new URL(apiUrl + "&page=" + currentPage);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                var inputStreamReader = new InputStreamReader(conn.getInputStream());
                var response = new Gson().fromJson(inputStreamReader, Map.class);
                List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
                int count = 0;
                var dateFormat = new SimpleDateFormat("MM-YYYY");
                for (Map<String, Object> deviceData : data) {
                    var status = (String) deviceData.get("status");
                    Double timestamp =(Double) deviceData.get("timestamp");
                    var formattedDate = dateFormat.format(new Date(timestamp.longValue()));
                    LinkedTreeMap<String, Object> rootThreshold = (LinkedTreeMap<String, Object>) deviceData.get("operatingParams");
                    if (formattedDate.equals(date) && status.contains(statusQuery)
                            && ((Double)rootThreshold.get("rootThreshold")) > threshold) {
                        count++;
                    }
                }
                totalDevices += count;
                totalPages = ((Double) response.get("total_pages")).intValue();
                currentPage++;
            }
        }
        return totalDevices;
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
