package com.shiv;

//s1q1
public class TwoStacks {

    //array being used by both the stacks
    //stack 1: 0->mid
    //stack 2: mid+1->len(arr)-1
    public int[] arr;
    public int curIndex1;
    public int cap1;
    public int curIndex2;
    public int cap2;
    public int totalCap;

    //constructor; takes size of capacity of stacks; cap1=cap2
    public TwoStacks(int totalCap){
        this.arr = new int[totalCap];
        this.totalCap = totalCap;
        this.cap1 = totalCap/2;
        this.cap2 = totalCap-this.cap1;           //take eg of totalCap=10; cap2->5; 5-9
        this.curIndex1 = -1;
        this.curIndex2 = totalCap-1;
    }

    public void push1(int x){
        if(this.curIndex1<cap1) {
            this.arr[curIndex1] = x;
            curIndex1++;
        }
        else throw new ArrayStoreException();
    }

    public void push2(int x){
        if(this.curIndex2>=(totalCap-cap2)){
            this.arr[curIndex2] = x;
            curIndex2--;
        }
        else throw new ArrayStoreException();
    }

    public int pop1(){
        if(this.curIndex1>=0){
            return this.arr[curIndex1--];
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public int pop2(){
        if(this.curIndex2<=totalCap-1){
            return this.arr[++curIndex2];
        }
        else throw new ArrayIndexOutOfBoundsException();
    }
}
