package com.shiv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Stack {

    public ListNode listHead;
    public int size;

    public Stack(){
        listHead = new ListNode(Integer.MIN_VALUE);
    }

    public boolean isEmpty(){
        if(listHead.val==Integer.MIN_VALUE || listHead==null) {
            return true;
        }
        else return false;
    }

    public void push(Integer i){
        ListNode oldList = listHead;
        ListNode newHead = new ListNode(i);
        newHead.nextNode = oldList;
        listHead = newHead;
        size++;
    }

    //return the first value of stack; then remove the first element
    public int pop(){
        if(!isEmpty()){
            int res = listHead.val;

            ListNode nextHead;
            nextHead=listHead.nextNode;

            listHead = nextHead;
            size--;
            return res;
        }
        else{
            throw new NullPointerException();
        }
    }

    public int peek(){
        if(!isEmpty()){
            int res = listHead.val;
            return res;
        }
        else{
            throw new NullPointerException();
        }
    }



    //s1p4; took hints for insertSorted fn
    public void sortStackRecur(Stack s){
        if(!s.isEmpty()){
            int val = s.pop();
            sortStackRecur(s);
            insertSorted(s,val);
        }
    }

    private void insertSorted(Stack s, int val){
        if(s.isEmpty() || val>s.peek()){
            s.push(val);
        }
        else{
            int temp = s.pop();
            insertSorted(s,temp);
            s.push(temp);
        }
    }

    //s1p5; used temporary array instead; didn't put too much effort into stack implementation
    public Stack sortStackIterative(Stack s){
        int[] allVals = new int[s.size];

        int i=0;
        while(!s.isEmpty()){
            allVals[i]=s.pop();
            i++;
        }

        Arrays.sort(allVals);
        Stack n = new Stack();
        i=0;
        while(i<allVals.length){
            n.push(allVals[i]);
            i++;
        }
        return n;
    }

    //s1p6; reverse stack without using extra space in O(n)
    //s1p8-> what is the performance needed here???


    //s1p7: delete the middle element of the stack
    //easy; did similar in linkedList set 1
    //not really sure if this is the correct way since I'm leveraging the linked list fns more than the stack fns
    public void removeMiddleViaLL(){
        //find middle node
        ListNode slow = listHead;
        ListNode fast = listHead;       //fast moves at 2x speed as slow

        ListNode beforeSlow = listHead;
        while(fast!=null){
            if(fast.nextNode!=null){
                fast = fast.nextNode;
                beforeSlow = slow;
                slow = slow.nextNode;
                if(fast.nextNode!=null){
                    fast = fast.nextNode;
                }
                else {
                    break;
                }
            }
            else{
                break;
            }
        }
        beforeSlow.nextNode = beforeSlow.nextNode.nextNode;
    }

    //s1p7: using stack methods -> more like stack implementation
    public Stack removeMiddleViaStack(){
        //using arrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!this.isEmpty()){
            list.add(this.pop());
        }


        list.remove(list.size()/2);
        int i=0;
        Stack newStack = new Stack();
        while(i<list.size()){
            newStack.push(list.get(i));
        }
        return newStack;
    }
    //O(n) space, O(n) time

    private ListNode detectMiddle(){
        ListNode slow = listHead;
        ListNode fast = listHead;       //fast moves at 2x speed as slow

        while(fast!=null){
            if(fast.nextNode!=null){
                fast = fast.nextNode;
                slow = slow.nextNode;
                if(fast.nextNode!=null){
                    fast = fast.nextNode;
                }
                else {
                    return slow;
                }
            }
            else{
                return slow;
            }
        }
        return slow;
    }




}
