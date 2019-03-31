package baekjoonoj.divide_conquer.problem_10815;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 제일 빠름
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean a[] = new boolean[20000002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
           a[Integer.parseInt(st.nextToken())+10000000] = true;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            if (a[Integer.parseInt(st.nextToken())+10000000]){
                bw.write("1 ");
            }else {
                bw.write("0 ");
            }
        }
        br.close();
        bw.close();
    }
}
/* 이진 탐색 구현 버젼
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            if (binarySearch(a, Integer.parseInt(st.nextToken()))){
                bw.write("1 ");
            }else {
                bw.write("0 ");
            }
        }
        br.close();
        bw.close();
    }

    private static boolean binarySearch(int a[], int x) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) {
                return true;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
*/

/* 구현된거 사용
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            if (Arrays.binarySearch(a, Integer.parseInt(st.nextToken()))>= 0){
                bw.write("1 ");
            }else {
                bw.write("0 ");
            }
        }
        br.close();
        bw.close();
    }
}
*/