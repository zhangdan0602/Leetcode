package Point_to_Offer_Version1.字符串;

public class P44_04_ReplaceBlank
{
    /*
    * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    * w例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    */
    public static String replaceSpace(String s) {
        if (s.length() == 0 || s == null)
            return s;
        int originalLength = s.length();
        int numberofBlank = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
                numberofBlank++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(originalLength + numberofBlank * 2);
        int p1 = s.length() - 1, p2 = stringBuffer.length() - 1;
        while (p1 >= 0 && p1 <= p2){
            if (s.charAt(p1) == ' '){
                stringBuffer.setCharAt(p2--, '0');
                stringBuffer.setCharAt(p2--, '2');
                stringBuffer.setCharAt(p2--, '%');
                p1--;
            }else {
                stringBuffer.setCharAt(p2--, s.charAt(p1--));
            }
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args){
        System.out.println(replaceSpace("We are happy"));
    }

}
