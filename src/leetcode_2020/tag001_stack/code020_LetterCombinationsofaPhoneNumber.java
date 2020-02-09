package leetcode_2020.tag001_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code020_LetterCombinationsofaPhoneNumber
{
    static Map<String, String> phone = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public static void backtrack(List<String> result, String combination, String next_digits){
        if (next_digits.length() == 0){
            result.add(combination);
        }else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++)
            {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(result, combination + letter, next_digits.substring(1));
            }
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.length() != 0){
            backtrack(output, "", digits);
        }
        return output;
    }

    public static void main(String args[]){
        System.out.println(letterCombinations("23"));

    }
}
