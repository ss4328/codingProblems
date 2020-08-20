#https://www.hackerrank.com/challenges/2d-array/problem

#!/bin/python3

import math
import os
import random
import re
import sys

def hourGlassforCoordinate(arr,i,j):
    res =  arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
    print(res)
    return res


# Complete the hourglassSum function below.
def hourglassSum(arr):
    print("Hello")
    rows = len(arr)
    cols = len(arr[0])
    # sum_arr = [None]*rows*cols
    sum_arr = []

    for row in range(0,cols-2):
        for col in range(0,rows-2):
            print(str(row)+" "+str(col))
            sum_arr.append(hourGlassforCoordinate(arr,row,col))
    
    print(sum_arr)
    sum_arr.sort()
    return sum_arr[-1]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
