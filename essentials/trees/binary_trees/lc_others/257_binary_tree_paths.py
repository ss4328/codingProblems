# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if root is None:
            return []
        
        paths = []
        st = [(root, str(root.val))] 
        while(len(st)!=0):
            cur, path = st.pop()
            if(cur.left==None and cur.right==None):
                paths.append(path)
                    
            if(cur.left!=None):
                st.append((cur.left, path + '->' + str(cur.left.val)))
            if(cur.right!=None):
                st.append((cur.right, path + '->' + str(cur.right.val)))
                
        return paths
