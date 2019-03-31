package baekjoonoj.divide_conquer.problem_1780;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count_one = 0;
    static int count_zero = 0;
    static int count_minus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a[][] = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = check(a, 0, 0, N);
        if (t == 1) {
            count_one += 1;
        } else if (t == 0) {
            count_zero += 1;
        } else if (t==-1){
            count_minus += 1;
        }
        bw.write(count_minus + "\n");
        bw.write(count_zero + "\n");
        bw.write(count_one + "\n");

        br.close();
        bw.close();
    }

    private static int check(int a[][], int x, int y, int size) {
        if (size == 1){
            return a[x][y];
        }
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (a[x][y] != a[i][j]) {
                    for (int k = x; k < x + size; k += size / 3) {
                        for (int l = y; l < y + size; l += size / 3) {
                            int t = check(a, k, l, size / 3);
                            if (t == 1) {
                                count_one += 1;
                            } else if (t == 0) {
                                count_zero += 1;
                            } else if (t==-1){
                                count_minus += 1;
                            }
                        }
                    }
                    return -100;
                }
            }
        }
        return a[x][y];
    }
}