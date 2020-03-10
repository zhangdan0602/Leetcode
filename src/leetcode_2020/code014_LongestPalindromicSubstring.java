package leetcode_2020;

public class code014_LongestPalindromicSubstring
{
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        String rs = s.substring(0,1);
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++)
        {
            String len1 = expandAroundCentre(s, i, i);
            String len2 = expandAroundCentre(s, i, i + 1);
            String len = len1.length() > len2.length()? len1 : len2;
            if (len.length() > maxLen){
                maxLen = len.length();
                rs = len;
            }
        }
        return rs;
    }
    public static String expandAroundCentre(String s, int start, int end){
        int l = start, r = end;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
    public static void main(String agrs[]){
        System.out.println(longestPalindrome("babad"));
    }

}
