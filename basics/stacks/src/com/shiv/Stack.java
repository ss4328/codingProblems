package com.shiv;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    public ListNode listHead;

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
    }

    //return the first value of stack; then remove the first element
    public int pop(){
        if(!isEmpty()){
            int res = listHead.val;

            ListNode nextHead;
            nextHead=listHead.nextNode;

            listHead = nextHead;
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
}
