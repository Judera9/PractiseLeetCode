/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start

//  Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public static void main(String[] args) {
        // ListNode node1 = new ListNode(3);
        // ListNode node2 = new ListNode(1, node1);
        // ListNode node3 = new ListNode(2, node2);
        // ListNode node4 = new ListNode(4, node3);
        ListNode nullNode = new ListNode();
        Solution solution = new Solution();
        solution.sortList(nullNode);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // first step recursively cut the list
        ListNode newHead = cutToHalf(head);
        ListNode sortedFirstHead = sortList(head);
        ListNode sortedSecondHead = sortList(newHead);

        // second step sort and merge them together
        return merge(sortedFirstHead, sortedSecondHead);
    }

    public ListNode cutToHalf(ListNode head) { // use fast-slow pointer to find the middle point
        // if (head == null) {
        // throw new Exception(">> cutToHalf has null input");
        // }
        if (head.next == null) {
            return head;
        }

        ListNode slowPoint = head;
        ListNode fastPoint = head.next;

        // length is even, this is the point at length / 2
        // length is odd, this is the point at (length + 1) / 2
        while (true) {
            if (fastPoint == null || fastPoint.next == null) {
                ListNode secondHead = slowPoint.next;
                slowPoint.next = null;
                return secondHead;
            }

            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
        }
    }

    public ListNode merge(ListNode head, ListNode secondHead) {
        // if (head == null || secondHead == null) {
        // throw new Exception(">> merge has null input");
        // }

        ListNode firstPoint = head;
        ListNode secondPoint = secondHead;
        ListNode newHead = null;
        ListNode cur = null;

        while (true) {
            if (firstPoint == null) {
                cur.next = secondPoint; // the left nodes of the next sublist are sorted
                return newHead;
            } else if (secondPoint == null) {
                cur.next = firstPoint;
                return newHead;
            }

            // using merge sort
            // sort and merge the two list together
            if (firstPoint.val <= secondPoint.val) {
                if (newHead == null) {
                    newHead = firstPoint;
                    cur = firstPoint;
                } else {
                    cur.next = firstPoint;
                    cur = cur.next;
                }
                // firstPoint.next = null;
                firstPoint = firstPoint.next;
            } else {
                if (newHead == null) {
                    newHead = secondPoint;
                    cur = secondPoint;
                } else {
                    cur.next = secondPoint;
                    cur = cur.next;
                }
                // secondPoint.next = null;
                secondPoint = secondPoint.next;
            }
        }
    }
}
// @lc code=end
