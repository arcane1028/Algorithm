package baekjoonoj.sw_test.basic.dp.problem_11726;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[1001];
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        for (int i = 4; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 10_007;
        }

        bw.write(a[n] + "\n");
        br.close();
        bw.close();
    }
}
