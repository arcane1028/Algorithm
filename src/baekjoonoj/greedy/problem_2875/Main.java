package baekjoonoj.greedy.problem_2875;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        while (N >= 2 && M >= 1 && N + M >= K + 3) {
            answer++;
            N -= 2;
            M -= 1;
        }
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
