package leetcode_2020.tag001_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class code021_ValidParentheses
{
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]){

    }
}
