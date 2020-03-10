package leetcode_2020;
import java.util.*;
/**
 * Created by Zd on 2020/1/28.
 */
public class code005_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int min = 0;
        if(nums == null || nums.length < 3)
            return min;
        Arrays.sort(nums);
        min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r && l < nums.length && r > 0){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(min - target) > Math.abs(sum - target)){
                    min = sum;
                    while (l < r && l + 1 < nums.length && nums[l] == nums[l+1])
                        l++;
                    while (l < r && r > 0 && nums[r] == nums[r-1])
                        r--;
                }
                if(sum > target)
                    r--;
                else if(sum < target)
                    l++;
                else
                    return min;
            }
        }
        return min;
    }
    public static void main(String args[]){
        threeSumClosest(new int[]{-1, 2, 1, 4}, 1);
    }
}
