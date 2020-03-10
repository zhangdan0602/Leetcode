package leetcode_2020;

/**
 * Created by Zd on 2020/1/27.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class code004_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return out;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r && l < nums.length && r > 0){

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    out.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l+1 < nums.length && l < r && nums[l] == nums[l+1])
                        l++;
                    while (r-1 > 0 && l < r && nums[r] == nums[r-1])
                        r--;
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else
                    r--;
            }
        }
        return out;
    }
    public static void main(String args[]){
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
