package baekjoonoj.sw_test.practice.brute_force.problem_2529;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static boolean[] visited;
    private static int k;
    private static char[] sign;
    private static ArrayList<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        visited = new boolean[10];
        results = new ArrayList<>();

        String s = br.readLine();
        for (int i = 0; i < k; i++) {
            sign[i] = s.charAt(i * 2);
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(i, 0, String.valueOf(i));
        }
        bw.write(results.get(results.size() - 1) + "\n");
        bw.write(results.get(0) + "\n");

        bw.close();
        br.close();
    }

    private static void dfs(int num, int idx, String str) {
        if (idx == k) {
            results.add(str);
            visited[num] = false;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            if (sign[idx] == '<') {
                if (num >= i) {
                    continue;
                }
            } else {
                if (num <= i) {
                    continue;
                }
            }
            visited[i] = true;
            dfs(i, idx + 1, str + i);
        }
        visited[num] = false;
    }
}
