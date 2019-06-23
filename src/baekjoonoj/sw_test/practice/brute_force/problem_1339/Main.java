package baekjoonoj.sw_test.practice.brute_force.problem_1339;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        String s;
        int d;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            d = 1;
            for (int j = s.length() - 1; j >= 0; j--, d *= 10) {
                alphabet[s.charAt(j) - 65] += d;
            }
        }

        Arrays.sort(alphabet);

        int answer = 0;
        int mul = 9;
        for (int i = 25; i >= 0; i--, mul--) {
            answer += alphabet[i] * mul;
        }

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }
}
