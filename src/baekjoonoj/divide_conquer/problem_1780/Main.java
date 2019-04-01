package baekjoonoj.divide_conquer.problem_1780;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
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
        int count[] = new int[3];

        check(count, a, 0, 0, N);

        for (int i = 0; i < 3; i++) {
            bw.write(count[i]+"\n");
        }
        br.close();
        bw.close();
    }

    private static boolean isSame(int a[][], int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (a[x][y] != a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void check(int count[], int a[][], int x, int y, int size) {
        if (isSame(a, x, y, size)) {
            count[a[x][y] + 1] += 1;
            return;
        }

        for (int i = x; i < x + size; i += size / 3) {
            for (int j = y; j < y + size; j += size / 3) {
                check(count, a, i, j, size / 3);
            }
        }
        return;
    }
}