package baekjoonoj.sw_test.basic.brute_force.problem_1182;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int s;
    private static int[] num;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0, 0);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static void solution(int idx, int count, int sum) {
        if (idx == n) {
            if (count > 0 && sum == s) {
                answer++;
            }
            return;
        }
        solution(idx + 1, count + 1, sum + num[idx]);
        solution(idx + 1, count, sum);
    }
}
