# Graph Search Algorithms

In this whole repo, this is the hardest part to make notes on because of the sheer overwhelming amount of information available on each sub topics. Just choosing subtopics worthy to be included is a problem in itself. 

So, I figured I'll just cover the topics with most use cases, sorted by popularity.

Before we move forward though, it's good to just refresh rudimentary graph theory (although most of it won't be used in the first couple algorithms, it's good to have them in the back of your head). So, first things first: 

### Elementary graph theory

- A Graph is a non-linear data structure consisting of nodes and edges. 
- The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph.

![](https://www.geeksforgeeks.org/wp-content/uploads/undirectedgraph.png)

Set of vertices V = {0,1,2,3,4} ;
Set of edges E = {01, 12, 23, 34, 04, 14, 13}.

#### More subtleties 

- Graphs can be Undirected or Directed.
- Edges can have weights or can be unweighted. 

## Graph Traversal Algorithms

Since we don't have a way to 'look sideways', we're left with 2 main ways to traverse a graph. 
1) We can goo deeper in each level until target is found. This is called **Depth-First Search(DFS)**
2) We can exhaust each 'level' until we can find the target. This is called **Breadth-First Search(BFS)**

#### What's common? 
- These algorithms specify an order to search through the nodes of a graph
- We start at the source node and keep searching until we find the target node.
- The **frontier** contains nodes that we've seen but haven't explored yet.
- Each iteration, we take a node off the **frontier**, and add its neighbors to the **frontier**.

#### Specifics
- If we want to go 'deeper'(DFS) we have to explore a node's child before another node. That'd be a stack use case
- If we want to go 'broader'(BFS), we have to expand nodes on same level. A queue can be used here. 

[![](https://i.postimg.cc/dtG0MmXM/Screen-Shot-2020-07-30-at-12-08-23-PM.png)](https://postimg.cc/CzL0kDSJ)

## DFS
DFS is all about diving as deep as possible before coming back to take a dive again. In DFS, we: 
1) push to stack, 
2) pop top , 
3) retrieve unvisited neighbors of top, push them to stack 
4) repeat 1,2,3 while stack is not empty

Something like:
```python
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        l=[]
        st=[]
        
        if(root!=None):
            st.append(root)
        
        while(len(st) is not 0):
            cur = st.pop()
            l.append(cur.val)
            
            if(cur.right!=None):
                st.append(cur.right)
            
            if(cur.left!=None):
                st.append(cur.left)
            
        return l

```

##BFS

Breadth--First Search(BFS) is a method for exploring a tree or graph. In a BFS, you first explore all the nodes one step away, then all the nodes two steps away, etc.

Breadth-first search is like throwing a stone in the center of a pond. The nodes you explore "ripple out" from the starting point.

DFS is all about diving as deep as possible before coming back to take a dive again. In DFS, we: 
1) push to stack, 
2) pop top , 
3) retrieve unvisited neighbors of top, push them to stack 
4) repeat 1,2,3 while stack is not empty

```python
graph = {
  'A' : ['B','C'],
  'B' : ['D', 'E'],
  'C' : ['F'],
  'D' : [],
  'E' : ['F'],
  'F' : []
}

visited = [] # List to keep track of visited nodes.
queue = []     #Initialize a queue

def bfs(visited, graph, node):
  visited.append(node)
  queue.append(node)

  while queue:
    s = queue.pop(0) 
    print (s, end = " ") 

    for neighbour in graph[s]:
      if neighbour not in visited:
        visited.append(neighbour)
        queue.append(neighbour)

# Driver Code
bfs(visited, graph, 'A')
```
Advantages:

A BFS will find the shortest path between the starting point and any other reachable node. A depth-first search will not necessarily find the shortest path.
Disadvantages

A BFS on a binary tree generally requires more memory than a DFS.

## A problem solving perspective
Like 25% percent of intermediate/medium level problems (tree and string) simply boil down to a DFS / BFS. 

What else is a tree but a connected acyclic graph with N nodes and N-1 edges. Also, two vertices are connected by exactly one path. 

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)