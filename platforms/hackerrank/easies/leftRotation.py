#!/bin/python3
#https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
import math
import os
import random
import re
import sys


def swap(arr,f,t):
    temp = arr[f]
    arr[f]=arr[t]
    arr[t]=temp

#rotate arr from f(incl) to t(not incl)
def reverseArr(arr, f, t):
    if(f<t):
        while(f<t):
            swap(arr,f,t)
            f+=1
            t-=1
    print(arr)
    return arr

# Complete the rotLeft function below.
def rotLeft(a, d):
    print("D: "+ str(d))
    reverseArr(a, 0, len(a)-1)
    reverseArr(a, 0, len(a)-d-1)
    reverseArr(a, len(a)-d, len(a)-1)
    return a

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nd = input().split()

    n = int(nd[0])

    d = int(nd[1])

    a = list(map(int, input().rstrip().split()))

    result = rotLeft(a, d)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
