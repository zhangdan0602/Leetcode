package Point_to_Offer_Version1.栈和队列;

import java.util.Stack;

public class P59_07_QueueWithTwoStacks
{
    /*
    * 用两个栈来实现一个队列，完成队列的appendTail和deleteHead操作。
    */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public P59_07_QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }
    public static void main(String[] args){
        P59_07_QueueWithTwoStacks queue = new P59_07_QueueWithTwoStacks();
        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.stack1);
        System.out.println(queue.stack2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.stack1);
        System.out.println(queue.stack2);
        System.out.println(queue.deleteHead());
    }
}
