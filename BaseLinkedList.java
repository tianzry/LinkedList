/**
 * Created by tianz on 2017/5/23 0023.
 *
 * 实现单链表的基本操作
 */
public class BaseLinkedList {
    // 头结点
    Node head = null;

    /**
     * 计算链表的长度
     *
     * @return 返回链表的长度
     */
    public int nodeLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
    /**
     * 添加节点到单链表的结尾
     *
     * @param data 需要添加的数据
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 删除索引处的节点
     *
     * @param index 删除索引
     * @return 成功删除返回true，否则返回false
     */
    public Boolean deleteNode(int index) {
        if (index < 1 || index > nodeLength()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if (++i == index) { // 注意这里，需要先+1再比较，否则删除会滞后
                pre.next = cur.next;
                return true;
            }
            pre = cur;
            cur = cur.next;

        }
        return true;
    }


    /**
     * 使用冒泡排序
     * @return 返回头节点
     */
    public Node sort() {
        Node curNode = head;
        Node nextNode;
        int temp; //作为值交换的中介
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    temp = nextNode.data;
                    nextNode.data = curNode.data;
                    curNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 打印出链表
     */
    public void printLinkedList() {
        Node nextNode = head;
        while (nextNode != null) {
            System.out.print(nextNode.data + " ");
            nextNode = nextNode.next;
        }
        if (head.next == null) {
            System.out.print(head.data);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BaseLinkedList linkedList = new BaseLinkedList();
        linkedList.addNode(5);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(1);
        linkedList.addNode(2);
        System.out.println("输出链表：");
        linkedList.printLinkedList();
        System.out.println("长度为："+linkedList.nodeLength());
        linkedList.sort();
        System.out.println("排序后：");
        linkedList.printLinkedList();
        linkedList.deleteNode(3);
        System.out.println("删除第2个：");
        linkedList.printLinkedList();
    }
}
