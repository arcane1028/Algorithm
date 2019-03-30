package baekjoonoj.greedy.problem_2873;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int joy[][] = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                joy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        if (R % 2 == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 1; j < C; j++) {
                    if (i % 2 == 0) {
                        sb.append("R");
                    } else {
                        sb.append("L");
                    }
                }
                if (i != R - 1) {
                    sb.append("D");
                }
            }
        } else if (C % 2 == 1) {
            for (int i = 0; i < C; i++) {
                for (int j = 1; j < R; j++) {
                    if (i % 2 == 0) {
                        sb.append("D");
                    } else {
                        sb.append("U");
                    }
                }
                if (i != C - 1) {
                    sb.append("R");
                }
            }
        } else {
            int min_x = 0;
            int min_y = 1;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if ((i + j) % 2 == 1 && joy[min_x][min_y] > joy[i][j]) {
                        min_x = i;
                        min_y = j;
                    }
                }
            }
            for (int i = 0; i < min_x / 2; i++) {
                for (int j = 0; j < C - 1; j++) {
                    sb.append("R");
                }
                sb.append("D");
                for (int j = 0; j < C - 1; j++) {
                    sb.append("L");
                }
                sb.append("D");
            }
            int y = 0;
            for (int i = 0; i < min_y / 2;  y = ++i) {
                sb.append("DRUR");
            }
            if ((y * 2 + 1) == min_y) {
                sb.append("DR");
            } else {
                sb.append("RD");
            }
            for (int i = min_y / 2 + 1; i < C / 2; i++) {
                sb.append("RURD");
            }
            for (int i = min_x / 2 + 1; i < R / 2; i++) {
                sb.append("D");
                for (int j = 0; j < C - 1; j++) {
                    sb.append("L");
                }
                sb.append("D");
                for (int j = 0; j < C - 1; j++) {
                    sb.append("R");
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}