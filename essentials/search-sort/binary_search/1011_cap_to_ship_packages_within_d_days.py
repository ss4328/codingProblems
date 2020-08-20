class Solution(object):
    def shipWithinDays(self, weights, D):
        """
        :type weights: List[int]
        :type D: int
        :rtype: int
        """
        def feasible(cap):
            days = 1
            total = 0
            for weight in weights: 
                total+=weight
                if total>cap:       # too heavy, wait for the next day
                    total = weight
                    days+=1
                    if days>D:      # cannot ship within D days
                        return False
            return True
        
        left, right = max(weights), sum(weights)
        while(left<right):
            mid = left + (right-left)//2
            if(feasible(mid)):
                right = mid
            else:
                left = mid + 1
        return left
