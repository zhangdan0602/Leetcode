package leetcode_2020;
/*
*
* https://leetcode-cn.com/problems/russian-doll-envelopes/
*
* 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
* 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
* 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
**/

import java.util.Arrays;
import java.util.Comparator;

public class code354_RussianDollEnvelopes
{
    public int maxEnvelopes(int[][] envelopes)
    {
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++)
        {
            height[i] = envelopes[i][1];
        }
        return LenLongestIncreaseSubSequence(height);
    }

    private int LenLongestIncreaseSubSequence(int[] nums)
    {
        int maxLength = 0;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            dp[i] = 1;
        }
        for (int i = 0; i < dp.length; i++)
        {
            for (int k = 0; k < i; k++)
            {
                if (nums[i] > nums[k])
                    // dp[i]:以i结尾，最长的递增子序列
                    dp[i] = Math.max(dp[i], dp[k] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
