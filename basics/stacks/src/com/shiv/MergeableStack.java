package com.shiv;

public class MergeableStack {

    public ListNode listHead;
    public ListNode tailHead;

    public MergeableStack(){
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
        if(oldList.nextNode==null){
            tailHead = oldList;
        }
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

    //s1q3
    public MergeableStack merge(MergeableStack s1, MergeableStack s2){
        s1.tailHead=s2.listHead;

        //we have to create a stack such that the last node is tracked
        //lastnode.next = s2.listHead

        return s1;
    }
}

