package Point_to_Offer_Version1.数组;

public class P204_38_NumberOfK
{
    /*
    * 统计一个数字在排序数组中出现的次数。
    * */
    public int search(int[] nums, int target) {
        int number = 0;
        if (nums == null || nums.length == 0)
            return number;
        int first = GetFirstK(nums, target, 0, nums.length - 1);
        int last = GetLastK(nums, target, 0, nums.length - 1);
        if (first > -1 && last > -1){
            number = last - first + 1;
        }
        return number;
    }


    // 第一个location
    public int GetFirstK(int[] nums, int target, int start, int end)
    {
        if (end < start)
            return -1;
        int mid = (start + end) / 2;
        if (target == nums[mid]){
            if ((mid > 0 && nums[mid - 1] != target) || mid == 0){
                return mid;
            }else{
                end = mid - 1;
            }
        }else if (target < nums[mid]){
            end = mid - 1;
        }else {
            start = mid + 1;
        }
        return GetFirstK(nums, target, start, end);
    }

    // last：location
    public int GetLastK(int[] nums, int target, int start, int end)
    {
        if (end < start)
            return -1;
        int mid = (start + end) / 2;
        if (target == nums[mid]){
            if ((mid < nums.length - 1 && nums[mid + 1] != target) || mid == nums.length - 1){
                return mid;
            }else{
                start = mid + 1;
            }
        }else if (target > nums[mid]){
            start = mid + 1;
        }else {
            end = mid - 1;
        }
        return GetLastK(nums, target, start, end);
    }

    public static void main(String[] args){
        P204_38_NumberOfK numberOfK = new P204_38_NumberOfK();
        System.out.println(numberOfK.search(new int[]{8,8,8,8,8,8},8));
    }
}
