package leetcode_2020;

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

    public static int longestValidParentheses1(String s) {
        int rs = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else {
                    rs = Math.max(rs, i - stack.peek());
                }
            }
        }
        return rs;
    }
    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                max = Math.max(max, 2 * right);
            else if (right >= left){
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                max = Math.max(max, 2 * left);
            else if (left >= right){
                left = right = 0;
            }
        }
        return max;
    }
    public static void main(String args[]){
        System.out.println(longestValidParentheses(")()())"));
    }

}
