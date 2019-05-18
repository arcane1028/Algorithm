package baekjoonoj.sw_test.basic.bfs.problem_14226;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = Integer.parseInt(br.readLine());
        int answer = -1;

        boolean[][] visited = new boolean[1001][1001];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.num == s) {
                answer = cur.time;
                break;
            }

            if (visited[cur.num][cur.clip]){
                continue;
            }
            visited[cur.num][cur.clip] = true;
            if (cur.num > 1) {
                queue.offer(new Pair(cur.num - 1, cur.time + 1, cur.clip));

            }
            if (cur.num + cur.clip < 1001 ) {
                queue.offer(new Pair(cur.num + cur.clip, cur.time + 1, cur.clip));
            }
            queue.offer(new Pair(cur.num, cur.time + 1, cur.num));
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}

class Pair {
    int num;
    int time;
    int clip;

    public Pair(int num, int time, int clip) {
        this.num = num;
        this.time = time;
        this.clip = clip;
    }
}