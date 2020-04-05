package leetcode_2020;
/*

https://leetcode-cn.com/problems/calculator-lcci/

给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

* */

import java.util.Stack;

public class code227_CalculatorII
{
    public int calculate(String s)
    {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                num = 10 * num + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1)
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
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty())
        {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args)
    {
        code227_CalculatorII calculator = new code227_CalculatorII();
        System.out.println(calculator.calculate("1 - 12 + 3"));
    }
}
