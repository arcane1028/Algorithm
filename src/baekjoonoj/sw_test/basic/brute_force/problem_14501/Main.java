package baekjoonoj.sw_test.basic.brute_force.problem_14501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] meeting;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        meeting = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0, 0);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static void solution(int idx, int t, int sum) {
        if (idx == n) {
            if (t==0 && sum > answer) {
                answer = sum;
            }
            return;
        }
        if (t > 0) {
            solution(idx + 1, t - 1, sum);
        } else {
            solution(idx + 1, meeting[idx][0] - 1, sum + meeting[idx][1]);
            solution(idx + 1, t, sum);
        }
    }
}
