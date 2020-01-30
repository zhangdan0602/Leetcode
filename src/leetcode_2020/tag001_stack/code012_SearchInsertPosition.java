package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/1/30.
 */
public class code012_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (target <= nums[0])
            return 0;
        if (target > nums[nums.length - 1])
            return nums.length;
        if (target == nums[nums.length - 1])
            return nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            if (nums[i - 1] < target && target < nums[i])
                return i;
        }
        return 0;
    }

    public static int searchInsert1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
    public static void main(String args[]){

    }
}
