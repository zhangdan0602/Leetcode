package code020_ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static boolean isValid(String s) {
		
		HashMap<Character, Character> map=new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			//判断到是 右括号
			if (map.containsKey(c)) {
				//弹出栈顶元素
				char topElement=stack.empty()?'#':stack.pop();
				//栈顶元素与右括号对应的左括号是否相同
				if (topElement!=map.get(c)) {
					//不相同，直接return false
					return false;
				}
				
			}else{
				//判断到是 左括号，加入栈
				stack.push(c);
			}
		}
		//最后栈是否为空，返回结果。
		return stack.isEmpty();
		
	
		
		//不可以这样写，当没有左括号时，topElement=null，map.get(topElement)报空指针。
		//c!=map.get(topElement)
		
		
	}

	public static void main(String[] args) {
		isValid("");
	}
}
