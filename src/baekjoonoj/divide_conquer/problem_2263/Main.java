package baekjoonoj.divide_conquer.problem_2263;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int in[] = new int[n];
        int post[] = new int[n];
        int pre[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        Node node = findTree(in, post, 0, n - 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        printPreorder(node, sb);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void printPreorder(Node node, StringBuilder sb) {
        sb.append(node.root);
        sb.append(" ");
        if (node.left != null) {
            printPreorder(node.left, sb);
        }
        if (node.right != null) {
            printPreorder(node.right, sb);
        }
    }

    private static Node findTree(int in[], int post[], int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return null;
        }
        int root = post[post_end];
        int in_root = 0;
        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == root) {
                in_root = i;
            }
        }
        int length = in_root - in_start;
        return new Node(
                root,
                findTree(in, post, in_start, in_root - 1, post_start, post_start + length - 1),
                findTree(in, post, in_root + 1, in_end, post_start + length, post_end - 1)
        );
    }
}

class Node {
    int root;
    Node left;
    Node right;

    public Node(int root, Node left, Node right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
}