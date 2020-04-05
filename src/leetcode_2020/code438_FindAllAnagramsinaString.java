package leetcode_2020;

/*
* https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
*
* 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
* 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
    说明：

    字母异位词指字母相同，但排列不同的字符串。
    不考虑答案输出的顺序。
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class code438_FindAllAnagramsinaString
{
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0)
        {
            return list;
        }
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        int left = 0, right = 0;
        for (int i = 0; i < p.length(); i++)
        {
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);
        }
        int match = 0;
        while (right < s.length())
        {
            char c = s.charAt(right);
            if (needs.containsKey(c))
            {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (needs.get(c).compareTo(window.get(c)) == 0)
                {
                    match++;
                }
            }
            right++;

            while (match == needs.size())
            {
                if (right - left == p.length())
                {
                    list.add(left);
                }
                char c1 = s.charAt(left);
                if (needs.containsKey(c1))
                {
                    int num = window.get(c1);
                    window.put(c1, num - 1);
                    if (window.get(c1) < needs.get(c1))
                        match--;
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        code438_FindAllAnagramsinaString minimumWindowSubstring = new code438_FindAllAnagramsinaString();
        System.out.println(minimumWindowSubstring.findAnagrams("EBBANCF", "ABC"));
        System.out.println(minimumWindowSubstring.findAnagrams("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubstring.findAnagrams("baa", "aa"));

    }
}
