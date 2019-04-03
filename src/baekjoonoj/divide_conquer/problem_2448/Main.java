package baekjoonoj.divide_conquer.problem_2448;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        solution(n, sb);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean isBlank(int i, int j, int n) {
        if (n == 3) {
            if (i == 1 && j == 1) {
                return true;
            }
            return false;
        }
        if (i >= n / 2) {
            if ((i - n / 2) * 2 + 1 <= j && j < n) {
                return true;
            }
        }
        if (n > 3) {
            return isBlank(i % (n / 2), j % (n / 2), n / 2);
        }

        return false;
    }

    private static void solution(int n, StringBuilder sb) {
        for (int i = 0; i < n; i++) {
            int t=0;
            for (int j = 0; j < n - 1 - i; j++) {
                sb.append(' ');
                t++;
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (isBlank(i, j, n)) {
                    sb.append(' ');
                } else {
                    sb.append('*');
                }
                t++;
            }
            for (int j = t; j < n * 2; j++) {
                sb.append(' ');
            }
            sb.append('\n');
        }
    }
}
