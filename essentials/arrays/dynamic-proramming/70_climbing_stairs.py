class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        #recursive solution->correct but O(2^n) time, O(n) space=depth of recursion tree which can go upto n
        # if n<=0:
        #     return
        # if n==1:
        #     return 1
        # if n==2:
        #     return 2
        # return self.climbStairs(n-1)+self.climbStairs(n-2)
        
        #Dynammic programming: O(N) time, O(n) space
        store = [None]*(n+2)
        store[0], store[1], store[2] = 0,1,2
        if(n<3):
            return store[n]
        for i in range(3,n+1):
            store[i]=store[i-1]+store[i-2]
        
        return store[n]
            
