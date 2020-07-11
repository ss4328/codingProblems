# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #DFS here, let's see if this could be done
        
        stack=[]
        res=[]
        
        stack.append(root)
        
        while(len(stack)!=0):
            cur = stack.pop()
            
            if(cur!=None):
                stack.append(cur.right)
                stack.append(cur.left)
                
                res.append(cur.val)
        
        return res
