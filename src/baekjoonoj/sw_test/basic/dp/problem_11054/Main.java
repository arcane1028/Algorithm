package baekjoonoj.sw_test.basic.dp.problem_11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp_in = new int[n];
        int[] dp_de = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        // 증가하는
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && dp_in[j] + 1 > dp_in[i]) {
                    dp_in[i] = dp_in[j] + 1;
                }
            }
        }
        //감소하는
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (num[i] > num[j] && dp_de[j] + 1 > dp_de[i]) {
                    dp_de[i] = dp_de[j] + 1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (answer < dp_in[i] + dp_de[i] + 1) {
                answer = dp_in[i] + dp_de[i] + 1;
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}
