package baekjoonoj.sw_test.basic.bfs.problem_1697;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            bw.write("0\n");
            bw.close();
            br.close();
            return;
        }

        int[] cost = new int[100_001];
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        cost[n] = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                answer = cost[cur];
                break;
            }

            if (cur - 1 >= 0) {
                if (cost[cur] + 1 < cost[cur - 1] || cost[cur - 1] == 0) {
                    cost[cur - 1] = cost[cur] + 1;
                    q.offer(cur - 1);
                }

            }
            if (cur + 1 < 100_001) {
                if (cost[cur] + 1 < cost[cur + 1] || cost[cur + 1] == 0) {
                    cost[cur + 1] = cost[cur] + 1;
                    q.offer(cur + 1);
                }

            }
            if (cur * 2 < 100_001) {
                if (cost[cur] + 1 < cost[cur * 2] || cost[cur * 2] == 0) {
                    cost[cur * 2] = cost[cur] + 1;
                    q.offer(cur * 2);
                }
            }
        }
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}