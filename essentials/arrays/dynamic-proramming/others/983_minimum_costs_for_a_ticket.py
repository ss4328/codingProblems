class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        
        # get min cost of travel till any given day, if optimization can decrease it, decrease it
        min_cost = [0]*(days[-1]+1)
        travel_day = set(days)
        
        
        for i in range(1, days[-1] + 1):
            #if i is not a travel day
            if i not in travel_day:
                min_cost[i] = min_cost[i-1]
            else:
                min_cost[i] = min(min_cost[i-1]+costs[0], min_cost[max(0, i-7)]+costs[1], min_cost[max(0, i-30)]+costs[2])
        
        return min_cost[-1]
        
