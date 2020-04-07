package leetcode_2020;

/*
* https://leetcode-cn.com/problems/interval-list-intersections/
*
* 给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
*
* 返回这两个区间列表的交集。*/

import java.util.ArrayList;
import java.util.List;

public class code986_IntervalListIntersections
{
    public int[][] intervalIntersection(int[][] A, int[][] B)
    {
        if (A == null)
            return A;
        if (B == null)
            return B;
        List<int[]> res = new ArrayList<>();
        int l1 = A.length, l2 = B.length;
        int i = 0, j = 0;
        while (i < l1 && j < l2)
        {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if (a1 <= b2 && a2 >= b1)
            {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (a2 < b2)
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        int[][] result = new int[res.size()][2];
        for (int k = 0; k < result.length; k++)
        {
            result[k] = res.get(k);
        }
        return result;
    }
}
