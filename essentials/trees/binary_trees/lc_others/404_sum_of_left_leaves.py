# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #DFS way
        res = 0
        if(root is None):
            return 0
        s = []
        s.append(root)
        
        while(s):
            cur = s.pop()
            #if the left child is leaf, add it's value to res
            if (cur.left):
                curLeft = cur.left
                if curLeft.left==None and curLeft.right==None:
                    res+=curLeft.val
            
            #traversals
            if cur.left!=None:
                s.append(cur.left)
            if cur.right!=None:
                s.append(cur.right)
                
        return res
