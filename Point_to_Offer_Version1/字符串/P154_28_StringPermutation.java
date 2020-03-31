package Point_to_Offer_Version1.字符串;

import java.util.*;

public class P154_28_StringPermutation
{
    /*
    * 输入一个字符串，打印出该字符串中字符的所有排列。
    */
    // 避免重复
    Set<String> list = new TreeSet<>();
    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[]{};

        char[] str = s.toCharArray();
        Arrays.sort(str);

        permutationHelper(str, 0);
        
        String[] res = new String[list.size()];
        int i = 0;
        for (String string:list)
        {
            res[i++] = string;
        }
        return res;
    }

    private void permutationHelper(char[] s, int begin)
    {
        if (begin == s.length){
            list.add(String.valueOf(s));
            return;
        }

        for (int i = begin; i < s.length; i++)
        {
            if (i != begin && (s[i] == s[begin] || s[i] == s[i - 1]))
                continue;

            char temp = s[i];
            s[i] = s[begin];
            s[begin] = temp;

            permutationHelper(s, begin + 1);

            temp = s[i];
            s[i] = s[begin];
            s[begin] = temp;
        }
    }
    public static void main(String[] args){
        P154_28_StringPermutation stringPermutation = new P154_28_StringPermutation();
        String[] res = stringPermutation.permutation("vpvptjzh");
        for (String s:res)
        {
            System.out.println(s);
        }
        System.out.println(res.length);
    }
}
