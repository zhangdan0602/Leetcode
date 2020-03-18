package Point_to_Offer_Version1.数组;

public class P171_31_GreatestSumOfSubarrays
{
    boolean InvalidInput = false;
    // 贪心
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            InvalidInput = true;
            return 0;
        }
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
             if (curSum <= 0)
                 curSum = nums[i];
             else
                 curSum += nums[i];
             if (curSum > maxSum)
                 maxSum = curSum;
        }
        return maxSum;
    }

    // dp
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    public static void main(String[] args){
        P171_31_GreatestSumOfSubarrays greatestSumOfSubarrays = new P171_31_GreatestSumOfSubarrays();
        System.out.println(greatestSumOfSubarrays.maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
