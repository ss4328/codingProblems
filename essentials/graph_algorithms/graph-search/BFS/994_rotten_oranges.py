class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        fresh, rottenPos = 0, collections.deque([])
        #1-pass for corner cases
        for i in range(0, len(grid)):
            for j in range(0, len(grid[i])):
                if(grid[i][j])==2:
                    rottenPos.append((i, j))
                elif grid[i][j]==1:
                    fresh+=1
        
        if fresh==0:                        #no fresh oranges
            return 0
        if len(rottenPos)==0:               #no rotten oranges
            return -1 
        
        fresh, mins = self.conc_bfs(grid, rottenPos, fresh)
        return -1 if fresh>0 else mins
    
    # runs concurrent bfs from rottenPos positions until there's an iteration where no oranges get rotten
    def conc_bfs(self, grid, rottenPos, fresh):
        mins=0
        while len(rottenPos) and fresh:
            l = len(rottenPos)
            while l:
                l -= 1
                # get rotten orange's position from queue
                i, j = rottenPos.popleft()
                if i > 0 and grid[i - 1][j] == 1:
                    grid[i - 1][j] = 2
                    rottenPos.append((i - 1, j))
                    fresh -= 1
                if i < len(grid) - 1 and grid[i + 1][j] == 1:
                    grid[i + 1][j] = 2
                    rottenPos.append((i + 1, j))
                    fresh -= 1
                if j > 0 and grid[i][j - 1] == 1:
                    grid[i][j - 1] = 2
                    rottenPos.append((i, j - 1))
                    fresh -= 1
                if j < len(grid[0]) - 1 and grid[i][j + 1] == 1:
                    grid[i][j + 1] = 2
                    rottenPos.append((i, j + 1))
                    fresh -= 1
            mins += 1
        
        # return fresh, number of continuous minutes till which oranges rotted
        return fresh, mins

