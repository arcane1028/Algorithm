package baekjoonoj.divide_conquer.problem_1992;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char v[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            v[i] = br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        solution(sb, v, 0, 0, n);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean isSame(char v[][], int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (v[x][y] != v[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void solution(StringBuilder sb, char v[][], int x, int y, int n) {
        if (isSame(v, x, y, n)) {
            sb.append(v[x][y]);
            return;
        }
        sb.append('(');
        solution(sb, v, x, y, n / 2);
        solution(sb, v, x, y + n / 2, n / 2);
        solution(sb, v, x + n / 2, y, n / 2);
        solution(sb, v, x + n / 2, y + n / 2, n / 2);
        sb.append(')');
        return;
    }
}
