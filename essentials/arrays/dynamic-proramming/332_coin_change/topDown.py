class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        # if coins array is invalid
        if not coins:
            return
        
        #memory for storing solutions to subproblems
        memory = {}
        def dp(amount, coins_used):
            if amount==0:
                return 0
            #if we've seen this subproblem
            if amount in memory:
                return memory[amount]
            #find best subproblem solution with all coins
            tmp=[]
            for coin in coins:
                if amount - coin >=0:
                    tmp.append(dp(amount-coin, coins_used+1))
                else:
                    tmp.append(float('inf'))
            # increment 1 for coin use !imp
            memory[amount] = min(tmp)+1
            return memory[amount]
                
        output = dp(amount,0)
        return output if output!=float('inf') else -1
        
    
    
        
