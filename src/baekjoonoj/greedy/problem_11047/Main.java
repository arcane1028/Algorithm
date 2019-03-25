package baekjoonoj.greedy.problem_11047;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] a = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        int i = N - 1;
        while (K > 0) {
            answer += K / a[i];
            K = K % a[i];
            i--;
        }
        System.out.println(answer);
    }
}

