package leetcode_2020;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode-cn.com/problems/subsets/
*
* 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
* 说明：解集不能包含重复的子集。
*/
public class code078_Subsets
{
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        List<Integer> l = new ArrayList<>();
        backpack(nums, 0, l);
        return res;
    }

    public void backpack(int[] nums, int start, List<Integer> l)
    {
        res.add(new ArrayList<>(l));
        for (int i = start; i < nums.length; i++)
        {
            l.add(nums[i]);
            backpack(nums, i + 1, l);
            l.remove(l.size() - 1);
        }
    }
}
