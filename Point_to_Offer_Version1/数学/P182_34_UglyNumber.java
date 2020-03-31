package Point_to_Offer_Version1.数学;

public class P182_34_UglyNumber
{
    /*
    * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
    */
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return n;
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int pMultiply2 = 0, pMultiply3 = 0, pMultiply5 = 0;
        for (int i = 1; i < n; i++)
        {
            int min = getMin(uglyNumber[pMultiply2] * 2, uglyNumber[pMultiply3] * 3, uglyNumber[pMultiply5] * 5);
            uglyNumber[i] = min;
            while (uglyNumber[pMultiply2] * 2 <= min)
                pMultiply2++;
            while (uglyNumber[pMultiply3] * 3 <= min)
                pMultiply3++;
            while (uglyNumber[pMultiply5] * 5 <= min)
                pMultiply5++;
        }
        return uglyNumber[n - 1];
    }

    private int getMin(int i, int i1, int i2)
    {
        int min = i < i1 ? i : i1;
        min = min < i2 ? min : i2;
        return min;
    }


    // timeout
    public boolean isUglyNumber(int n){
        while (n % 2 == 0){
            n /= 2;
        }
        while (n % 3 == 0){
            n /= 3;
        }
        while (n % 5 == 0){
            n /= 5;
        }
        return n == 1 ? true : false;
    }
    public int nthUglyNumber1(int n) {
        if (n <= 0)
            return n;
        int number = 0, uglyCount = 0;
        while (uglyCount < n){
            ++number;
            if (isUglyNumber(number) == true)
                uglyCount++;
        }
        return number;
    }


    public static void main(String[] args){
        P182_34_UglyNumber uglyNumber = new P182_34_UglyNumber();
        System.out.println(uglyNumber.nthUglyNumber(10));
    }
}
