package leetcode_2020;

/*
* https://leetcode-cn.com/problems/binary-search/
*
* 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
* 如果目标值存在返回下标，否则返回 -1。
*/
public class code070_binarySearch
{
    public int search(int[] nums, int target)
    {
        int start = 0, end = nums.length - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else if (nums[mid] > target)
            {
                end = mid - 1;
            }
        }
        return -1;
    }
}
