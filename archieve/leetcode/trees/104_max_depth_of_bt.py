# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if(root is None):
            return 0
        left_d = self.maxDepth(root.left)
        right_d = self.maxDepth(root.right)
        return max(left_d, right_d)+1
        
