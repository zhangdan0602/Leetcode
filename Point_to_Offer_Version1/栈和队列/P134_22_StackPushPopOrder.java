package Point_to_Offer_Version1.栈和队列;

import java.util.Stack;

public class P134_22_StackPushPopOrder
{
    /*
    * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
    但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
    */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> data_stack = new Stack<>();
        int push = 0, pop = 0;
        if (pushed != null && popped != null){
            while (data_stack.isEmpty() || popped[pop] != data_stack.peek()){
                // 避免死循环
                if (push == pushed.length)
                    break;
                if (push < pushed.length){
                    // 不等于弹出元素时，才弹入
                    data_stack.push(pushed[push++]);
                }
                while (!data_stack.isEmpty() && pop < popped.length && popped[pop] == data_stack.peek()){
                    pop++;
                    data_stack.pop();
                }
            }
        }
        return popped.length == pop;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int pop = 0;
        Stack<Integer> data_stack = new Stack<>();
        for (int x: pushed)
        {
            // 先弹入
            data_stack.push(x);
            while (!data_stack.isEmpty() && pop < popped.length && popped[pop] == data_stack.peek()){
                pop++;
                data_stack.pop();
            }
        }
        return pop == popped.length;
    }

    public static void main(String[] args){
        P134_22_StackPushPopOrder stackPushPopOrder = new P134_22_StackPushPopOrder();
        int[] pushed = new int[]{1,2,3,4,5};
        int[] poped = new int[]{4,5,3,1,2};
        System.out.println(stackPushPopOrder.validateStackSequences1(pushed, poped));
        System.out.println(stackPushPopOrder.validateStackSequences(pushed, poped));
    }
}
