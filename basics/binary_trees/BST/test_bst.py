#Test for Binary Search Tree

from bst import *

#Helper
#Insert a list into a tree
def make_tree(L):
	T=BST()
	for x in L:
		T.insert(x)
	return T

#Can an empty tree be created?
def test_empty():
	T=BST()
	assert T.getRoot()==None
#Can one node be inserted correctly?
def test_single_insert():
	T=BST()
	T.insert(7)
	r = T.getRoot()
	assert r != None
	assert r.getValue()==7
	assert r.getLeft()==None
	assert r.getRight()==None
#Can 3 nodes be inserted correctly
def test_insert_three():
	T=make_tree([5,3,7])
	#Should have 3 Nodes
	Root=T.getRoot()
	L=Root.getLeft()
	R=Root.getRight()
	assert Root.getValue()==5
	assert L.getValue()==3
	assert R.getValue()==7
#Can 5 nodes be inserted correcty?
def test_insert_five():
	T=make_tree([5,3,4,2,7,9,6])
	#We know exactly where all 5 nodes are
	Root = T.getRoot()
	assert Root.getValue() == 5
	assert Root.getLeft().getValue() == 3
	assert Root.getRight().getValue() == 7
	LC = Root.getLeft()
	RC = Root.getRight()
	assert LC.getLeft().getValue() == 2
	assert LC.getRight().getValue() == 4
	assert RC.getLeft().getValue() == 6
	assert RC.getRight().getValue() == 9
#Test Insert
def test_find():
	L=[5,3,4,2,7,9,6]
	T=make_tree(L)
	#We know what should be there
	for a in range(0,10):
	 assert (a in L) == T.find(a)
#Test Min
def test_min_one():
	T=make_tree([5,3,4,2,7,9,6])
	assert T.min()==2
def test_min_two():
	T=make_tree([9,6,8,1,3,6,2])
	assert T.min()==1
def test_min_three():
	T=make_tree([10,9,8,7,6,5,4])
	assert T.min()==4
#Test Height
def test_height_01():
	T=make_tree([1,2,3,4,5])
	assert T.height()==4
def test_height_02():
	T=make_tree([3,1,5,2,4])
	assert T.height()== 2
def test_height_03():
	T=make_tree([5,3,4,2,7,9,6])
	assert T.height() == 2
#Test Prints
def test_inorder():
	T=make_tree([5,3,4,2,7,9,6])
	s=T.inorder()
	s=s.strip()
	target="N 2 N 3 N 4 N 5 N 6 N 7 N 9 N"
	assert s == target
def test_preorder():
	T=make_tree([5,3,4,2,7,9,6])
	s=T.preorder()
	s=s.strip()
	target="5 3 2 N N 4 N N 7 6 N N 9 N N"
	assert s == target
def test_postorder():
	T=make_tree([5,3,4,2,7,9,6])
	s=T.postorder()
	s=s.strip()
	target="N N 2 N N 4 3 N N 6 N N 9 7 5"
	assert s == target
