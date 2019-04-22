package baekjoonoj.sw_test.basic.math.problem_1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0, p;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p = Integer.parseInt(st.nextToken());
            if (isPrime(p)) {
                answer++;
            }
        }
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static boolean isPrime(int p) {
        if (p == 1) {
            return false;
        } else if (p == 2) {
            return true;
        } else if (p % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i * i <= p; i += 2) {
                if (p % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
