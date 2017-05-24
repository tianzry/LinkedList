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

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("栈顶：" + stack.peek());
        stack.pop();
        System.out.println("出栈后：" + stack.peek());
    }
}
