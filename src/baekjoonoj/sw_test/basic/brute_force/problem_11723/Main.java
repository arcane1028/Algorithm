package baekjoonoj.sw_test.basic.brute_force.problem_11723;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean s[] = new boolean[21];
        StringTokenizer st;
        String cmd;
        int x;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            switch (cmd) {
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        s[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        s[j] = false;
                    }
                    break;
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    s[x] = true;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    s[x] = false;
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if (s[x]) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    s[x] = !s[x];
                    break;

            }
        }
        br.close();
        bw.close();
    }
}
