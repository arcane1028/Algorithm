package baekjoonoj.sw_test.basic.brute_force.problem_10972;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = n - 2;
        while (m >= 0) {
            if (a[m + 1] > a[m]) {
                break;
            }
            m--;
        }
        if (m < 0) {
            bw.write(-1 + "\n");
        } else {
            for (int i = n - 1; i > m; i--) {
                if (a[m]<a[i]){
                    int temp = a[m];
                    a[m] = a[i];
                    a[i] = temp;
                    break;
                }
            }
            Arrays.sort(a, m+1, n);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append(a[n-1]).append("\n");
            bw.write(sb.toString());
        }
        br.close();
        bw.close();
    }
}
