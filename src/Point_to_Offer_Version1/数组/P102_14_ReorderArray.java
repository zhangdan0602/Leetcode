package Point_to_Offer_Version1.数组;

public class P102_14_ReorderArray
{
    /*
    *
    * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    * */
    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            while (left < right && (nums[left] % 2 != 0))
                left++;
            while (left < right && (nums[right] % 2 == 0))
                right--;
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = exchange(new int[]{1,2,3,4,5});
        for (int i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }
    }
}
