package leetcode_2020;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zd on 2020/1/26.
 */
public class code001_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numbers  = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            numbers.put(nums[i], i);
        for (int i = 0; i < nums.length; i++){
            int another = target - nums[i];
            if (numbers.containsKey(target - nums[i]) && numbers.get(target - nums[i]) != i)
                return new int[]{i, numbers.get(target - nums[i])};
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numbers  = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (numbers.containsKey(target - nums[i]) && numbers.get(target - nums[i]) != i)
                return new int[]{numbers.get(target - nums[i]), i};
            numbers.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String args[]){
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
        int[] rs = twoSum(new int[]{2, 7, 11, 15}, 9);
        for(int i = 0; i < rs.length; i++){
            System.out.println(rs[i]);
        }
    }
}
