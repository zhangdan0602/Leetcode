package leetcode_2020.tag001_stack;

public class code016_StringtoInteger_atoi
{
    public static int myAtoi(String str) {
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
    public static void main(String args[]){
        System.out.println(myAtoi("45 abc"));
    }
}
