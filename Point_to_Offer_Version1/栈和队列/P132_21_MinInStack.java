package Point_to_Offer_Version1.栈和队列;

import java.util.Stack;

public class P132_21_MinInStack
{
    /*
    * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    */
    Stack<Integer> data_stack;
    Stack<Integer> min_stack;

    public P132_21_MinInStack() {
        data_stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        data_stack.push(x);
        if (min_stack.size() == 0 || x <= min_stack.peek()){
            min_stack.push(x);
        }else{
            min_stack.push(min_stack.peek());
        }
    }
    public void push1(int x) {
        data_stack.push(x);
        if (min_stack.size() == 0 || x <= min()){
            min_stack.push(x);
        }else{
            min_stack.push(min());
        }
    }
    public void pop() {
        if (!data_stack.isEmpty())
            data_stack.pop();
        if (!min_stack.isEmpty())
            min_stack.pop();
    }

    public int top() {
        if (!data_stack.isEmpty())
            return data_stack.peek();
        throw new RuntimeException("stack is null");
    }

    public int min() {
        if (!min_stack.isEmpty())
            return min_stack.peek();
        throw new RuntimeException("stack is null");
    }
    public static void main(String[] args){
        P132_21_MinInStack minInStack = new P132_21_MinInStack();
        minInStack.push(-2);
        minInStack.push(0);
        minInStack.push(-1);
        System.out.println(minInStack.data_stack.size());
        System.out.println(minInStack.min_stack.size());
        System.out.println(minInStack.min());
        System.out.println(minInStack.top());
        minInStack.pop();
        System.out.println(minInStack.min());

    }
}
