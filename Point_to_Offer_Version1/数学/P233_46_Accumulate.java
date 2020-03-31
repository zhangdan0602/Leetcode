package Point_to_Offer_Version1.数学;

public class P233_46_Accumulate
{
    /*
    * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    */
    public int sumNums(int n) {
        int sum = n;
        boolean res = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
    public static void main(String[] args){
        P233_46_Accumulate accumulate = new P233_46_Accumulate();
        System.out.println(accumulate.sumNums(5));
    }
}
