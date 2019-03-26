package baekjoonoj.greedy.problem_11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        int p[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        for (int t : p) {
            sum = sum + t;
            answer = answer + sum;
        }
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
