package Point_to_Offer_Version1.其他;

import java.util.Arrays;

public class P224_44_ContinousCards
{
    /*
    * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] == 0)
                continue;
            if (nums[i] == nums[i + 1])
                return false;
            sum += nums[i + 1] - nums[i];
        }
        return sum < 5;
    }
    public static void main(String[] args){
        P224_44_ContinousCards continousCards = new P224_44_ContinousCards();
        System.out.println(continousCards.isStraight(new int[]{0,0,1,2,5}));
    }
}
