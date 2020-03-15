package Point_to_Offer_Version1.数学;

public class P90_11_Power
{
    /*给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方*/
    public static double myPow(double x, int n) {
        // if ((x - 0.0 > -0.0000001) && (0.0 - x < 0.0000001))
        //    return 0;
        if (x == 0)
            return 0.0;
        if (n == 0)
            return 1.0;
        else if (n == 1)
            return x;
        else if (n == -1)
            return 1.0 / x;
        double result = myPow(x, n / 2);
        return result * result * myPow(x, n % 2);
    }

    public double fastPow(double x, long n){
        if (n == 0)
            return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
    public double myPow2(double x, int n){
        long N = n;
        if (n < 0){
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }


    public static void main(String[] args){
        System.out.println(myPow(0, 1));
        System.out.println(myPow(1, 0));
        System.out.println(myPow(2, 1));
        System.out.println(myPow(3, -1));
        System.out.println(myPow(3, 3));
    }
}
