public class Mathematics {

    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public int divide(int a, int b) {
        if(b <= 0){
            throw new IllegalArgumentException("divisor can't be <= 0");
        }
        int c = a / b;
        return c;
    }
}
