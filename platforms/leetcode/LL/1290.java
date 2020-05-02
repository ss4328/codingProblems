    //leetcode 1290
//    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
//
//    Return the decimal value of the number in the linked list.
    public int getDecimalValue(ListNode head) {
        int res =0;
        ListNode dup = head;

        int count =-1;  //max pow
        while(dup!=null){
            count++;
            dup = dup.next;

        }
        while(head!=null){
            if(head.val==1){
                res+=Math.pow(2,count);
            }
            else{

            }
            head = head.next;
            count--;
        }
        return res;
    }
