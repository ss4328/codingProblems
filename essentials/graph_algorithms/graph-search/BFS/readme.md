# BFS problems

On the top of my favorite BFS problems is 1197->Minimum Knight Moves. This is one of those problems that give you an 'aha' moment when you solve it. The problem looks easy, but solving it requires some familiarity with BFS, and optimizations. 


## Probem statement:
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

## Approach:
- We run a BFS as it ensures the shortest path, and that's what we want
- However, BFS as is doesn't have a counter, we try to tackle this problem by embedding the step count in the queue itself. This was very tricky for me to implement as this is the first time I did this.
- Then when this is done, your BFS is completed. However, it's too slow given the time constraints.

### Optimizations:
Right off the bat, I thought of using A* as it'd be fastest, but I also thought it would be a glorious overkill. 
I learned in AI class that we could use symmetric geometry of problem space to optimize, that's what I did. Since we start from origin, any coordinate has 4 mirror images, which we could ignore with careful optimizations.


- So, First thing first, the problem sets in a infinite coordinates, actually you just need one quarter of the whole area, because it is symmetric according to the point (0,0). Then for each point, you can go in eight direction with increment on dx,dy in code. Put all new location in que except the position you already visited. Return the step until you reach position (x,y).

- To be noted: be carefull with the index. Also in last If statement, if (X<=x+2 and Y<=y+2) is because you might need to go beyond the desired postion and go one step back.


## Implementation: 

```python
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
        
        return 0
```

The corner cases were defintely a pain in the bum. But I guess optimizing plain BFS would have it's own pains. Bi-directional BFS would work nicely too but my own obstinate nature got the better off me. I just wanted an optimized working BFS here, which I did and that's the end of it. 

## Other favorite questions:
200. Number of Islands
994. Rotting oranges

I'd suggest doing 200. Number of islands, tehn knights move, then rotting oranges because of corner cases or simply the amount of effot in implementation.
