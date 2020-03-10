package leetcode_2020;

/**
 * Created by Zd on 2020/1/29.
 */
public class code010_SearchinRotatedSortedArray {
    public static int find_rotation_index(int[] nums){
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        if (nums[start] < nums[end])
            return 0;
        while (start <= end){
            mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            else {
                if (nums[start] <= nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return 0;
    }
    public static int bisearch(int[] nums, int target, int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            else {
                if (target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target? 0 : -1;
        if (target == nums[start])
            return start;
        if (target == nums[end])
            return end;
        if (target == nums[mid])
            return mid;
        int turn = find_rotation_index(nums);
        if (target == nums[turn])
            return turn;
        if (turn - 1 > 0 && target == nums[turn - 1])
            return turn - 1;
        if (turn == 0)
            return bisearch(nums, target, start, end);
        if (target < nums[start])
            return bisearch(nums, target, turn, end);
        return bisearch(nums, target, start, turn);
    }
    public static void main(String args[]){
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
