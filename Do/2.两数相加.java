/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static void main(String[] args) {
        // ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(2);
        // node1.next = node2;
        // ListNode node3 = new ListNode(2);
        // ListNode node4 = new ListNode(1);
        // node3.next = node4;
        // new Solution().addTwoNumbers(node1, node3);
        // new Solution().toNum()
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { // TODO: maybe I do the wrong way from the start...long is not enough...
        return toList(toNum(l1) + toNum(l2));
    }

    public long toNum(ListNode head) {
        if (head == null) {
            System.out.println("Wrong Input");
            return -1;
        }

        ListNode cur = head;
        long returnLong = 0;
        int digitsCnt = 0;
        while (cur != null) {
            returnLong += cur.val * (long) Math.pow(10, digitsCnt);
            digitsCnt++;
            cur = cur.next;
        }
        cur = null;
        return returnLong;
    }

    public ListNode toList(long num) {
        ListNode holder = null;
        ListNode cur = null;
        ListNode head = null;
        String stringNum = Long.toString(num);
        for (int i = 0; i < stringNum.length(); i++) {
            cur = new ListNode(stringNum.charAt(stringNum.length() - 1 - i) - 48);
            if (head == null) {
                head = cur;
                holder = cur;
                cur = cur.next;
            }else{
                holder.next = cur;
                holder = holder.next;
            cur = cur.next;
        }}
        return head;
    }
}
// @lc code=end
