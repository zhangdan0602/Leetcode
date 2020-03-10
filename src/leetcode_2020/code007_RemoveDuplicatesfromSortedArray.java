package leetcode_2020;

import java.util.HashMap;

/**
 * Created by Zd on 2020/1/28.
 */
public class code007_RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
                nums[count++] = nums[i];
            }
        }
        return map.size();
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums == null)
            return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
    public static void main(String args[]){
        //nums = [0,0,1,1,1,2,2,3,3,4]
        //0, 1, 2, 3, 4
        //0, 2, 5, 7, 9
        removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
