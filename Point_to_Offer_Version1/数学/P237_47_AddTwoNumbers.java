package Point_to_Offer_Version1.数学;

public class P237_47_AddTwoNumbers
{
    /*
    * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    * */
    public int add(int a, int b) {
        int sum = 0, carry = 1;
        while (carry != 0){
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    // 递归
    public int add1(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add1(sum, carry);
    }

    public static void main(String[] args){
        P237_47_AddTwoNumbers addTwoNumbers = new P237_47_AddTwoNumbers();
        System.out.println(addTwoNumbers.add(3,4));
    }
}
