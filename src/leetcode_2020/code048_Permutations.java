package leetcode_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zd on 2020/2/18.
 */
public class code048_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int rs = 1;
        for (int i = 1; i <= nums.length; i++) {
            rs *= i;
        }
        List<Integer> internal = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            internal.add(nums[j]);
        }
        res.add(internal);
        for (int i = 1; i < rs; i++) {
            nums = generatePermutation(nums);
            internal = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                internal.add(nums[j]);
            }
            res.add(internal);
        }
        return res;
    }
    public static int[] generatePermutation(int nums[]){
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]){
                        swap(nums, j, i - 1);
                        reverse(nums, i);
                        break;
                    }
                }
                break;
            }
        }
        if (i == 0){
            reverse(nums, i);
        }
        return nums;
    }
    public static void reverse(int nums[], int i){
        int start = i, end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }

    }
    public static void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        System.out.println(permute(new int[]{1,2,3}));
    }

}
