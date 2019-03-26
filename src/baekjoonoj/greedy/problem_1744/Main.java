package baekjoonoj.greedy.problem_1744;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> minus = new ArrayList<Integer>();
        ArrayList<Integer> plus = new ArrayList<>();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                zero++;
            } else if (temp == 1) {
                one++;
            } else if (temp > 0) {
                plus.add(temp);
            } else {
                minus.add(temp);
            }
        }
        Collections.sort(minus);
        Collections.sort(plus);
        Collections.reverse(plus);
        if (minus.size() % 2 == 0) {
            for (int i = 0; i < minus.size(); i += 2) {
                answer += minus.get(i) * minus.get(i + 1);
            }
        } else {
            for (int i = 0; i < minus.size() - 1; i += 2) {
                answer += minus.get(i) * minus.get(i + 1);
            }
            if (zero == 0) {
                answer += minus.get(minus.size() - 1);
            }
        }
        if (plus.size() % 2 == 0) {
            for (int i = 0; i < plus.size(); i += 2) {
                answer += plus.get(i) * plus.get(i + 1);
            }
        } else {
            for (int i = 0; i < plus.size() - 1; i += 2) {
                answer += plus.get(i) * plus.get(i + 1);
            }
            answer += plus.get(plus.size() - 1);
        }
        answer += one;
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}