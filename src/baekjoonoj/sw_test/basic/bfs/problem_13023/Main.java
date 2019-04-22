package baekjoonoj.sw_test.basic.bfs.problem_13023;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static boolean check[];
    private static ArrayList<Integer> p[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            p[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            p[r1].add(r2);
            p[r2].add(r1);
        }
        check = new boolean[n];
        int answer = -1;
        for (int i = 0; i < n; i++) {
            answer = solution(0, i);
            if (answer == 1){
                break;
            }
        }
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }

    private static int solution(int depth, int cur) {
        if (depth == 4) {
            return 1;
        }
        int result = 0;

        check[cur] = true;
        for (int i = 0; i < p[cur].size(); i++) {
            if (check[p[cur].get(i)]) {
                continue;
            }
            result = solution(depth + 1, p[cur].get(i));
            if (result == 1) {
                return result;
            }
        }
        check[cur] = false;
        return result;
    }
}
