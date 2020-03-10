package leetcode_2020;

public class code019_longestCommonPrefix
{
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int location = 0;
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++)
        {
            if (minLength > strs[i].length()){
                minLength = strs[i].length();
                location = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLength; i++)
        {
            int j = 0;
            for (j = 0; j < strs.length; )
            {
                if (j + 1 < strs.length && strs[j].charAt(i) == strs[j + 1].charAt(i)){
                    j++;
                }else {
                    break;
                }
            }
            if (j == strs.length - 1){
                stringBuilder.append(strs[location].charAt(i));
            }else{
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }
    public static String longestCommonPrefix1(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
            {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }   
        }
        return strs[0];
    }
    public static void main(String args[]){
        System.out.println(longestCommonPrefix(new String[]{"lower","flow","flight"}));
    }
}
