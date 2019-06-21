package baekjoonoj.sw_test.practice.brute_force.problem_1748;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = s.length();

        if (len > 1) {
            int big = s.charAt(0) - 48;
            int n = Integer.parseInt(s.substring(1, len));
            int answer = 0;
            int j = 9;
            for (int i = 1; i < len; i++, j *= 10) {
                answer += (i * j);
            }
            j /= 9;
            answer += (len * j * (big - 1)); // 제일 큰자리

            answer += (len * (n + 1)); // 나머지

            System.out.println(answer);
        } else {
            int n = Integer.parseInt(s);

            System.out.println(n);
        }

        br.close();
    }
}
