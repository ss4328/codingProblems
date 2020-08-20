#Binary Search Tree w/ Pointers

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

    def insert(self,value):
        self.root = self.insert_value(value, self.root)

    def find(self,value):
        return self.find_value(value,self.root)

    def delete(self,value):
        self.root=self.delete_value(value, \
            self.root)

    def inorder(self):
        return self.in_order_walk(self.root)

    def preorder(self):
        return self.pre_order_walk(self.root)

    def postorder(self):
        return self.post_order_walk(self.root)

    def height(self):
        return self.node_height(self.root)

    def insert(self, value):
        return self.insert_value(value, self.root)

    def insert_value(self, value, root):
        if self.root is None:
            root = node(value)
            self.root = root
            return self.root
        else:
            self.binary_insert(value, self.root)

    def binary_insert(self, value, mynode):
        if value < mynode.getValue():
            if mynode.getLeft() is None:
                mynode.setLeft(node(value))
                return mynode
            else:
                return self.binary_insert(value, mynode.getLeft())
        elif value > mynode.getValue():
            if mynode.getRight() is None:
                mynode.setRight(node(value))
                return mynode
            else:
                return self.binary_insert(value, mynode.getRight())
        else:
            print("Value already in the tree")

    # Search Function
    def find_value(self, value, mynode):
        if (mynode.getValue() == value):
            return True
        else:
            if (value < mynode.getValue()):

                if (mynode.getLeft() is None):
                    return False

                # recurse left
                if (value == mynode.getLeft().getValue()):
                    return True
                else:
                    return self.find_value(value, mynode.getLeft())
            else:

                if (mynode.getRight() is None):
                    return False

                # recurse right
                if (value == mynode.getRight().getValue()):
                    return True
                else:
                    return self.find_value(value, mynode.getRight())

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

    #Delete From Tree
    #Recursive Definition (Works if you implement find min correctly)
    def delete_value(self,value,mynode):
        #Thing to delete not found
        if mynode==None:
            return None
        #Found Node to Delete
        elif mynode.getValue()==value:
            #If either side is null
            #Move up other side
            if mynode.getLeft()==None:
                return mynode.getRight()
            elif mynode.getRight()==None:
                return mynode.getLeft()
            #Otherwise reorganize!
            else:
                #Find Smallest Value on Right Side
                minval = self.find_min(\
                    mynode.getRight())
                #Swap to this position
                mynode.setValue(minval)
                #Remove that value
                #We know it has no left child
                new_right = self.delete_value(\
                    minval,mynode.getRight())
                #Update Pointers
                mynode.setRight(new_right)
                return mynode
        #Search More
        elif mynode.getValue() > value:
            mynode.setLeft(\
                self.delete_value(\
                    value,mynode.getLeft()))
            return mynode
        else:
            mynode.setRight(\
                self.delete_value(\
                    value,mynode.getRight()))
            return mynode

    def min(self):
        return self.find_min(self.getRoot())

        # Find Min

    def find_min(self, mynode):
        # Implement Me
        if (mynode is None):
            return mynode
        else:
            cur = mynode
            while (cur.getLeft() is not None):
                cur = cur.getLeft()

            return cur.getValue()

    def height(self):
        return self.node_height(self.root)

    def node_height(self,mynode):
        if(mynode is None):
            return 0
        left_d = self.node_height(mynode.getLeft())
        right_d = self.node_height(mynode.getRight())
        return max(left_d, right_d)



if __name__=="__main__":
    to_insert=[6,4,1,10,8,5,12]
    print("A simple set of BST Examples.")
    my_tree = BST()
    for x in to_insert:
        my_tree.insert(x)
        print("Tree After Insert "+str(x))
        print("Inorder:")
        print(my_tree.inorder())
        print("Preorder:")
        print(my_tree.preorder())
        print("Postorder:")
        print(my_tree.postorder())
    print("The height of the tree is",my_tree.height())
    for x in range(0,13):
        print("Is "+str(x)+" in the tree? "+str(my_tree.find(x)))
    for x in to_insert:
        my_tree.delete(x)
        print("Inorder after deleting "+str(x))
        print(my_tree.inorder())

