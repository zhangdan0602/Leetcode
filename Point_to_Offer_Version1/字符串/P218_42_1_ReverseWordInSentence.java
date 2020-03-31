package Point_to_Offer_Version1.字符串;

public class P218_42_1_ReverseWordInSentence
{
    /*
    * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
    */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return null;
        char[] strArray = s.toCharArray();
        s = reverseStrs(strArray, 0, s.length() - 1);
        int begin = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                reverseStrs(strArray, begin, i - 1);
                begin = i + 1;
            }
        }
        s = reverseStrs(strArray, begin, s.length() - 1);
        return s;
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

    public String reverseWords1(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] r = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = r.length - 1; i >= 0; i--)
        {
            if (!r[i].equals("")){
                stringBuffer.append(r[i]).append(" ");
            }
        }
        return stringBuffer.toString().trim();
    }
    public static void main(String[] args){
        P218_42_1_ReverseWordInSentence continuesSequenceWithSum = new P218_42_1_ReverseWordInSentence();
        System.out.println(continuesSequenceWithSum.reverseWords1("12345  54321 am"));
    }
}
