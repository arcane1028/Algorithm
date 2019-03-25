package baekjoonoj.greedy.problem_1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int N = Integer.parseInt(br.readLine());
            Meeting[] meetings = new Meeting[N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(meetings);
            int answer = 0;
            int now = 0;

            for (int i = 0; i < N; i++) {
                if (now<=meetings[i].start){
                    answer+=1;
                    now = meetings[i].end;
                }
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(answer+"\n");
            br.close();
            bw.close();
        } catch (Exception e) {
            System.out.println(-1);
        }
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return Integer.compare(this.start, o.start);
        } else {
            return Integer.compare(this.end, o.end);
        }
    }
}
