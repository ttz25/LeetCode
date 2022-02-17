package com.ttz;

/**2. 两数相加
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *输出：7 -> 0 -> 8
 *原因：342 + 465 = 807
 */
public class Question_2 {

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
//        Node l1 = new Node(2);
//        l1.next = new Node(4);
//        Node l2 = new Node(5);
//        display( addTwoNumbers1(l1,l2));

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        display2( addTwoNumbers2(l1,l2));

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

    public static void display2(ListNode list){
        ListNode curr = list;
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


    /**
     * 链表转整型再相加，简直是脑袋有泡，遇到长链表都超过整型范围了！！！
     * 既然是链表，就应该按链表的计算方式解决问题
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1=0,num2=0, num3=0,i=10;
        num1 += l1.val;
        while (l1.next != null) {
            num1 += l1.next.val*10;
            i = i*10;
            l1 = l1.next;
        }
        i=10;
        num2 += l2.val;
        while (l2.next != null) {
            num2 += l2.next.val*10;
            i = i*10;
            l2 = l2.next;
        }
        num3 = num1+num2;
        int val = num3%10;
        num3 = num3/10;
        ListNode l3 = new ListNode(val);
        ListNode cur = l3;
        while (num3 != 0) {
            val = num3%10;
            num3 = num3/10;
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return l3;
    }

    /**
     * 按照官方的方法又自己写了一遍
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode a = l1,b = l2, current ;
        ListNode l3 = new ListNode(0);
        int tmp = 0;
        current = l3;
        while(a != null || b != null) {
            int aval = a == null? 0 : a.val;
            int bval = b == null? 0 : b.val;

            int cval = aval+bval+tmp;
            tmp = cval / 10;
            current.next = new ListNode(cval%10);
            current = current.next;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }

        if (tmp != 0) {
            current.next = new ListNode(tmp);
        }
        return l3.next;
    }


}
