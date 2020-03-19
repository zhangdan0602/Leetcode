package Point_to_Offer_Version1.数组;

import java.util.ArrayList;
import java.util.List;

public class P216_41_2_ContinueSquenceWithSum
{
    /*
    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    */
    List<int[]> res = new ArrayList<>();
    public int[][] findContinuousSequence(int target) {
        int small = 1, big = 2, mid = (1 + target) / 2, curSum = small + big;
        while (small < mid){
            if (curSum == target){
                addNumbersToList(small, big);
            }
            while (curSum > target && small < mid){
                curSum -= small;
                small++;
                if (curSum == target)
                    addNumbersToList(small, big);
            }
            big++;
            curSum += big;
        }
        //内部数组的长度可变
        return res.toArray(new int[res.size()][]);
    }

    public void addNumbersToList(int small, int big)
    {
        int[] arr = new int[big - small + 1];
        for (int i = small; i <= big; i++)
        {
            arr[i - small] = i;
        }
        res.add(arr);
    }

}
