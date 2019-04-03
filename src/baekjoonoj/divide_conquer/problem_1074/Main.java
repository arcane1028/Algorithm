package baekjoonoj.divide_conquer.problem_1074;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = solution(n, r, c);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static int solution(int n, int r, int c) {
        if (n == 1) {
            if (r == 0) {
                if (c == 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (c == 0) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }
        int x = (int) Math.pow(2, n - 1);
        int s = x * x;
        if (r < x) {
            if (c < x) {
                return solution(n - 1, r, c);
            } else {
                return s + solution(n - 1, r, c - x);
            }
        } else {
            if (c < x) {
                return 2 * s + solution(n - 1, r - x, c);
            } else {
                return 3 * s + solution(n - 1, r - x, c - x);
            }
        }
    }
}
