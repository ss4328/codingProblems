class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if grid==None or len(grid)==0:
            return 0
        islands = 0
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if grid[i][j]=='1':
                    islands+=self.dfs(i,j,grid)
        return islands
    
    def dfs(self, i, j, grid):
        if (i<0 or i>=len(grid) or j<0 or j>=len(grid[i]) or grid[i][j]=='0'):
            return 0
        
        grid[i][j]='0'
        self.dfs(i+1, j, grid)
        self.dfs(i-1, j, grid)
        self.dfs(i, j+1, grid)
        self.dfs(i, j-1, grid)
        return 1
