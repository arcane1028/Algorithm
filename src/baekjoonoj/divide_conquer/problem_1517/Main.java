package baekjoonoj.divide_conquer.problem_1517;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long answer = solution(a, 0, n - 1);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    private static long solution(int a[], int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        long answer = solution(a, start, mid) + solution(a, mid + 1, end);
        int left = start;
        int right = mid + 1;
        int i = 0;
        int temp[] = new int[end - start + 1];
        while (left <= mid || right <= end) {
            if (left <= mid && (right > end || a[left] <= a[right])) {
                temp[i] = a[left];
                i++;
                left++;
            } else {
                answer += mid - left + 1;
                temp[i] = a[right];
                i++;
                right++;
            }
        }
        for (int j = start; j <= end; j++) {
            a[j] = temp[j - start];
        }

        return answer;
    }
}
/*
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int temp;
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j]>a[j+1]){
                  temp = a[j];
                  a[j] = a[j+1];
                  a[j+1] = temp;
                  answer++;
                }
            }
        }
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
    private static int solution(int a[]){
        return 0;
    }
}
*/