#Write an algorithm to determine if a number n is "happy".

#A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

#Return True if n is a happy number, and False if not.


def isHappyRec(n,numDict):
    happy_sum = 0
    if(n in numDict):
        return False
    else:
        nums = list(str(n))
        for num in nums:
            happy_sum+= (int(num) * int(num))
        numDict[n] = happy_sum
    
    return True if happy_sum==1 else isHappyRec(happy_sum,numDict)

class Solution(object):
    def isHappy(self, n):
        return isHappyRec(n, {})
            
