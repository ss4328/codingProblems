using System;

namespace mergeLinkedLists
{
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
 
    public class Program
    {
        public ListNode MergeTwoLists(ListNode l1, ListNode l2)
        {

            ListNode result = new ListNode(0);
            ListNode dummy = result;
            while (l1 != null && l2 != null)
            {
                if (l1.val <= l2.val)
                {
                    result.next = l1;
                    result = result.next;
                    l1 = l1.next;
                }
                else
                {
                    result.next = l2;
                    result = result.next;
                    l2 = l2.next;
                }
            }

            if (l1 != null)
            {
                result.next = l1;
            }
            if (l2 != null)
            {
                result.next = l2;
            }
            return dummy.next;

        }
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}


//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//leetcode p21: merging two sorted lists