package baekjoonoj.sw_test.basic.problem_1476;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int year = 0;
        while (true) {
            if (year % 15 + 1 == e && year % 28 + 1 == s && year % 19 + 1 == m) {
                bw.write(year + 1 + "\n");
                break;
            }
            year++;
        }
        br.close();
        bw.close();
    }
}
