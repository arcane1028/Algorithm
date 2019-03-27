package baekjoonoj.greedy.problem_1201;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (M + K - 1 <= N && N <= M * K) {
            int a[] = new int[N];
            for (int i = 0; i < K; i++) {
                a[i] = K - i;
            }
            if (M - 1 != 0) {
                int size = (N - K) / (M - 1);
                int remainder = (N - K) % (M - 1);
                int begin = K;
                for (int i = 0; i < M - 1; i++) {
                    int temp_size = size + (remainder != 0 ? 1 : 0);
                    if (remainder != 0) {
                        remainder--;
                    }
                    for (int j = 0; j < temp_size; j++) {
                        a[begin + j] = begin + temp_size - j;
                    }
                    begin = begin + temp_size;
                }
            }
            for (int i = 0; i < N; i++) {
                bw.write(a[i] + " ");
            }
        } else {
            bw.write("-1\n");
        }
        br.close();
        bw.close();
    }
}