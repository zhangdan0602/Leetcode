package Point_to_Offer_Version1.数组;

import java.util.Arrays;
import java.util.Comparator;

public class P177_33_SortArrayForMinNumber
{
    /*
    * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
    则打印出这三个数字能排成的最小数字为321323。
    */
    class CompareStr implements Comparator<String>{
        @Override
        public int compare(String o1, String o2)
        {
            String o12 = o1 + o2, o21 = o2 + o1;
            return o12.compareTo(o21);
        }
    }
    public String minNumber(int[] nums) {
        String result = "";
        if (nums == null || nums.length == 0)
            return result;
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            numbers[i] = String.valueOf(nums[i]);
        }
        // 字符串数组排序、merge
        Arrays.sort(numbers, new CompareStr());
        for (String s:numbers)
        {
            result += s;
        }
        return result;
    }

    public static void main(String[] args){
        P177_33_SortArrayForMinNumber sortArrayForMinNumber = new P177_33_SortArrayForMinNumber();
        System.out.println(sortArrayForMinNumber.minNumber(new int[]{3,30,34,5,9}));
    }
}
