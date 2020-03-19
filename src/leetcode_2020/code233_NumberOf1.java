package leetcode_2020;

public class code233_NumberOf1
{
    /*
    输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    */
    //数学规律
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        int count = 0, weight = 1, base = 1, former = 0, round = n;
        while (round != 0){
            weight = round % 10;
            round = round / 10;
            former = n % base;
            if (weight > 1){
                count += (round * base + base);
            }else if (weight == 1){
                count += (round * base + former + 1);
            }else {
                count += (round *base);
            }
            base *= 10;
        }
        return count;
    }
    //超时
    public int countDigitOne1(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++)
        {
            num += NumberOf1(i);
        }
        return num;
    }

    public int NumberOf1(int n)
    {
        int number = 0;
        while (n != 0){
            if (n % 10 == 1){
                number++;
            }
            n /= 10;
        }
        return number;
    }
    public static void main(String[] args){
        code233_NumberOf1 p147_32_numberOf1 = new code233_NumberOf1();
        System.out.println(p147_32_numberOf1.countDigitOne(12));
    }
}
