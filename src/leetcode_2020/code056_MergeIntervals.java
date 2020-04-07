package leetcode_2020;

/*
* https://leetcode-cn.com/problems/merge-intervals/
*
* 给出一个区间的集合，请合并所有重叠的区间。
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class code056_MergeIntervals
{
    public int[][] merge(int[][] intervals)
    {
        if (intervals == null || intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++)
        {
            int[] last = res.get(res.size() - 1);
            int[] curr = intervals[i];
            if (curr[0] <= last[1])
            {
                last[1] = Math.max(last[1], curr[1]);
            }
            else
            {
                res.add(curr);
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = res.get(i);
        }
        return result;
    }
}
