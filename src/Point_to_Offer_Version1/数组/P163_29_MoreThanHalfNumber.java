package Point_to_Offer_Version1.数组;

public class P163_29_MoreThanHalfNumber
{
    /*
    * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = nums[0], times = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (times == 0)
            {
                result = nums[i];
                times++;
            }else if (nums[i] == result){
                times++;
            }else
                times--;
        }
        if (!CheckMoreThanHalf(nums, result))
            return 0;
        return result;
    }

    /*
    * 再次判断是否大于一半*/
    private boolean CheckMoreThanHalf(int[] nums, int result)
    {
        int times = 0;
        boolean isMoreThanHalf = true;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == result)
                times++;
        }
        if (times * 2 <= nums.length){
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
    public static void main(String[] args){
        P163_29_MoreThanHalfNumber moreThanHalfNumber = new P163_29_MoreThanHalfNumber();
        System.out.println(moreThanHalfNumber.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
