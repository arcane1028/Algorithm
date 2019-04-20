package baekjoonoj.samsung_sw.problem_17140;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = -1;
        int a[][] = new int[101][101];

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int h_size = 3;
        int v_size = 3;
        Queue<Num> queue = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                if (o1.count == o2.count) {
                    return Integer.compare(o1.number, o2.number);
                } else {
                    return Integer.compare(o1.count, o2.count);
                }
            }
        });
        int count[] = new int[101];

        for (int time = 0; time < 101; time++) {
            if (a[r][c] == k) {
                answer = time;
                break;
            }

            if (v_size >= h_size) {
                int max_size = 0;
                for (int i = 1; i <= v_size; i++) {
                    int tmp_size = 0;
                    for (int j = 1; j <= h_size; j++) {
                        count[a[i][j]]++;
                    }

                    for (int j = 1; j <= 100; j++) {
                        if (count[j] != 0) {
                            queue.add(new Num(j, count[j]));
                        }
                    }
                    for (int index = 1; index <= 100; index += 2) {
                        if (queue.isEmpty()) {
                            a[i][index] = 0;
                            a[i][index + 1] = 0;
                            continue;
                        }
                        Num tmp = queue.poll();
                        a[i][index] = tmp.number;
                        a[i][index + 1] = tmp.count;
                        tmp_size = index + 1;
                    }
                    if (tmp_size > max_size) {
                        max_size = tmp_size;
                    }
                    queue.clear();
                    Arrays.fill(count, 0);
                }
                h_size = max_size;
            } else {
                int max_size = 0;
                for (int i = 1; i <= h_size; i++) {
                    int tmp_size = 0;
                    for (int j = 1; j <= v_size; j++) {
                        count[a[j][i]]++;
                    }

                    for (int j = 1; j <= 100; j++) {
                        if (count[j] != 0) {
                            queue.add(new Num(j, count[j]));
                        }
                    }
                    for (int index = 1; index <= 100; index += 2) {
                        if (queue.isEmpty()) {
                            a[index][i] = 0;
                            a[index + 1][i] = 0;
                            continue;
                        }
                        Num tmp = queue.poll();
                        a[index][i] = tmp.number;
                        a[index + 1][i] = tmp.count;
                        tmp_size = index + 1;
                    }
                    if (tmp_size > max_size) {
                        max_size = tmp_size;
                    }
                    queue.clear();
                    Arrays.fill(count, 0);
                }
                v_size = max_size;
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
}

class Num {
    int number;
    int count;

    public Num(int number, int count) {
        this.number = number;
        this.count = count;
    }
}
