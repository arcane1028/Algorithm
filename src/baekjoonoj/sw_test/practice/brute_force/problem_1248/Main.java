package baekjoonoj.sw_test.practice.brute_force.problem_1248;

import java.io.*;

public class Main {
    private static int n;
    private static char[][] s;
    private static int[][] range;
    private static int[] answer;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String t = br.readLine();


        s = new char[n][n];
        for (int i = 0, a = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s[i][j] = t.charAt(a++);
            }
        }

        range = new int[n][2];
        for (int i = 0; i < n; i++) {
            switch (s[i][i]) {
                case '0':
                    range[i][0] = 0;
                    range[i][1] = 0;
                    break;
                case '+':
                    range[i][0] = 1;
                    range[i][1] = 10;
                    break;
                case '-':
                    range[i][0] = -10;
                    range[i][1] = -1;
                    break;
            }
        }
        answer = new int[n];
        if (dfs(0)) {
            for (int i = 0; i < n - 1; i++) {
                bw.write(answer[i] + " ");
            }
            bw.write(answer[n - 1] + "\n");
        }


        bw.close();
        br.close();
    }

    private static boolean dfs(int idx) throws IOException {
        if (idx == n) {
            return true;
        }

        for (int i = range[idx][0]; i <= range[idx][1]; i++) {
            answer[idx] = i;
            if (check(idx)) {
                if (dfs(idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(int idx) {
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += answer[i];
            if (sum > 0) {
                if (s[i][idx] == '+') {
                    continue;
                }
            }
            if (sum == 0) {
                if (s[i][idx] == '0') {
                    continue;
                }
            }
            if (sum < 0) {
                if (s[i][idx] == '-') {
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
