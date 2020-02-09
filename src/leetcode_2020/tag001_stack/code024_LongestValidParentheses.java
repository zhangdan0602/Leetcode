package leetcode_2020.tag001_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class code024_LongestValidParentheses
{
    public static int longestValidParentheses(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
        }};
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 2; j <= s.length(); j+=2)
            {
                if(isValid(s.substring(i, j))){
                    count = Math.max(count, j - i);
                }
            }
        }
        return count;
    }
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                stack.push('(');
            else if(!stack.empty() && stack.peek() == '(')
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        System.out.println(longestValidParentheses(")()())"));
    }

}
