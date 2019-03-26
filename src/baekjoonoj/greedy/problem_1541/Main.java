package baekjoonoj.greedy.problem_1541;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "-");
        int answer = 0;
        boolean first = true;
        do{
            StringTokenizer temp = new StringTokenizer(st.nextToken(), "+");
            int sum = 0;
            while(temp.hasMoreTokens()){
                sum += Integer.parseInt(temp.nextToken());
            }
            if (first){
                answer = sum;
                first =false;
            }else {
                answer = answer - sum;
            }
        }while (st.hasMoreTokens());
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
