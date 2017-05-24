package StackAndQueue;

/**
 * Created by tianz on 2017/5/24 0024.
 * 实现栈基本功能
 */
class StackNode<T> {
    StackNode<T> next = null;
    T data;

    public StackNode(T data) {
        this.data = data;
    }
}
public class MyStack<T> {
    StackNode<T> top = null;

    /**
     * 判断是否栈空
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 入栈
     * @param data
     */
    public void push(T data) {
        StackNode<T> newNode = new StackNode<T>(data);
        newNode.next = top;
        top = newNode;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    /**
     * 读取栈顶元素
     * @return
     */
    public T peek() {
        if (isEmpty()) return null;
        return top.data;
        
    }

    /**
     * 该类实现o(1)求栈中最小的元素
     */
    static class MinStack {
        MyStack<Integer> elem;
        MyStack<Integer> min;

        public MinStack() {
            elem = new MyStack<>();
            min = new MyStack<>();
        }

        public void push(int data) {
            elem.push(data);
            if (min.isEmpty()){
                min.push(data);
            } else if (min.peek() > data){
                min.push(data);
            }
        }

        public int pop() {
            int data = elem.pop();
            if (data == min())
                min.pop();
            return data;
        }

        public int min() {
            if (min.isEmpty())
                return Integer.MAX_VALUE;
            else 
                return min.peek();
        }
    }


    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("栈顶：" + stack.peek());
        stack.pop();
        System.out.println("出栈后：" + stack.peek());
        
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(8);
        minStack.push(3);
        minStack.push(4);
//        minStack.pop();
//        minStack.pop();
        System.out.println("当前栈最小的："+minStack.min());
    }
}
