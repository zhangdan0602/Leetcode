package leetcode_2020.tag001_stack;

public class code016_StringtoInteger_atoi
{
    public static int myAtoi(String str) {
        int numstart = 0, count = 0;
        String rs = "";
        int num = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != ' '){
                numstart = i;
                rs = str.substring(numstart);
                break;
            }else
                count++;
        }
        System.out.println(rs);
        if (count == str.length())
            return 0;

        if (str.charAt(numstart) == '+' || str.charAt(numstart) == '-'){
            if (rs.length() == 1)
                return 0;
            rs = rs.substring(1, rs.length());
            num = getNumber(rs);
        }else
            num = getNumber(rs);
        return num;
    }
    public static int getNumber(String s){
        int rs = 0;
        for (int i = s.length() - 1; i >=0 ; i--)
        {
            rs += (s.charAt(i) - '0') * Math.pow(10, s.length() - 1 - i);
        }
        return rs;
    }
    public static void main(String args[]){
        System.out.println(myAtoi(" -45"));
    }
}
