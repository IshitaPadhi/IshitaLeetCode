# DFS and BFS Traversal of Graph

## Problem Statement

Given an undirected connected graph with **V** vertices numbered from **0** to **V-1**, perform:

- **Depth First Search (DFS)**
- **Breadth First Search (BFS)**

starting from the **0th vertex**.

The graph is represented as an **edge list**, where each edge is of the form:

```
[u, v]
```

indicating an undirected edge between vertices `u` and `v`.

---

## Example

### Input

```text
V = 5

edges = [
    [0,1],
    [0,2],
    [0,3],
    [2,4]
]
```

### Output

```text
DFS : [0,2,4,3,1]

BFS : [0,2,3,1,4]
```

---

## Approach

### Step 1

Convert the given **edge list** into an **adjacency list**.

Example:

```text
0 -> 1,2,3
1 -> 0
2 -> 0,4
3 -> 0
4 -> 2
```

---

### DFS

- Start from node 0.
- Mark node as visited.
- Visit all unvisited neighbours recursively.

Time Complexity:

```
O(V + E)
```

Space Complexity:

```
O(V)
```

---

### BFS

- Start from node 0.
- Push it into a queue.
- Visit nodes level by level.
- Push all unvisited neighbours into the queue.

Time Complexity:

```
O(V + E)
```

Space Complexity:

```
O(V)
```

---

## Concepts Used

- Graph Representation
- Adjacency List
- DFS (Recursion)
- BFS (Queue)
- Visited Array

---
