class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        #Bruteforce: loop inside loops but the complexity becomes n^2
        #Pretty sure we can do better by memoizing the data for one pass
        #Return max-min if max>min else 0
        
        min_price = float('inf')
        max_profit = float('-inf')
        
	#basically, we override the value of min_price if we find a lower price
	#else if we have better profit, we overwrite the profit
        for i in range(0,len(prices)):
            if(prices[i]<min_price):
                min_price = prices[i]
            
            elif (prices[i]-min_price)>max_profit:
                max_profit = prices[i]-min_price
        
        return max(0,max_profit)
        
