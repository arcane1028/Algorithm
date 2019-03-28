package baekjoonoj.greedy.problem_1080;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char a[][] = new char[N][M];
        char b[][] = new char[N][M];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            a[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            b[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    answer += 1;
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            a[k][l] = a[k][l] == '0' ? '1' : '0';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] != b[i][j]) {
                    answer = -1;
                }
            }
        }
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}