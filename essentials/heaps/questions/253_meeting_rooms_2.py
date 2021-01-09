class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if len(intervals)<=1:
            return len(intervals)
        intervals = sorted(intervals, key=lambda x:x[0])
        free_rooms = []
        
        #push first meeting time to free_rooms min-heap
        heapq.heappush(free_rooms,intervals[0][1])
        
        for i in range(1,len(intervals)):
            interval = intervals[i]
            if free_rooms[0]<=interval[0]:
                heapq.heappop(free_rooms)
            heapq.heappush(free_rooms, interval[1])
        return len(free_rooms)
        
