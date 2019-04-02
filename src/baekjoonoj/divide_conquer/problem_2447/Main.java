package baekjoonoj.divide_conquer.problem_2447;

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
        for (int k = n; k >= 3; k /= 3) {
            i = i % k;
            j = j % k;
            if (k / 3 <= i && i < 2 * k / 3 && k / 3 <= j && j < 2 * k / 3) {
                return true;
            }
        }
        return false;
    }

    private static void solution(int n, StringBuilder sb) {
        if (n == 1) {
            sb.append('*');
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isBlank(i, j, n)) {
                    sb.append(' ');
                } else {
                    sb.append('*');
                }
            }
            sb.append("\n");
        }
    }
}
