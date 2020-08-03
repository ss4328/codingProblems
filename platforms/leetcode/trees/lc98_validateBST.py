# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        return self.isValidBSTHelper(root, float('-inf'), float('inf'))
    
    #checks the left and right subtree of a particular non-leaf node
    def isValidBSTHelper(self, node, low, high):
        if not node:
            return True 
        
        if node.val>=high or node.val<=low:
            return False
        
        if not self.isValidBSTHelper(node.right, node.val, high):
            return False
        if not self.isValidBSTHelper(node.left, low, node.val):
            return False
        return True
            
        
            
        
