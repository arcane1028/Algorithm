package swexpertacademy.p5658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int size = n + n / 4 - 1;
            char a[] = sc.next().toCharArray();

            a = Arrays.copyOf(a, size);
            for (int i = 0; i < n / 4 - 1; i++) {
                a[n + i] = a[i];
            }
            ArrayList<String> hex = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String tmp = String.copyValueOf(a, i, n / 4);
                if (!hex.contains(tmp)) {
                    hex.add(tmp);
                }
            }
            Collections.sort(hex);
            String hex_answer = hex.get(hex.size() - k);
            int answer = 0;
            int multiply = 1;
            int length = hex_answer.length() - 1;
            for (int i = length; i >= 0; i--) {
                char c = hex_answer.charAt(i);
                switch (c) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        answer += Integer.parseInt(String.valueOf(c)) * multiply;
                        break;
                    case 'A':
                        answer += 10 * multiply;
                        break;
                    case 'B':
                        answer += 11 * multiply;
                        break;
                    case 'C':
                        answer += 12 * multiply;
                        break;
                    case 'D':
                        answer += 13 * multiply;
                        break;
                    case 'E':
                        answer += 14 * multiply;
                        break;
                    case 'F':
                        answer += 15 * multiply;
                        break;
                    default:
                        break;

                }
                multiply *= 16;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}