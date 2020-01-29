package leetcode_2020.tag001_stack;

import java.util.Arrays;

/**
 * Created by Zd on 2020/1/29.
 */
public class code009_NextPermutation {
    public static void nextPermutation(int[] nums) {
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

    public static void nextPermutation1(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
                int min = nums[i] - nums[i - 1];
                int k = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        if (min > nums[j] - nums[i - 1]) {
                            min = nums[j] - nums[i - 1];
                            k = j;
                        }
                    }
                }
                int tmp = nums[i - 1];
                nums[i - 1] = nums[k];
                nums[k] = tmp;
                int newNums[] = new int[nums.length - i];
                for (int n = 0; n < newNums.length; n++) {
                    newNums[n] = nums[n + i];
                }
                Arrays.sort(newNums);
                for (int m = i; m < nums.length; m++) {
                    nums[m] = newNums[m - i];
                }
                break;
            }
        }
        if (i == 0){
            for (int j = 0; j < nums.length/2; j++) {
                int tmp = nums[j];
                nums[j] = nums[nums.length - j - 1];
                nums[nums.length - j - 1] = tmp;
            }
        }
    }
    public static void main(String args[]){
        nextPermutation(new int[]{0,1,2});
    }
}
