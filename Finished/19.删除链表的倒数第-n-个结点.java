/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

// Definition for singly-linked list.
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
        // test
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        // ListNode node4 = new ListNode(4, node3);
        // ListNode nullNode = new ListNode();
        Solution solution = new Solution();
        solution.removeNthFromEnd(node3, 3);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) { // fast-slow pointer
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (n == 1) {
                return null;
            } else {
                System.out.println("Wrong Argument!");
            }
        }

        ListNode newHead = head;
        ListNode prev = head;
        ListNode foll = head;
        boolean isHead = false;

        for (int i = 0; i < n + 1; i++) {
            if (foll == null){
                isHead = true;
                break;
            }
            foll = foll.next; // let there be a space of k between two pointers
        }

        if (isHead) {
            newHead = prev.next;
            head.next = null;
            head = null;
            return newHead;
        }

        while (true) {
            if (foll == null) {
                // TODO: this is a delete method, change to return listnode for Ass3
                ListNode deleteNode = prev.next;
                prev.next = deleteNode.next;
                deleteNode = null;
                return newHead;
            } else {
                prev = prev.next;
                foll = foll.next;
            }
        }
    }
}
// @lc code=end
