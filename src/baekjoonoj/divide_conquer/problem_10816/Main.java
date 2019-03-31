package baekjoonoj.divide_conquer.problem_10816;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            a[Integer.parseInt(st.nextToken())+10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            bw.write(a[Integer.parseInt(st.nextToken())+10000000] + " ");
        }
        br.close();
        bw.close();
    }
}
/* 배열 사용 버젼
 import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            a[Integer.parseInt(st.nextToken())+10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            bw.write(a[Integer.parseInt(st.nextToken())+10000000] + " ");
        }
        br.close();
        bw.close();
    }
}
*/

/* 이진탐색 사용 버젼
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
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int t = Integer.parseInt(st.nextToken());
            int start = startBinarySearch(a, t);
            int end = endBinarySearch(a, t);

            if (start != -1){
                bw.write((end - start +1) +" ");
            }else {
                bw.write("0 ");
            }
        }
        br.close();
        bw.close();
    }

    private static int startBinarySearch(int a[], int x) {
        int left = 0;
        int right = a.length - 1;
        int start = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) {
                start = mid;
                right = mid - 1;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return start;
    }

    private static int endBinarySearch(int a[], int x) {
        int left = 0;
        int right = a.length - 1;
        int end = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) {
                end = mid;
                left = mid + 1;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return end;
    }
}
*/
/*
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            int k = Integer.parseInt(st.nextToken());
            if (map.containsKey(k)){
                int v = map.get(k);
                map.put(k, ++v);
            }else {
                map.put(k, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            int k = Integer.parseInt(st.nextToken());
            if (map.containsKey(k)){
                bw.write(map.get(k)+" ");
            }else {
                bw.write("0 ");
            }
        }
        br.close();
        bw.close();
    }
}
*/