package leetcode_2020;
/*

https://leetcode-cn.com/problems/basic-calculator/

实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

扩展： * /

* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code224_CalculatorI
{
    public int calculate(String s)
    {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));
        return helper(list);
    }

    public int helper(List<Character> s)
    {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0, res = 0;
        while (s.size() > 0)
        {
            char c = s.remove(0);
            if (Character.isDigit(c))
            {
                num = 10 * num + (c - '0');
            }
            if (c == '(')
                num = helper(s);
            if ((!Character.isDigit(c) && c != ' ') || s.size() == 0)
            {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                {
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/')
                {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
            if (c == ')')
            {
                break;
            }
        }
        while (!stack.isEmpty())
        {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args)
    {
        code224_CalculatorI calculator = new code224_CalculatorI();
        System.out.println(calculator.calculate("2 * (3 + 5)"));
        System.out.println(calculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
