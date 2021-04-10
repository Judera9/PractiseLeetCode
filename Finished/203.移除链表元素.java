/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7, node1);
        ListNode node3 = new ListNode(7, node2);
        ListNode node4 = new ListNode(7, node3);
        // ListNode nullNode = new ListNode();
        Solution solution = new Solution();
        solution.removeElements(node4,7);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        boolean isDeleted = false;

        // TODO: think about the 1 and 2 node condition
        // TODO: think about the head node (new head)

        ListNode cur = head;

        while(true){
            if (head.next == null){ // note: 1 node condition
                if (head.val == val){
                    return null;
                }else{
                    return head;
                }
            }
            if (cur.next == null){
                break;
            }
            if (head.val == val){ // note: assert cur = null
                cur = cur.next;
                head.next = null;
                head = null;
                head = cur;
                continue;
            }
            if (cur.next.val == val){
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode = null;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }
}
// @lc code=end
