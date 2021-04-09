/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head; // hold the pervious node
        ListNode holder = head.next.next; // cut the relationship with the next node
        ListNode buffer = head.next;

        while (true) {
            if (holder == null) {
                if (prev == head) {
                    prev.next = null;
                }
                buffer.next = prev;
                prev = buffer;
                break;
            } else if (prev == head) {
                prev.next = null; // cutoff relationship with the left nodes
                buffer.next = prev; // make it to the head of out new list
                prev = buffer;
                buffer = holder; // move buffer to next nodes
                holder = holder.next;
            } else {
                buffer.next = prev; // make it to the head of out new list
                prev = buffer;
                buffer = holder; // move buffer to next nodes
                holder = holder.next;
            }
        }
        return prev;
    }
}
// @lc code=end
