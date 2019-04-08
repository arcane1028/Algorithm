package baekjoonoj.divide_conquer.problem_2261;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Point p[] = new Point[n];
        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(p);
        answer = solution(p, 0, n - 1);
        /*
        for (int i = 0; i < n; i++) {
            System.out.println(point[i].x + "  " + point[i].y);
        }
         */

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static int solution(Point[] p, int start, int end) {
        if (end - start + 1 <= 3) { // 나눌경우 거리 계산 안됨
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end - 1; i++) {
                for (int j = i + 1; j <= end; j++) {
                    int len = length(p[i], p[j]);
                    if (min > len) {
                        min = len;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                return 0;
            }
            return min;
        }

        int mid = (end + start) / 2;
        int left = solution(p, start, mid);
        int right = solution(p, mid + 1, end);
        int min = left >= right ? right : left;
        ArrayList<Point> temp = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            int d = p[i].x - p[mid].x;
            if (d * d < min) {
                temp.add(p[i]);
            }
        }
        Collections.sort(temp, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });
        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                int d = temp.get(i).y - temp.get(j).y;
                if (d * d < min) {
                    int len = length(temp.get(i), temp.get(j));
                    if (len < min) {
                        min = len;
                    }
                } else {
                    break;
                }
            }
        }
        return min;
    }

    private static int length(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.x, o.x);
    }
}
