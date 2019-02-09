import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
//        System.out.println(nextBiggerNumber(531));
        System.out.println(nextBiggerNumber(9876543210L));
    }

    public static long nextBiggerNumber(long n) {
        if (n < 12) {
            return -1;
        }
        String number = String.valueOf(n);
        char[] digits = number.toCharArray();

        int j = 1;
        while(j < digits.length && digits[j] <= digits[j-1]) {
            j++;
            if (j == digits.length) {
                return -1;
            }
        }

        int k = digits.length - 2;
        while (k > 0 && digits[k] >= digits[k + 1]) {
            k--;
        }

        char nextDigit = digits[k + 1];
        int nextIndex = k + 1;
        for (int i = k + 2; i < digits.length; i++) {
            if (digits[i] < nextDigit && digits[i] > digits[k]) {
                nextDigit = digits[i];
                nextIndex = i;
            }
        }

        char buffer = digits[k];
        digits[k] = digits[nextIndex];
        digits[nextIndex] = buffer;

        Arrays.sort(digits, k + 1, digits.length);
        return Long.parseLong(String.valueOf(digits));
    }
}
