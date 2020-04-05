package leetcode_2020;

/*
* https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
*
* 你的算法时间复杂度必须是 O(log n) 级别。
*
* 如果数组中不存在目标值，返回 [-1, -1]
*/
public class code034_firstAndLastBybinarySearch
{
    public int[] searchRange(int[] nums, int target)
    {
        int rs[] = {-1, -1};
        if (nums.length == 0)
            return rs;

        //left
        int start = 0, end = nums.length - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
        }
        if (start >= nums.length || nums[start] != target)
            rs[0] = -1;
        else
            rs[0] = start;

        //right
        start = 0;
        end = nums.length - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                start = mid + 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
        }
        if (end < 0 || nums[end] != target)
            rs[1] = -1;
        else
            rs[1] = end;
        return rs;
    }
}
