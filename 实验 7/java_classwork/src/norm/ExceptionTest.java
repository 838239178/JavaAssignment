package norm;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        double[] x = new double[3];
        double sum = 0.0;

        Scanner inputScan = new Scanner(System.in);

        for (int i = 0; i < x.length; i++) {

            System.out.println("Please input the " + (i + 1) + " number:");
            String input = inputScan.nextLine();

            try {
                x[i] = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                i--;
                continue;
            }

            sum += x[i];

        }

        System.out.println(Arrays.toString(x));

        System.out.println("Sum:" + sum);
    }
}
