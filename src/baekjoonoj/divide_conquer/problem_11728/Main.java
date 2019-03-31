package baekjoonoj.divide_conquer.problem_11728;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a[] = new int[N];
        int b[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int answer[] = new int[N + M];
        int t = N + M;
        N--;
        M--;
        while (t-- > 0) {
            if (M < 0) {
                answer[t] = a[N--];
            } else if (N < 0) {
                answer[t] = b[M--];
            } else if (a[N] > b[M]) {
                answer[t] = a[N--];
            } else {
                answer[t] = b[M--];
            }
        }
        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        br.close();
        bw.close();
    }
}
