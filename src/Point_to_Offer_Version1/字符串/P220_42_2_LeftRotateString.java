package Point_to_Offer_Version1.字符串;

public class P220_42_2_LeftRotateString
{
    /*
    * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    * */

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0)
            return s;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s.substring(n, s.length())).append(s.substring(0,n));
        return stringBuffer.toString();
    }

    // 2部分 + 1部分
    public String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() == 0)
            return s;
        s = reverseStrs(s.toCharArray(), 0, n - 1);
        s = reverseStrs(s.toCharArray(), n, s.length() - 1);
        return reverseStrs(s.toCharArray(), 0, s.length() - 1);

    }
    public String reverseStrs(char[] strArray, int start, int end)
    {
        while (start < end){
            char c = strArray[start];
            strArray[start++] = strArray[end];
            strArray[end--] = c;
        }
        return new String(strArray);
    }
    public static void main(String[] args){
        P220_42_2_LeftRotateString leftRotateString = new P220_42_2_LeftRotateString();
        System.out.println(leftRotateString.reverseLeftWords1("12345", 2));
    }
}
