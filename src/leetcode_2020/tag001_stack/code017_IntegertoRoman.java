package leetcode_2020.tag001_stack;

public class code017_IntegertoRoman
{
    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int nums[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String strs[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (i < nums.length)
        {
            if (num >= nums[i]){
                stringBuilder.append(strs[i]);
                num = num - nums[i];
            }else{
                i++;
            }
        }
        return stringBuilder.toString();
    }

    public static String intToRoman1(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int nums[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String strs[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num > 0)
        {
            int count = num / nums[i];
            while (count-- > 0){
                stringBuilder.append(strs[i]);
            }
            num %= nums[i];
            i++;
        }
        return stringBuilder.toString();
    }
    public static void main(String args[]){
        System.out.println(intToRoman1(1994));
    }
}
