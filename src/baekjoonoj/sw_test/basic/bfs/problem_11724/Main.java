package baekjoonoj.sw_test.basic.bfs.problem_11724;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer> v[];
    private static boolean check[];
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        v = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0, v1, v2; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            v[v1].add(v2);
            v[v2].add(v1);
        }
        answer = 0;
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            answer++;
            dfs(i);
        }


        bw.write(answer + "\n");

        br.close();
        bw.close();
    }

    private static void dfs(int p) {

        for (int i = 0; i < v[p].size(); i++) {
            int tmp = v[p].get(i);
            if (check[tmp]) {
                continue;
            }
            check[tmp] =true;
            dfs(tmp);
        }
    }
}
/*
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] v = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0, v1, v2; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            v[v1].add(v2);
            v[v2].add(v1);
        }
        int answer = 0;
        boolean[] check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            answer++;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            check[i] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int tmp : v[cur]) {
                    if (check[tmp]){
                        continue;
                    }
                    queue.offer(tmp);
                    check[tmp] = true;
                }
            }
        }
        bw.write(answer+"\n");

        br.close();
        bw.close();
    }
}
*/