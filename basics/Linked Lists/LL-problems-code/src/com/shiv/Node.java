package com.shiv;

import java.util.HashMap;
import java.util.Stack;

public class Node {
    int data;
    Node nextNode;

    Node(int d) { data = d; }

    //q1
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
    //space O(1); time O(n)

    //q1
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
    //space O(1); time O(n)

    //q2
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
    //space O(1); time O(n)

    //q3
    public int returnNthNodeFromLast(int n, Node passed){
        //recursion stuff here
        //remember how we recursively returned from last in array!?
//        if(passed.nextNode!=null){
//
//        }
//        returnNthNodeFromLast(n,passed.nextNode);

        HashMap indexValueMap = new HashMap<Integer,Integer>();

        int count = 0;
        int i=0;

        while(passed.nextNode!=null){
            indexValueMap.put(i,passed.data);
            i++;
            count++;
        }
        //last value        -> not elegant but works :/
        indexValueMap.put(i,passed.data);

        int indexRequired = count-n;

        return (int)indexValueMap.get(indexRequired);
    }
    //space O(n); time O(n)


    //q4
    public int findMiddleElement( Node root){
        int count = 0;
        Node cur = root;
        while (cur.nextNode!=null){
            cur = cur.nextNode;
            count++;
        }
        int midIndex = 0;
        if(count%2!=0){
            midIndex = count/2 +1;
        }
        else{
            midIndex = count/2;
        }

        return returnNthNode(midIndex,root).data;
    }
    //space O(1); time O(n)

    //q5
    public int findFrequencyOfKey(int k, Node root){
        int count = 0;
        Node cur = root;
        while(cur.nextNode!=null){
            if(cur.data==k){
                count++;
            }
            cur = cur.nextNode;
        }
        return count;
    }
    //space O(1); time O(n)

    //q6
    public boolean checkIfListHasLoop(Node root){
        //hare tortoise algorithm studied in soph year
        //ptr1 moves at 2x the speed as ptr 1; if they meet at anywhere but the end
        //we have a loop in the linked List

        Node cur1 = root;       //slower
        Node cur2 = root;       //faster; moves at 2x speed

        //till the point the slower node reaches the end, we run the loop
        while(cur1.nextNode==null){
            cur1 = cur1.nextNode;

            if(cur2.nextNode!=null){
                cur2 = cur2.nextNode;
                if(cur2.nextNode!=null){
                    cur2=cur2.nextNode;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

            if(cur2.data == cur1.data){
                return true;
            }
        }
        return false;
        //dunno what I did with the false statements :D
    }
    //space O(1); time O(n)

    //q7 idk

    //q8
    //the minimum complexity must be atleast O(n) since we have to check each element
    public boolean isPalindrome(Node root){

        //get mid element index and count
        if(root==null){
            return true;
        }
        int middleElement = 0;
        int count = 1;
        Node cur = root;
        while (cur.nextNode!=null){
            cur = cur.nextNode;
            count++;
        }
        if(count%2==0){
            middleElement = (count-1)/2;
        }
        else{
            middleElement = count/2;
        }
        System.out.println(middleElement);


        if(count==1){
            return true;
        }
        //actually do palindrome check
        Stack half = new Stack<Integer>();
        //if mid element is even we enter half of the elements, then check
        //if mid is odd, we enter elems till mid, disregard one then check
        cur = root;
        int i;
        for(i=0;i<=middleElement;i++){
            half.push(cur.data);
            if(cur.nextNode!=null){
                cur = cur.nextNode;
            }
        }
        if(count%2!=0){
            half.pop();
        }
        // cur = root;
        while(cur!=null){
            if((int)half.pop() != cur.data){
                return false;
            }
            else{
                if(cur.nextNode!=null){
                    cur = cur.nextNode;
                }
                else{
                    break;
                }
            }
        }
        return true;
    }

    //time: O(n); space: O(n)
    //lc -> mem usage -> 42.1MB less that 30%, 2ms -> faster than 43%

    //q9
//    public void removeDuplicatesSorted(Node root){
//        //sorted -> duplicates are adjacent
//
//        Node cur = root;
//        int currentVal = 0;
//        while(cur!=null){
//            currentVal = cur.data;
//
//            if(cur.nextNode!=null){
//                cur = cur.nextNode;
//            }
//            Node nextVal = cur.nextNode;
//            int nextVal = cur
//        }
//
//        //root.nextNode = cur;
//
//    }

    public void removeDuplicatesSorted(Node root){
        Node cur = root;
        int curVal = cur.data;
        while(cur.nextNode!=null){
            while(cur.nextNode.data==cur.data){
                //null check needed here
                cur = cur.nextNode;
            }
            Node nextNode = cur.nextNode;
            root.nextNode = nextNode;

        }
    }













}
