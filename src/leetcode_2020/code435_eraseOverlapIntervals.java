package leetcode_2020;


import java.util.Arrays;
import java.util.Comparator;

/*
* https://leetcode-cn.com/problems/non-overlapping-intervals/
* 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
* */
class Solution
{
    public int eraseOverlapIntervals(int[][] intervals)
    {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[1] - b[1];
            }
        });
        int count = 1;
        int init_end = intervals[0][1];
        for (int[] inter : intervals)
        {
            int start = inter[0];
            if (start >= init_end)
            {
                count++;
                init_end = inter[1];
            }
        }
        return intervals.length - count;
    }
}