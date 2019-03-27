package baekjoonoj.greedy.problem_1783;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1) {
            bw.write("1\n");
        } else if (N == 2) {
            if (M <= 8) {
                bw.write((M + 1) / 2 + "\n");
            } else {
                bw.write("4\n");
            }
        } else {
            if (M <= 3) {
                bw.write(M + "\n");
            } else if (M <= 6) {
                bw.write("4\n");
            } else {
                bw.write(M - 2 + "\n");
            }
        }
        br.close();
        bw.close();
    }
}