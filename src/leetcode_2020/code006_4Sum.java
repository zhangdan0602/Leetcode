package leetcode_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zd on 2020/1/28.
 */
public class code006_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4)
            return rs;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (i + 3 < nums.length && nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[i] < target)
                continue;
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1, r = nums.length - 1;
                if (l + 1 < nums.length && nums[i] + nums[j] + nums[l] + nums[l + 1] > target)
                    continue;
                if (r > 0 && nums[i] + nums[j] + nums[r] + nums[r - 1] < target)
                    continue;
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target){
                        rs.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && l + 1 < nums.length && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && r > 0 && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    }else if(sum > target)
                        r--;
                    else
                        l++;
                }
            }
        }
        return rs;
    }
    public static void main(String args[]){
        fourSum(new int[]{2, 1, 0, -1}, 2);
    }

}
