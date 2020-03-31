package Point_to_Offer_Version1.数组;

public class P211_40_NumbersAppearOnce
{
    /*
    * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
    */
    public int[] singleNumbers(int[] nums)
    {
        if (nums == null || nums.length <= 1)
        {
            return new int[2];
        }
        int val = 0;
        for (int v:nums)
        {
            val ^= v;
        }

        // 1 的位置
        int index = 0;
        while ((val & 1) == 0 && (index < Integer.MAX_VALUE)){
            val = val >> 1;
            index++;
        }

        // 分组
        int num1 = 0, num2 = 0;
        for (int v:nums)
        {
            if (isSame(v, index)){
                num1 ^= v;
            }else
                num2 ^= v;
        }

        return new int[]{num1, num2};

    }

    // 判断相同位置是否为1
    public boolean isSame(int v, int index)
    {
        v = v >> index;
        if ((v & 1) == 0)
            return false;
        return true;
    }

    public static void main(String[] args){
        P211_40_NumbersAppearOnce numbersAppearOnce = new P211_40_NumbersAppearOnce();
        numbersAppearOnce.singleNumbers(new int[]{2,4,3,6,3,2,5,5});
    }
}
