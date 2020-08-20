#https://www.hackerrank.com/challenges/new-year-chaos/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.
def minimumBribes(q):
    bribes = 0
    #Calc how many times a person has TAKEN the bribe
    i = len(q)-1
    while(i>=0):
        num = q[i]
        # print("num: "+ str(num))  
        iBribes = 0

        #Calc how many places pos is off in the q
        index_diff = q[i] - (i+1)
        if(index_diff>=3):
            print("Too chaotic")
            return

        for j in range(max(0, q[i] - 2), i):
            if(q[j]>num):
                iBribes+=1
        
        # print("iBribes: "+str(iBribes))
        bribes+=iBribes
        i-=1
    
    
    print(bribes)
    

if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        n = int(input())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
