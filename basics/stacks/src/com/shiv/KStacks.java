package com.shiv;

//s1q2
//this program has so many corner cases ugh -__-
public class KStacks {
    public int[] arr;
    public int stackCount;          //num of stacks in the array
    public int[] stackLimits;       //limit of index for each stack;
    public int[] currentIndexes;

    //needs example, (4,20)
    public KStacks(int _stackCount, int totalCap){
        this.stackCount = _stackCount;                  //4
        this.arr = new int[totalCap];                   //20 size
        this.stackLimits = new int[_stackCount];        //4 size
        this.currentIndexes = new int[_stackCount];     //4 size

        //instantiatePartitions; divide the arr into <stackCount> partitions
        int partitionSize = totalCap/stackCount;        //5

        //ERROR here??
        for(int i=1;i<=stackLimits.length;i++){
            this.stackLimits[i-1] = i*partitionSize;            //5,10,15,20
            this.currentIndexes[i-1] = ((i-1)*partitionSize)-1;     //-1,4,9,14
        }
    }

    public void push(int x, int sn){

        //check for the sn, if the respective partition isn't full
        if(!isStackFull(sn)){
            int pushIndex = currentIndexes[sn];
            this.arr[++pushIndex]=x;
            pushIndex = pushIndex+1;
            this.currentIndexes[sn] = pushIndex;
        }
        else throw  new StackOverflowError();

    }

    public boolean isStackFull(int sn){
        if(currentIndexes[sn]<stackLimits[sn]){
            return false;
        }
        else return true;
    }

    //gets a boolean value; if stack(sn) is empty
    public boolean isStackEmpty(int sn){
        //illegal stackCount val -> exception
        if(sn>=stackCount){
            throw new IndexOutOfBoundsException();
        }

        //we check if sn's current index > the limit of previous stack's limit.
        //ddefault =-1, otherwise, it's the initiated val, i.e. the prev stack's limit
        int start=-1;
        if(sn>0){
            start=this.stackLimits[sn-1];               //5,10,15
        }


        if(this.currentIndexes[sn]>=start){
            return true;
        }
        else return false;
    }

    public int pop(int sn){
        if(!isStackEmpty(sn)){
            int val = this.arr[this.currentIndexes[sn]];
            this.currentIndexes[sn] = this.currentIndexes[sn]-1;
            return val;
        }
        else throw new IndexOutOfBoundsException();
    }
}
