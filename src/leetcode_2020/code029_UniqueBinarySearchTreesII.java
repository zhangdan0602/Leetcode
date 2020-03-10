package leetcode_2020;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zd on 2020/2/10.
 */
public class code029_UniqueBinarySearchTreesII {
    public int numTrees(int n) {
        int G[] = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    public int numTrees1(int n){
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int)c;
    }
}
