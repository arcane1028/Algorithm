package baekjoonoj.sw_test.basic.math.problem_1934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b, lcm;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            lcm  = a*b/gcd(a, b);
            bw.write(lcm + "\n");
        }
        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
