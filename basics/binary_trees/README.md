# Binary Trees 
A binary tree is a tree where every node has two or fewer children. The children are usually called left and right.

Each node of the tree will have a root value and a list of references to other nodes which are called child nodes. From graph view, a tree can also be defined as a directed acyclic graph which has N nodes and N-1 edges.

A Binary Tree is one of the most typical tree structure. As the name suggests, a binary tree is a tree data structure in which each node has at most two children, which are referred to as the left child and the right child.

```python
class BinaryTreeNode(object):

    def __init__(self, value):
        self.value = value
        self.left  = None
        self.right = None
```

## Classifying Binary Trees:
There are some particular names for classifying binary trees.
![Binary Tree](https://i1.faceprep.in/Companies-1/binary%20tree%20-%20types.png)

* If every level of the tree is completely full, we call this a 'perfect binary tree'

   * The number of total nodes on each level doubles as we move down the tree.
   * the number of nodes on the last level is equal to the sum of the number of nodes on all other levels (plus 1)
   * level n = 2^n nodes 
   * If we have the height of the binary tree 'h', the total number of nodes n = 2^0 + 2^1 + ..... 2^(h-1), or n = 2^h -1
   * height 'h' = log2(n+1)

## Traversals

Unlike linear data structures (Array, Linked List, Queues, Stacks, etc) which have only one logical way to traverse them, trees can be traversed in different ways.

1. Inorder Traversal 
2. Pre-Order Traversal
3. Post-Order Traversal



```bash
Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)

Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 

Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
```

## Implementation

There are many ways to do traversals. We could do BFS/DFS (covered later) to traverse the tree in constant space. However, if the tree is small, we could just do a plain recursion to simply get to the next 'level' pf the tree and use more memory for simplicity. 


Here's the recursive in-order traversal of the tree.
```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        l=[]
        return self.inorderTraversalHelper(root,l)
        
        
    def inorderTraversalHelper(self,root,l):
        if(root==None):
            return l
        self.inorderTraversalHelper(root.left,l)
        l.append(root.val)
        self.inorderTraversalHelper(root.right,l)
        return l
        
```
In this implementation however, we are traversing a tree recursively to retrieve all the data in-order. The time complexity is O(N) because we visit each node exactly once. And the depth of the tree might be N in the worst case. That is to say, the level of recursion might be at most N in the worst case. Therefore, taking system stack into consideration, the space complexity is O(N) as well. 

It is comparatively easy to do traversal recursively but when the depth of the tree is too large, we might suffer from stack overflow problem. That's one of the main reasons why we want to solve this problem iteratively sometimes.


```python
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
        l=[]
        st=[]
        
        if(root!=None):
            st.append(root)
        
        while(len(st) is not 0):
            cur = st.pop()
            l.append(cur.val)
            
            if(cur.right!=None):
                st.append(cur.right)
            
            if(cur.left!=None):
                st.append(cur.left)
            
        return l
```

For the iterative solution, the time complexity is apparently the same with recursion solution which is O(N). The space complexity is also O(N) since in the worst case, we will have all the nodes in the stack. There are some other solutions for iterative traversal which can reduce the space complexity to O(1).

## Uses
Uses of Inorder
In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used.

Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree

Postorder traversal is used to delete the tree. Please see the question for deletion of tree for details. Postorder traversal is also useful to get the postfix expression of an expression tree.

Time Complexity: O(n) for all traversals as all nodes are being visited

## More to read:
The two approaches:
* Bottoms up
* Top Down 

## Problems
1) Code up the BST class, then make in-order, pre-order, and post-order traversals
2) Level traversal: nodes at each level are inserted into a common list, return the list of lists
3) LC#98 Validate BST 
4) LC$104 Maximum Depth of Binary Tree
4) LC#102 level order traversal


## License
[MIT](https://choosealicense.com/licenses/mit/)