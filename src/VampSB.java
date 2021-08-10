public class VampSB {
    private static final int DIGIT_NOT_FOUND = -1;
    private static final String DIGIT_FOUND = "F";
    private static final String ALL_DIGIT_FOUND = "FFFF";
    private static final int start = 11;
    private static final int end = 99;

    int a;
    int b;
    int product;

    public void count() {
        int bottom = (start - 1) * (end + 1) - 1;
        for (a = start; a <= end; ++a) {
            for (b = end; b >= a; --b) {
                product = a * b;
                if (product <= bottom) {
                    break;
                }
                StringBuilder productSB = new StringBuilder("" + product);
                StringBuilder abSB = new StringBuilder("" + a + b);
                for (int i = 0; i < abSB.length(); i++) {
                    int digit = productSB.indexOf(Character.toString(abSB.charAt(i)));
                    if (digit == DIGIT_NOT_FOUND) {
                        break;
                    } else {
                        productSB = productSB.replace(digit, digit + 1, DIGIT_FOUND);
                        if (productSB.toString().equals(ALL_DIGIT_FOUND)) {
                            System.out.println(a + " * " + b + " = " + product);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        VampSB run = new VampSB();
        run.count();
    }
}
