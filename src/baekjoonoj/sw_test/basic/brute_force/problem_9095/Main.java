package baekjoonoj.sw_test.basic.brute_force.problem_9095;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int n3 = n / 3;
            int r3 = n % 3;

            for (int i = n3; i >= 0; i--) {
                int n2 = r3 / 2;
                int r2 = r3 % 2;

                for (int j = n2; j >= 0; j--) {
                    int n1 = r2;

                    sum += permutation(n3, n2, n1);
                    n2 -= 1;
                    r2 += 2;
                }
                n3 -= 1;
                r3 += 3;
            }
            bw.write(sum + "\n");
        }
        br.close();
        bw.close();
    }

    private static int permutation(int n3, int n2, int n1) {
        int p = n3 + n2 + n1;

        return factorial(p) / (factorial(n3) * factorial(n2) * factorial(n1));
    }

    private static int factorial(int n) {
        int sum = 1;

        for (int i = n; i > 0; i--) {
            sum *= i;
        }
        return sum;
    }
}
