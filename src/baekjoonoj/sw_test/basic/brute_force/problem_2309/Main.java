package baekjoonoj.sw_test.basic.brute_force.problem_2309;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int dwarf[] = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarf);
        int sum;
        fisrt:for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    sum += dwarf[k];
                }
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        bw.write(dwarf[k]+"\n");
                    }
                    break fisrt;
                }
            }
        }

        br.close();
        bw.close();
    }
}
