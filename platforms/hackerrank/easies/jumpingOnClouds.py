#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
    steps = 0

    i = 0
    while(i<len(c)):
        stepSize = 1

        #if we overflow array, reduce stepsize
        if isSafe(c,i+2):
            stepSize=2
        
        i+=stepSize
        steps+=1
        
    return steps-1

def isSafe(c,index):
    if index>=len(c):
        return False
    elif c[index]==1:
        return False
    return True



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c)

    fptr.write(str(result) + '\n')

    fptr.close()
