package baekjoonoj.sw_test.basic.bfs.problem_1707;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int colors[];
    private static ArrayList<ArrayList<Integer>> edge;
    private static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num_v = Integer.parseInt(st.nextToken());
            int num_e = Integer.parseInt(st.nextToken());

            colors = new int[num_v + 1];
            edge = new ArrayList<>();
            answer = true;

            for (int i = 0; i <= num_v; i++) {
                edge.add(new ArrayList<>());
            }

            while (num_e-- > 0) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                edge.get(v1).add(v2);
                edge.get(v2).add(v1);
            }
            for (int i = 1; i <= num_v; i++) {
                if (!answer) {
                    break;
                }
                if (colors[i] == 0) {
                    colors[i] = 1;
                    dfs(i, -1);
                }
            }
            if (answer) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        br.close();
        bw.close();
    }

    private static void dfs(int p, int color) {
        for (int i = 0; i < edge.get(p).size(); i++) {
            int tmp = edge.get(p).get(i);
            if (colors[tmp] == 0) {
                colors[tmp] = color;
                dfs(tmp, -color);
            } else if (colors[tmp] == -color) {
                answer = false;
                return;
            }
        }
    }
}
