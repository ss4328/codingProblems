# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def closestValue(self, root, target):
        """
        :type root: TreeNode
        :type target: float
        :rtype: int
        """
        diff = float('inf')
        closest = float('inf')
        
        st = []
        st.append(root)
        
        while(len(st)!=0):
            cur = st.pop()
            if abs((cur.val - target))<diff:
                closest = cur.val 
                diff = abs((cur.val - target))
            # print(cur.val)
            if (target< cur.val):
                # print('left')
                if cur.left !=None:
                    st.append(cur.left)
            else:
                # print('right')
                if cur.right !=None:
                    st.append(cur.right)
        return closest
        