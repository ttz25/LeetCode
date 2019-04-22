package test;

/**2. 两数相加
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *输出：7 -> 0 -> 8
 *原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    /*官方解答*/
    public static  Node addTwoNumbers1(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node p = l1,q=l2,curr = dummyHead;
        int carry = 0;
        while(p != null || q != null){
            int x,y,ans;
            x = p != null ? p.val:0;
            y = q != null ? q.val:0;
            ans = x+y+carry;
            carry = ans /10;
            curr.next = new Node(ans %10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new Node(carry);
        }
        return dummyHead.next;

    }

    public static void main(String args[]){
        Node l1 = new Node(2);
        l1.next = new Node(4);
        Node l2 = new Node(5);
        display( addTwoNumbers1(l1,l2));



    }
    public static class Node{
        public int val;
        public Node next;
        public Node(int x){
            val = x;
        }
    }
    public static void display(Node list){
        Node curr = list;
        while (curr != null){
            if(curr.next != null){
                System.out.print(curr.val+"->");
            }
            else{
                System.out.print(curr.val);
            }
            curr = curr.next;
        }

    }
}
