#!/bin/python3
#https://www.hackerrank.com/challenges/plus-minus/problem
import math
import os
import random
import re
import sys

# Complete the plusMinus function below.
def plusMinus(arr):
    p=0
    n=0
    z=0

    l = len(arr)
    for i in arr:
        if i>0:
            p+=1
        elif i<0:
            n+=1
        else:
            z+=1
    
    print(p/l)
    print(n/l)
    print(z/l)

if __name__ == '__main__':
    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    plusMinus(arr)
