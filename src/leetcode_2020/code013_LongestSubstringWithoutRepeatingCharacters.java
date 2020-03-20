package leetcode_2020;

import java.util.*;

public class code013_LongestSubstringWithoutRepeatingCharacters
{
    public static int lengthOfLongestSubstring(String s) {
        /*
        *输入: "pwwkew"
        输出: 3 */
        int[] dp = new int[s.length() + 1];
        int answer = 0;
        for (int i = 0; i < s.length(); i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (s.charAt(j) <= s.charAt(i) && i - j == 1)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        return answer;
        /*

        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        String beforers = "";
        String rs = "";
        for (int i = 0; i < s.length(); i++){
            for (int k = i; k < s.length(); k++)
            {
                if (!rs.contains(String.valueOf(s.charAt(k)))){
                    rs = rs + s.charAt(k);
                }
                else{

                    if (rs.length() > beforers.length()){
                        beforers = rs;
                    }
                    rs = "";
                    break;
                }
            }
        }
        System.out.println(beforers);
        return beforers.length();
        */
    }

    public static int lengthOfLongestSubstring1(String s) {
        int max = 0;
        for (int i = 0; i < s.length() ; i++)
        {
            for (int j = i + 1; j <= s.length(); j++)
            {
                if (allUnique(s, i, j))
                    max = Math.max(max, j - i);
            }   
        }
        return max;
    }
    public static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++)
        {
            if (set.contains(s.charAt(i)))
                return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int max = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int max = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < s.length(); k++)
        {
            if (map.containsKey(s.charAt(k)))
                i = Math.max(map.get(s.charAt(k)), i);
            max = Math.max(max, k - i + 1);
            map.put(s.charAt(k), k + 1);
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("aabbccdefji"));
    }
}
