package baekjoonoj.sw_test.basic.problem_10974;

import java.io.*;

public class Main {
    private static boolean check[];
    private static StringBuilder sb;
    private static int answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        check = new boolean[n + 1];
        answer =  new int[n];

        solution(0, n);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void solution(int index, int n) {
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                answer[index] = i;
                check[i] = true;
                solution(index + 1, n);
                check[i] = false;

                if (index == n - 1) {
                    for (int j = 0; j < n - 1; j++) {
                        sb.append(answer[j]).append(" ");
                    }
                    sb.append(answer[n - 1]).append("\n");
                }
            }
        }
    }
}