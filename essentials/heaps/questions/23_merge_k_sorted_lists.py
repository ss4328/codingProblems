from Queue import PriorityQueue

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        q = PriorityQueue()
        
        #create a new LinkedList for result
        res = cur = ListNode()
        
        #add the first element of all lists heap
        for l in lists:
            if l:
                q.put((l.val,l))
                
        #while heap is not empty, add the lowest node to result list, append the next of lowest node to queue
        while not q.empty():
            val,node = q.get()
            cur.next = ListNode(val)
            cur=cur.next
            if node.next:
                q.put((node.next.val,node.next))
                
        #return the list after head
        return res.next
        
