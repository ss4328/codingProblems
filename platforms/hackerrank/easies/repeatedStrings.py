#!/bin/python3

#https://www.hackerrank.com/challenges/repeated-string/problem


import math
import os
import random
import re
import sys

# Complete the repeatedString function below.

def repeatedString(s, n):
    compl_iters = 0
    left_over_chars = 0
    a_count_per_Iter = 0
    for c in s:
        if c is 'a':
            a_count_per_Iter+=1
    
    compl_iters = int(n/len(s))
    left_over_chars = n%len(s)
    
    total_count=0
    left = s[0:left_over_chars]
    for c in left:
        if c is 'a':
            total_count+=1
    
    total_count = total_count + (a_count_per_Iter*compl_iters)

    return total_count 

def repeatedStringLessTrash(s, n):
    count = 0
    for c in s:
        if c is 'a':
            count +=1
    ratio = count/len(s)

    res = round(n*ratio)
    return res


def repeatedStringTrash(s, n):       #trash approach: recreates string which takes time
    fullString = ''

    reps = 1
    reps = round(n/len(s))

    for i in range(0, reps+1):
        fullString+=s
    
    fullString = fullString[0:n]
    sortedString = ''.join(sorted(fullString))
    res = 0

    for subs in sortedString:
        if subs is 'a':
            res+=1
        else:
            break
    print(res)
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    n = int(input())

    result = repeatedString(s, n)

    fptr.write(str(result) + '\n')

    fptr.close()
