    //Similar: leetcode 328
    public ListNode oddEvenList(ListNode head) {
        //by default list is sorted -_- -_- -_-
        //use 2 linked lists

        if(head==null||head.next==null){
            return head;
        }

        ListNode evenListHead = new ListNode(Integer.MIN_VALUE);
        ListNode evenListTail = evenListHead;
        ListNode oddListHead=new ListNode(Integer.MIN_VALUE);
        ListNode oddListTail = oddListHead;

        ListNode sent = head;
        int count =1;
        while(sent!=null){
            int enc = sent.val;
            if(count%2==0){
                if(evenListTail.val ==Integer.MIN_VALUE){
                    evenListTail.val = enc;
                }
                else{
                    evenListTail.next = new ListNode(enc);
                    evenListTail = evenListTail.next;
                }
            }
            else {
                if(oddListTail.val==Integer.MIN_VALUE){
                    oddListTail.val = enc;
                }
                else{
                    oddListTail.next = new ListNode(enc);
                    oddListTail = oddListTail.next;
                }
            }
            sent = sent.next;
            count++;
        }

        ListNode res;

        res=new ListNode(oddListHead.val);
        oddListHead = oddListHead.next;

        while(oddListHead!=null){
            ListNode newNode = new ListNode(oddListHead.val);
            attachNodeInEnd(res,newNode);
            oddListHead = oddListHead.next;
        }

        while(evenListHead!=null){
            ListNode newNode = new ListNode(evenListHead.val);
            attachNodeInEnd(res,newNode);
            evenListHead = evenListHead.next;
        }

        return res;
    }
    //helper
    public static void attachNodeInEnd(ListNode root,ListNode attach){
        while(root.next!=null){
            root = root.next;
        }
        root.next =attach;
    }

    //time: O(n); space: O(n)
    //14 mins
