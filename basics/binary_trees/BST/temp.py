class node:
    def __init__(self,v,l=None,r=None):
        self.value = v
        self.left = l
        self.right = r
    def __str__(self):
        return str(self.value)

    def getValue(self):
        return self.value

    def setValue(self,v):
        self.value=v

    def getLeft(self):
        return self.left

    def setLeft(self,l):
        self.left = l

    def getRight(self):
        return self.right

    def setRight(self,r):
        self.right = r

class BST:
    def __init__(self):
        self.root=None
    def __str__(self):
        return self.inorder()
    #ADT Interface
    #These don't do much. They just set the correct inputs.

    def getRoot(self):
        return self.root

    def find(self,value):
        return self.find_value(value, self.root)

    # Search Function
    def find_value(self, value, root):
        if(root.getValue()==value):
            return True
        else:
            if(value<root.getValue()):

                if(root.getLeft() is None):
                    return False

                #recurse left
                if(value==root.getLeft().getValue()):
                    return True
                else:
                    return self.find_value(value, root.getLeft())
            else:

                if (root.getRight() is None):
                    return False

                # recurse right
                if(value==root.getRight().getValue()):
                    return True
                else:
                    return self.find_value(value, root.getRight())


    def insert(self, value):
        return self.insert_value(value, self.root)

    def insert_value(self, value, root):
        if self.root is None:
            root = node(value)
            self.root = root
            return self.root
        else:
            self.binary_insert(value, root)

    def binary_insert(self, value, root):
        if value < root.getValue():
            if root.getLeft() is None:
                root.setLeft(node(value))
                return root
            else:
                return self.binary_insert(value, root.getLeft())
        elif value > root.getValue():
            if root.getRight() is None:
                root.setRight(node(value))
                return root
            else:
                return self.binary_insert(value, root.getRight())
        else:
            print("Value already in the tree")

    def print_tree(self):
        if self.root is not None:
            self.in_order_walk(self.root)

    def in_order_walk(self, mynode):
        if mynode is not None:
            self.in_order_walk(mynode.getLeft())
            print(mynode.getValue())
            self.in_order_walk(mynode.getRight())

    def pre_order_walk(self, mynode):
        if mynode is not None:
            print (mynode.getValue())
            self.pre_order_walk(mynode.getLeft())
            self.pre_order_walk(mynode.getRight())

    def post_order_walk(self, mynode):
        if mynode is not None:
            self.post_order_walk(mynode.getLeft())
            self.post_order_walk(mynode.getRight())
            print (mynode.getValue())

    def min(self):
        return self.find_min(self.getRoot())

    # Find Min
    def find_min(self, root):
        # Implement Me
        if(root is None):
            return root
        else:
            cur = root
            while(cur.getLeft() is not None):
                cur = cur.getLeft()

            return cur.getValue()

    def height(self):
        return self.node_height(self.root)

    def node_height(self,root):
        if root is None:
            return 0
        else:
            return self._get_height(root)

            '''left_d = self.node_height(root.getLeft())
            right_d = self.node_height(root.getRight())
            return max(left_d, right_d)+1'''

    def _get_height(self, mynode):
        if root.getLeft() is not None and root.getRight() is not None:
            return 1 + max(self._get_height(root.getLeft()), self._get_height(root.getRight()))
        elif root.getLeft() is not None:
            return 1 + self._get_height(root.getLeft())
        elif root.getRight() is not None:
            return  1 + self._get_height(root.getRight())
        else:
            return 1

tree = BST()

tree.insert(6)
tree.insert(5)
tree.insert(2)
tree.insert(7)
tree.insert(1)
tree.insert(9)
tree.insert(9)

print(tree.find(6))
print(tree.find(2))
print(tree.find(25))

print(tree.min())
print("height: ")
print(tree.height())

tree.print_tree()