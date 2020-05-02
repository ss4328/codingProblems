    //Leetcode 206: reverse Linked List
    public ListNode reverseList(ListNode head) {
        Stack<Integer> numStack = new Stack<Integer>();

        while(head!=null){
            numStack.push(head.val);
            head = head.next;
        }

        ListNode res;
        ListNode resHead;
        if(!numStack.empty()){
            res = new ListNode(numStack.pop());
            resHead = res;
        }
        else{
            return head;
        }

        while(!numStack.empty()){
            res.next = new ListNode(numStack.pop());
            res = res.next;
        }

        return resHead;
    }
    //time: O(n); space: O(n)

    //Runtime: 2 ms, faster than 8.30% of Java online submissions for Reverse Linked List.
    //Memory Usage: 38.3 MB, less than 5.04% of Java online submissions for Reverse Linked List.
    //obviously there's another better way, I'm using too much memory, making list again and it's still too slow :/

