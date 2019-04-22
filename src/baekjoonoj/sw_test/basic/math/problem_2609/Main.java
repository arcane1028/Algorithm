package baekjoonoj.sw_test.basic.math.problem_2609;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = gcd(a, b);
        int lcm = a*b/gcd;

        bw.write(gcd + "\n");
        bw.write(lcm + "\n");
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
