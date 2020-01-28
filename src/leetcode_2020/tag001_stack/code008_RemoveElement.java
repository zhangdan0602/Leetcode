package leetcode_2020.tag001_stack;

import java.util.HashMap;

/**
 * Created by Zd on 2020/1/28.
 */
public class code008_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    public static int removeElement1(int[] nums, int val) {
        if (nums == null)
            return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                map.put(i, nums[i]);
                nums[count++] = map.get(i);
            }
        }
        return map.size();

    }
    public static void main(String args[]){
        removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);

    }
}
