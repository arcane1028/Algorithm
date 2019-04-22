package baekjoonoj.sw_test.basic.brute_force.problem_10819;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int a[];
    private static boolean check[];
    private static int sum,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int temp = solution(1, a[i], i);
            if (temp > sum) {
                sum = temp;
            }
        }

        bw.write(sum + "\n");
        br.close();
        bw.close();
    }

    private static int solution(int depth, int prev, int index) {
       int result = 0;
       check[index] = true;

        for (int i = 0; i < n; i++) {
            if (check[i]||i == index) {
                continue;
            }
            if (depth == n - 1){
                check[index] = false;
                return Math.abs(prev - a[i]);
            }
            int temp = Math.abs(prev - a[i])+solution(depth+1, a[i], i);
            if (temp > result){
                result = temp;
            }
        }
        check[index] = false;
        return result;
    }
}
/* 94%에서 실패
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int answer[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int mid = (n - 1) / 2;
        for (int i = 0; i < n; i += 2) {
            answer[i] = a[mid - i / 2];
        }
        for (int i = 1; i < n; i += 2) {
            answer[i] = a[n - 1 - i / 2];
        }
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(answer[i] - answer[i + 1]);
        }
        if (n % 2 == 1) {
            int temp_sum = 0;
            for (int i = 1; i < n; i += 2) {
                answer[i] = a[i / 2];
            }
            for (int i = 0; i < n; i += 2) {
                answer[i] = a[mid + i / 2];
            }
            for (int i = 0; i < n - 1; i++) {
                temp_sum += Math.abs(answer[i] - answer[i + 1]);
            }
            if (temp_sum>sum){
                sum = temp_sum;
            }
        }
        bw.write(sum + "\n");
        br.close();
        bw.close();
    }
}


*/
