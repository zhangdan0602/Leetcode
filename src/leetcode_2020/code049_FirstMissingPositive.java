package leetcode_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class code049_FirstMissingPositive
{
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        for (int i = 0; i < nums.length;)
        {
            if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]){
                i++;
                continue;
            }
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
        for (int j = 0; j < nums.length; j++)
        {
            if (nums[j] != j + 1){
                return j + 1;
            }
        }
        return nums.length + 1;
    }
    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
