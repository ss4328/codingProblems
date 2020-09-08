# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumRootToLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        st, paths = [], []
        st.append((root, str(root.val)))
        
        while len(st)!=0:
            cur, path = st.pop()
            #leaf node? add the path to paths
            if not cur.left and not cur.right:
                #this is leaf
                paths.append(path)
            
            #if not leaf, append the node, and node.val to path
            if cur.right:
                st.append((cur.right, path+str(cur.right.val)))
            if cur.left:
                st.append((cur.left, path+str(cur.left.val)))
                
        res = sum([int(num,2) for num in paths])
        # for path in paths:
        #     res+=int(path,2)
        return res
