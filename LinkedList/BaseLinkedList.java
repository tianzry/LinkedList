package LinkedList;

import java.util.Hashtable;

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
        System.out.println();
    }

    /**
     * 删除链表里头重复的元素，空间复杂度
     * @param head
     */
    public void deleteDuplecate(Node head) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Node tmp = head;
        Node pre = null;
        while (tmp != null) {
            if (table.containsKey(tmp.data)) { //包含这个关键字
                pre.next = tmp.next;
            } else {
                table.put(tmp.data, 1);
                pre = tmp;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 找出倒数第n个元素
     * @param head 头结点
     * @param k 倒数元素
     * @return 找到的元素
     */
    public Node findReverseElem(Node head, int k) {
        if (k < 1 || k > nodeLength()) {
            return null;
        }
        Node pFirst = head;
        Node pSecond = head;
        for (int i = 0; i < k - 1; i++) {
            pSecond = pSecond.next;
        }
        while (pSecond.next != null) { //注意判断条件
            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
        return pFirst;
    }

    /**
     * 非递归方式反转一个链表
     * @param head
     */
    public void reverse(Node head) {
        Node preNode = null;
        Node curNode = head;
        Node nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            if (nextNode == null)
                this.head = curNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
    }

    public void printReversely(Node head) {
        if (head != null) {
            printReversely(head.next);
            System.out.print(head.data+" ");
        }
    }

    /**
     * 查找链表的中间节点，注意判断条件
     * @param head 头结点
     * @return
     */
    public Node searchMid(Node head) {
        Node pFast = head;
        Node pSlow = head;
        // 判断条件如果为pFast != null && pFast.next != null && pFast.next.next != null 会产生空指针异常
        while (pFast != null && pFast.next != null) {
            if (pFast.next.next == null) {
                break;
            }
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        return pSlow;
    }

    /**
     * 判断一个链表是否成环
     * @param head
     * @return
     */
    public boolean isLoop(Node head) {
        Node pFast = head;
        Node pSlow = head;
        if (head == null) return false;
        while (pFast.next != null) {
            if (pFast.next.next == null) return false;
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) return true;
        }
        return false;
    }

    /**
     * 查找环的入口，在判断是否为环的基础之上
     * @param head
     * @return
     */
    public Node findLoopEntry(Node head) {
        Node pFast = head;
        Node pSlow = head;
        if (pFast == null) return null;
        while (pFast.next != null) {
            if (pFast.next.next == null) return null;
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) break;
        }
        pSlow = head; //关键点
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow =  pSlow.next;
        }
        return pSlow;
    }

    /**
     * 不知道头节点的情况下删除下一个节点，利用值交换，避免了查找前驱节点
     * @param node
     * @return
     */
    public boolean deleteNodeWithoutHead(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }

    /**
     * 判断两个链表是否相交
     * @param node1
     * @param node2
     * @return
     */
    public boolean isIntersect(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        Node tail1 = node1;
        Node tail2 = node2;
        while (tail1.next != null)
            tail1 = tail1.next;
        while (tail2.next != null)
            tail2 = tail2.next;
        return tail1 == tail2;
    }





    public static void main(String[] args) {
        BaseLinkedList linkedList = new BaseLinkedList();
        linkedList.addNode(5);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(2);
        linkedList.addNode(6);
        System.out.println("输出链表：");
        linkedList.printLinkedList();
        System.out.println("长度为："+linkedList.nodeLength());
        linkedList.sort();
        System.out.println("排序后：");
        linkedList.printLinkedList();
        linkedList.deleteNode(3);
        System.out.println("删除第2个：");
        linkedList.printLinkedList();
        System.out.println("删除重复的元素后：");
        linkedList.deleteDuplecate(linkedList.head);
        linkedList.printLinkedList();
        System.out.println("查找倒数第2个元素后：");
        Node findNode = linkedList.findReverseElem(linkedList.head, 2);
        System.out.println(findNode.data);

        System.out.println("反转一个链表后：");
        linkedList.reverse(linkedList.head);
        linkedList.printLinkedList();

        System.out.println("递归反转打印一个链表：");
        linkedList.printReversely(linkedList.head);

        System.out.println("\n查找中间的值：");
        System.out.println(linkedList.searchMid(linkedList.head).data);

        // 将链表变换为环
        Node tmp = linkedList.head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = linkedList.head;

        System.out.println("判断是否为环：");
        System.out.println(linkedList.isLoop(linkedList.head));

        System.out.println(linkedList.findLoopEntry(linkedList.head).data);


    }
}
