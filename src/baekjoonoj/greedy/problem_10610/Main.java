package baekjoonoj.greedy.problem_10610;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        char N[] = br.readLine().toCharArray();
        boolean zero = false;

        for (int i = 0; i < N.length; i++) {
            if (N[i] == '0') {
                zero = true;
            }
            sum += N[i] - '0';
        }
        if (zero && sum % 3 == 0) {
            Arrays.sort(N);
            StringBuilder sb = new StringBuilder(new String(N));
            bw.write(sb.reverse().toString());
        } else {
            bw.write("-1\n");
        }
        br.close();
        bw.close();
    }
}

