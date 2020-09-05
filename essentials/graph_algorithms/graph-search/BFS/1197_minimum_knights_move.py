from collections import deque
class Solution(object):
        
    def minKnightMoves(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        #all possible 8 movements for the knight
        row = [2, 2, -2, -2, 1, 1, -1, -1 ]
        col = [1, -1, 1, -1, 2, -2, 2, -2 ]
        
        #BFS guarantees shortest path, so this will be a BFS implementation question
        visited = set()
        q = deque()
        q.append([0, 0, 0])
        x,y = abs(x), abs(y)        #reducing the problem to the first quadrant only since problem is symmetrical
        
        if(x==0 and y==0):
            return 0
        if(x==1 and y==1):
            return 2
        
        while q:
            x1, y1, steps = q.popleft()
            node = (x1, y1)
            
            if node not in visited:
                visited.add((node[0], node[1]))
                
                for i in range(8):
                    x2 = node[0]+row[i]
                    y2 = node[1]+col[i]
                    
                    #if destination is reached return number of steps
                    if(x2==x and y2==y):
                        return steps+1
                    
                    if(x2>=0 and y2>=0 and x2<=x+2 and y2<=y+2):            # symmetrical optimization
                        q.append((x2, y2, steps+1))
        
        return -1
