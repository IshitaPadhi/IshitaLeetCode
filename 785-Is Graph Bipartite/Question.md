# 785. Is Graph Bipartite?

## Problem Statement

Given an undirected graph represented as an adjacency list, determine whether the graph is **bipartite**.

A graph is bipartite if its vertices can be divided into two disjoint sets such that every edge connects a vertex from one set to the other. In other words, no two adjacent vertices should belong to the same set.

Return `true` if the graph is bipartite; otherwise, return `false`.

**LeetCode:** Medium

---

## Approach

This solution uses **Depth First Search (DFS)** along with **2-coloring**.

- Maintain a `color[]` array.
- Initialize every node with `-1` (unvisited).
- Assign the starting node color `0`.
- During DFS:
  - Assign every unvisited neighbour the opposite color.
  - If a neighbour already has the same color as the current node, the graph cannot be bipartite.
- Since the graph may be disconnected, start DFS from every unvisited node.

---

## Algorithm

1. Create a `color` array and initialize all values to `-1`.
2. Traverse every vertex in the graph.
3. If a vertex is unvisited:
   - Color it with `0`.
   - Perform DFS.
4. For every neighbour:
   - If unvisited, assign the opposite color and continue DFS.
   - If already colored with the same color as the current node, return `false`.
5. If every component is successfully colored, return `true`.

---

## Dry Run

### Example

```text
Input:
graph = [[1,3],[0,2],[1,3],[0,2]]
```

Graph:

```text
      0
     / \
    1   3
     \ /
      2
```

Color assignment:

```text
0 → Yellow (0)

1 → Blue (1)

2 → Yellow (0)

3 → Blue (1)
```

Every edge connects opposite colors.

**Output**

```text
true
```

---

### Counter Example

```text
Input:
graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
```

Graph:

```text
      0
     /|\
    1-2 |
     \|/
      3
```

At some point, two adjacent nodes must receive the same color.

**Output**

```text
false
```

---

## Complexity Analysis

- **Time Complexity:** `O(V + E)`
  - Every vertex and every edge is visited once.

- **Space Complexity:** `O(V)`
  - Color array + DFS recursion stack.

---

## Key Concepts

- Graph Traversal
- Depth First Search (DFS)
- Graph Coloring
- Bipartite Graph
- Connected Components

---

## Java Solution

```java
class Solution {

    public boolean dfs(int[][] graph, int curr, int[] col) {

        for (int j = 0; j < graph[curr].length; j++) {

            int neighbour = graph[curr][j];

            if (col[neighbour] == -1) {

                int nextCol = (col[curr] == 0) ? 1 : 0;
                col[neighbour] = nextCol;

                if (!dfs(graph, neighbour, col))
                    return false;

            } else if (col[neighbour] == col[curr]) {

                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] col = new int[graph.length];

        for (int i = 0; i < graph.length; i++)
            col[i] = -1;

        for (int i = 0; i < graph.length; i++) {

            if (col[i] == -1) {

                col[i] = 0;

                if (!dfs(graph, i, col))
                    return false;
            }
        }

        return true;
    }
}
```

---

## Takeaways

- Bipartite graphs can be checked using **two-coloring**.
- DFS and BFS both provide an `O(V + E)` solution.
- The graph is **not bipartite if any edge connects two vertices having the same color**.
- Always iterate through every node because the graph may contain multiple disconnected components.

---

**Topics:** Graphs, DFS, BFS, Graph Coloring
