package Point_to_Offer_Version1.数组;

public class P214_41_TwoNumbersWithSum
{
    /*
    * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
    */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                res[0] = nums[left];
                res[1]= nums[right];
                return res;
            }else if (sum < target){
                left++;
            }else
                right--;
        }
        return res;
    }
    public static void main(String[] args){
        P214_41_TwoNumbersWithSum twoNumbersWithSum = new P214_41_TwoNumbersWithSum();
        int[] res = twoNumbersWithSum.twoSum(new int[]{2,7,11,15}, 9);
        for (int r:res)
        {
            System.out.println(r);
        }
    }
}

