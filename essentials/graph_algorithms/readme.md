# Graph Algorithms

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

## Subsections
- Search
- Minimum Spanning Trees
- Single Shortest Path algorithms

## License
[MIT](https://choosealicense.com/licenses/mit/)