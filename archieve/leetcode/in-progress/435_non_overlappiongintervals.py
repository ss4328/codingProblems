class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        # returns the value for the number of times an interval could be continued
        def largestContinuationCount(up, intervals, kvp):
            if up in intervals[0]:
                
                #tuples that are continuation of the up value
                allContinuations = []
                
                
                #each continuation interval's continuation count
                eachContinuation = []
                    
                return max(eachContinuation)+1
            else:
                return 0
        
        #sorting intervals by low range
        intervals = sorted(intervals, key=lambda x: x[0])
        
        #translating the list of tuples to a list that's a set
        interval_set = list(set([ tuple(sorted(t)) for t in intervals ]))
        print(interval_set)
        if(len(interval_set)==1):
            return len(intervals) - len(interval_set)
        
        up_continuation = {}
        
        for i in range(0, len(interval_set)): 
            up = intervals[i][1]
            if(not up in up_continuation):
                up_continuation[up] = largestContinuationCount(up, intervals, up_continuation)
                
                
        #the max continuation
        max_cont = max(up_continuation, key=up_continuation.get)
        
        return len(intervals) - (max_cont+1)
            
            
            
