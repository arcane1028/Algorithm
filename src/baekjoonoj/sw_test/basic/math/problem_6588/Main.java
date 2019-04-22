package baekjoonoj.sw_test.basic.math.problem_6588;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, end;

        StringBuilder sb = null;
        boolean primes[] = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if (isPrime(i)) {
                primes[i] = true;
            }
        }
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (primes[i]) {
                    if (primes[n - i]) {
                        sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                        break;
                    }
                }
            }
            if (sb.length() == 0) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
            bw.write(sb.toString());
        }
        br.close();
        bw.close();
    }

    private static boolean isPrime(int p) {
        if (p == 1) {
            return false;
        } else if (p == 2) {
            return true;
        } else if (p % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i * i <= p; i += 2) {
                if (p % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}