package Point_to_Offer_Version1.字符串;

public class P244_49_StringToInt
{
    /*
    * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
    */
    public int strToInt(String str) {
        if (str.isEmpty())
            return 0;
        int flag = 1, i = 0;
        long rs = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i < str.length() && str.charAt(i) == '+')
            i++;
        else if (i < str.length() && str.charAt(i) == '-'){
            i++;
            flag = -1;
        }
        while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')){
            if (rs != (int)rs){
                return (flag == 1 )? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            rs = rs * 10 + str.charAt(i++) - '0';
        }
        if (rs != (int)rs){
            return (flag == 1 )? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)rs * flag;
    }
    public static void main(String[] args){
        P244_49_StringToInt stringToInt = new P244_49_StringToInt();
        System.out.println(stringToInt.strToInt("+123"));
    }
}
