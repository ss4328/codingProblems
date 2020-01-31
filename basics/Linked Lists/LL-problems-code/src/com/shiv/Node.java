package com.shiv;

public class Node {
    int data;
    Node nextNode;

    Node(int d) { data = d; }

    Node findNodeIter(int val, Node root){

        if(root.nextNode==null){
            return root;
        }

        Node cur = root;

        while(cur.nextNode!=null){
            if(cur.data == val){
                return cur;
            }
            else{
                cur = cur.nextNode;
            }
        }

        return new Node(Integer.MIN_VALUE);
    }

    Node findNodeRecur(int val, Node passed){
        if(passed.data == val){
            return passed;
        }
        else{
            if(passed.nextNode!=null) {
                return findNodeRecur(val, passed.nextNode);
            }
            else{
                return new Node(Integer.MIN_VALUE);
            }
        }
    }

    Node returnNthNode(int n, Node root){
        if(n<0){
            System.out.println("Invalid index");
            return new Node(Integer.MIN_VALUE);
        }
        Node cur = root;
        int i=0;
        while(n!=i){
            if(cur.nextNode!=null){
                cur = cur.nextNode;
            }else{
                System.out.println("Invalid index passed. List doesn't extent till n");
                return new Node(Integer.MIN_VALUE);
            }
        }
        return cur;
    }

    Node returnNthNodeFromLast(int n, Node passed){
        //recursion stuff here
        //remember how we recursively returned from last in array!?
        if(passed.nextNode!=null){

        }
        returnNthNodeFromLast(n,passed.nextNode);

    }
}
