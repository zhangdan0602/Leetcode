package leetcode_2020;

import java.util.*;

/**
 * Created by Zd on 2020/1/30.
 */
public class code011_FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange1(int[] nums, int target){
        int rs[] = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                rs[0] = i;
                break;
            }
        }
        if (rs[0] == -1)
            return rs;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (target == nums[i]){
                rs[1] = i;
                break;
            }
        }
        return rs;
    }
    public static int[] searchRange(int[] nums, int target) {
        int rs[] = {-1, -1};
        if (nums.length == 0)
            return rs;

        //left
        int start = 0, end = nums.length;
        while (start < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                end = mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        if (start == nums.length)
            rs[0] = -1;
        if (start < nums.length)
            rs[0] = nums[start] == target ? start : -1;

        //right
        start = 0; end = nums.length;
        while (start < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                start = mid + 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        if (start == 0)
            rs[1] = -1;
        if(end - 1 >= 0)
            rs[1] = nums[end - 1] == target ? end - 1 : -1;
        return rs;
    }

    public static void main(String args[]){
        int[] rs = new int[2];
        rs = searchRange(new int[]{2,2}, 3);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }
}
