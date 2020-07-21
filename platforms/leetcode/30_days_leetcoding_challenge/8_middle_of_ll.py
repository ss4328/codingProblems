# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        if head == None:
            return head
        
        slow = head
        fast = head
        
        while(fast!=None and fast.next!=None):
            fast = fast.next.next
            slow = slow.next
        
        return slow
