package baekjoonoj.sw_test.basic.problem_14500;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int paper[][] = new int[n][m];
        int tetro[][][] = {
                {{2, 2}, {0, 0}, {0, 1}, {1, 0}, {1, 1}},
                {{1, 4}, {0, 0}, {0, 1}, {0, 2}, {0, 3}},
                {{4, 1}, {0, 0}, {1, 0}, {2, 0}, {3, 0}},

                {{3, 2}, {0, 0}, {1, 0}, {2, 0}, {2, 1}},
                {{2, 3}, {1, 0}, {1, 1}, {1, 2}, {0, 2}},
                {{3, 2}, {0, 0}, {0, 1}, {1, 1}, {2, 1}},
                {{2, 3}, {0, 0}, {0, 1}, {0, 2}, {1, 0}},

                {{3, 2}, {0, 1}, {1, 1}, {2, 1}, {2, 0}},
                {{2, 3}, {0, 0}, {1, 0}, {1, 1}, {1, 2}},
                {{3, 2}, {0, 0}, {0, 1}, {1, 0}, {2, 0}},
                {{2, 3}, {0, 0}, {0, 1}, {0, 2}, {1, 2}},

                {{3, 2}, {0, 0}, {1, 0}, {1, 1}, {2, 1}},
                {{2, 3}, {1, 0}, {1, 1}, {0, 1}, {0, 2}},
                {{3, 2}, {0, 1}, {1, 0}, {1, 1}, {2, 0}},
                {{2, 3}, {0, 0}, {0, 1}, {1, 1}, {1, 2}},

                {{2, 3}, {1, 0}, {1, 1}, {1, 2}, {0, 1}},
                {{3, 2}, {0, 0}, {1, 0}, {2, 0}, {1, 1}},
                {{2, 3}, {0, 0}, {0, 1}, {0, 2}, {1, 1}},
                {{3, 2}, {0, 1}, {1, 1}, {2, 1}, {1, 0}},
        };
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = -1;
        int temp;
        for (int t = 0; t < 19; t++) {
            for (int i = 0; i <= n - tetro[t][0][0]; i++) {
                for (int j = 0; j <= m - tetro[t][0][1]; j++) {
                    temp = paper[i + tetro[t][1][0]][j + tetro[t][1][1]] +
                            paper[i + tetro[t][2][0]][j + tetro[t][2][1]] +
                            paper[i + tetro[t][3][0]][j + tetro[t][3][1]] +
                            paper[i + tetro[t][4][0]][j + tetro[t][4][1]];
                    if (temp>max){
                        max = temp;
                    }
                }
            }
        }
        bw.write(max+"\n");
        br.close();
        bw.close();
    }
}
