package leetcode_2020;

/*
* https://leetcode-cn.com/problems/pancake-sorting/
*
* 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
* 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
* 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
*/

import java.util.ArrayList;
import java.util.List;

public class code969_PancakeSorting
{
    List<Integer> res = new ArrayList<>();

    public List<Integer> pancakeSort(int[] A)
    {
        sort(A, A.length);
        System.out.println(res);
        return res;
    }

    public void sort(int[] nums, int n)
    {
        if (n == 1)
            return;
        int maxNum = 0;
        int maxNumIndex = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > maxNum)
            {
                maxNum = nums[i];
                maxNumIndex = i;
            }
        }
        reverse(nums, 0, maxNumIndex);
        res.add(maxNumIndex + 1);
        reverse(nums, 0, n - 1);
        res.add(n);
        sort(nums, n - 1);
    }

    public void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args)
    {
        code969_PancakeSorting pancakeSorting = new code969_PancakeSorting();
        pancakeSorting.pancakeSort(new int[]{3, 2, 4, 1});
        //4 2 3 1 3
        //1 3 2 4 4
        //3 1 2 4 2
        //2 1 3 4 3
        //2 1 3 4 1
        //1 2 3 4 2
    }
}
