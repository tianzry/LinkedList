package StackAndQueue;

/**
 * Created by tianz on 2017/5/24 0024.
 * 自定义的队列
 */
class QueueNode<T> {
    QueueNode<T> next = null;
    T data;

    public QueueNode(T data) {
        this.data = data;
    }
}
public class MyQueue<T> {
    private QueueNode<T> head = null;
    private QueueNode<T> tail = null;

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(T data) {
        QueueNode<T> newNode = new QueueNode<T>(data);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        T data = head.data;
        head = head.next;
        return data;
    }

    public int size() {
        QueueNode<T> tmp = head;
        int n = 0;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        return n;
    }


    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println("队列长度："+ myQueue.size());
        System.out.println("出队：" + myQueue.dequeue());

    }
}
