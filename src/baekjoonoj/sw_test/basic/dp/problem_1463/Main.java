package baekjoonoj.sw_test.basic.dp.problem_1463;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.n == 1) {
                answer = cur.count;
                break;
            }
            if (cur.n % 3 == 0) {
                int next = cur.n / 3;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Pair(next, cur.count + 1));
                }
            }
            if (cur.n % 2 == 0) {
                int next = cur.n / 2;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Pair(next, cur.count + 1));
                }
            }
            if (!visited[cur.n - 1]) {
                visited[cur.n - 1] = true;
                queue.offer(new Pair(cur.n - 1, cur.count + 1));
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}

class Pair {
    int n;
    int count;

    Pair(int n, int count) {
        this.n = n;
        this.count = count;
    }
}
