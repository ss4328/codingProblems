# Minimum Spanning Trees

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. 

The cost of the spanning tree is the sum of the weights of all the edges in the tree. 

- There can be many spanning trees. 
- Minimum spanning tree is the spanning tree where the cost is minimum among all the spanning trees. There also can be many minimum spanning trees.

Minimum spanning tree has direct application in the design of networks. It is used in algorithms approximating the travelling salesman problem, multi-terminal minimum cut problem and minimum-cost weighted perfect matching. Other practical applications are:

1. Cluster Analysis
2. Handwriting recognition
3. Image segmentation

![Trees](https://he-s3.s3.amazonaws.com/media/uploads/146b47a.jpg)

## Prims Algorithm
Prim’s algorithm finds the cost of a minimum spanning tree from a weighted undirected graph. This algorithm begins by randomly selecting a vertex and adding the least expensive edge from this vertex to the spanning tree. The algorithm continues to add the least expensive edge from the vertices already added to the spanning tree to make it grow and terminates when all the vertices are added to the spanning tree. It is evident that the algorithm gets greedy by selecting the least expensive edge from the vertices already added to the spanning tree.


```python
from dataclasses import dataclass, field

# Setting frozen=True and eq=True makes a class immutable and hashable.
# eq=False is needed so that dictionary can contain multiple items with
# the same key (Node(idnum)) but with different values (cost)
@dataclass(eq=False)
class Node :
    idnum : int

@dataclass
class Graph :
    source  : int
    adjlist : dict

    def PrimsMST(self):

        # Priority queue is implemented as a dictionary with
        # keys as object of 'Node' class and value.
        # Since the priority queue will can have multiple entries for the 
        # same adjnode but with different cost, we have to use objects as
        # keys so that they can be stored in a dictionary. 
        # [As dictionary can't have duplicate keys so objectify the key]

        priority_queue = { Node(self.source) : 0 }
        added = [False] * len(self.adjlist)
        min_span_tree_cost = 0

        while priority_queue :
            # Choose the adjacent node with the least edge cost
            node = min(priority_queue, key=priority_queue.get)
            cost = priority_queue[node]

            # Remove the element from a dictionary in python
            del priority_queue[node]

            if added[node.idnum] == False :
                min_span_tree_cost += cost
                added[node.idnum] = True
                print("Added Node : " + str(node.idnum) + ", cost now : "+str(min_span_tree_cost))

                for item in self.adjlist[node.idnum] :
                    adjnode = item[0]
                    adjcost = item[1]
                    if added[adjnode] == False :
                        priority_queue[Node(adjnode)] = adjcost

        return min_span_tree_cost

def main() :

    g1_edges_from_node = {}

    # Outgoing edges from the node: (adjacent_node, cost) in graph 1.
    g1_edges_from_node[0] = [ (1,1), (2,2), (3,1), (4,1), (5,2), (6,1) ]
    g1_edges_from_node[1] = [ (0,1), (2,2), (6,2) ]
    g1_edges_from_node[2] = [ (0,2), (1,2), (3,1) ]
    g1_edges_from_node[3] = [ (0,1), (2,1), (4,2) ]
    g1_edges_from_node[4] = [ (0,1), (3,2), (5,2) ]
    g1_edges_from_node[5] = [ (0,2), (4,2), (6,1) ]
    g1_edges_from_node[6] = [ (0,1), (2,2), (5,1) ]

    g1 = Graph(0, g1_edges_from_node)
    cost = g1.PrimsMST()
    print("Cost of the minimum spanning tree in graph 1 : " + str(cost) +"\n")

    # Outgoing edges from the node: (adjacent_node, cost) in graph 2.
    g2_edges_from_node = {}
    g2_edges_from_node[0] = [ (1,4), (2,1), (3,5) ];
    g2_edges_from_node[1] = [ (0,4), (3,2), (4,3), (5,3) ];
    g2_edges_from_node[2] = [ (0,1), (3,2), (4,8) ];
    g2_edges_from_node[3] = [ (0,5), (1,2), (2,2), (4,1) ];
    g2_edges_from_node[4] = [ (1,3), (2,8), (3,1), (5,3) ];
    g2_edges_from_node[5] = [ (1,3), (4,3) ];

    g2 = Graph(0, g2_edges_from_node)
    cost = g2.PrimsMST()
    print("Cost of the minimum spanning tree in graph 1 : " + str(cost))

if __name__ == "__main__" :
    main()
```

## License
[MIT](https://choosealicense.com/licenses/mit/)