class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        left, right = 1, x +1
        while(left<right):
            mid = left + (right-left)//2
            if(mid*mid>x):
                right = mid
            else:
                left = mid + 1
        
        return left-1
        
