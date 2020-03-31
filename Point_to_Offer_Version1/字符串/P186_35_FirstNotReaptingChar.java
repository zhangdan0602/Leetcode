package Point_to_Offer_Version1.字符串;

import java.util.HashMap;

public class P186_35_FirstNotReaptingChar
{
    /*
    * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
    */
    // hashmap
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hashMap.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }

    // array
    public char firstUniqChar1(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        int[] count = new int[58];
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            count[c - 'A']++;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (count[c - 'A'] == 1){
                return c;
            }
        }
        return ' ';

    }

    // index
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c))
                return c;
        }
        return ' ';
    }

    public static void main(String[] args){
        P186_35_FirstNotReaptingChar firstNotReaptingChar = new P186_35_FirstNotReaptingChar();
        System.out.println(firstNotReaptingChar.firstUniqChar("abaccdeff"));
    }
}
