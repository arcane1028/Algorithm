package baekjoonoj.sw_test.basic.brute_force.problem_1759;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb;
    private static char[] result;
    private static char[] alp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        alp = new char[c];
        sb = new StringBuilder();
        result = new char[l];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < c; i++) {
            alp[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alp);
        solution(0, 0,0, 0, l, c);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void solution(int start, int idx, int c_count, int v_count, int l, int c) {
        if (l == idx) {
            if (c_count>=2 && v_count>=1){
                for (int i = 0; i < l; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < c; i++) {
            result[idx] = alp[i];
            if (isVowel(alp[i])) {
                solution(i + 1, idx + 1, c_count, v_count + 1, l, c);
                continue;
            }
            solution(i + 1, idx + 1, c_count + 1, v_count, l, c);
        }
    }

    private static boolean isVowel(char c) {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < 5; i++) {
            if (c == vowel[i]) {
                return true;
            }
        }
        return false;
    }
}
