package leetcode_2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode-cn.com/problems/permutations/
*给定一个 没有重复 数字的序列，返回其所有可能的全排列。
* */
public class code046_Permutations
{
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums)
    {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        backpack(nums, track);
        return res;
    }

    public void backpack(int[] nums, LinkedList<Integer> track)
    {
        if (track.size() == nums.length)
        {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (track.contains(nums[i]))
                continue;
            track.add(nums[i]);
            backpack(nums, track);
            track.removeLast();
        }
    }
}
