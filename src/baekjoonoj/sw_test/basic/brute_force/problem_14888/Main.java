package baekjoonoj.sw_test.basic.brute_force.problem_14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        solution(num, n, 1, num[0], plus, minus, mul, div);

        bw.write(max + "\n");
        bw.write(min + "\n");

        br.close();
        bw.close();
    }

    private static void solution(int[] num, int n, int idx, int res, int plus, int minus, int mul, int div) {
        if (idx == n) {
            if (res > max) {
                max = res;
            }
            if (res < min) {
                min = res;
            }
            return;
        }
        if (plus > 0) {
            solution(num, n, idx + 1, res + num[idx], plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            solution(num, n, idx + 1, res - num[idx], plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            solution(num, n, idx + 1, res * num[idx], plus, minus, mul - 1, div);
        }
        if (div > 0) {
            solution(num, n, idx + 1, res / num[idx], plus, minus, mul, div - 1);
        }
    }
}
