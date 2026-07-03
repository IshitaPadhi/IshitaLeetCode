# Detect Cycle in an Undirected Graph (BFS)

## Problem Statement

Given an undirected graph with `V` vertices labeled from `0` to `V-1`, determine whether the graph contains a cycle.

The graph is represented using an adjacency list where `adj[i]` contains all the neighbours of vertex `i`.

---

## Approach

We use **Breadth First Search (BFS)** along with a **parent node** to detect cycles.

### Idea

* Traverse every connected component using BFS.
* Store each node along with its **parent** in the queue.
* While exploring neighbours:

  * If the neighbour is **not visited**, mark it visited and push it into the queue with the current node as its parent.
  * If the neighbour is **already visited** and **is not the parent**, then a cycle exists.

The parent node helps distinguish between:

* Traversing back to the previous node (normal in an undirected graph).
* Encountering a previously visited node through a different path (cycle).

---

## Algorithm

1. Create a `visited` array.
2. Traverse every vertex (to handle disconnected graphs).
3. For every unvisited vertex:

   * Start BFS.
   * Push `(node, parent)` into the queue.
4. While the queue is not empty:

   * Remove the front node.
   * Traverse all its neighbours.
   * If a neighbour is unvisited:

     * Mark it visited.
     * Push `(neighbour, currentNode)` into the queue.
   * Else if the neighbour is not the parent, return `true`.
5. If no cycle is found, return `false`.

---

## Java Solution

```java
import java.util.*;

class Solution {

    public boolean detectCycleUtil(List<Integer>[] adj,
                                   boolean vis[],
                                   int start) {

        Queue<int[]> q = new LinkedList<>();

        // {currentNode, parentNode}
        q.add(new int[]{start, -1});
        vis[start] = true;

        while (!q.isEmpty()) {

            int[] front = q.remove();

            int curr = front[0];
            int par = front[1];

            // Traverse all neighbours
            for (int neighbour : adj[curr]) {

                // If neighbour is not visited
                if (!vis[neighbour]) {

                    vis[neighbour] = true;
                    q.add(new int[]{neighbour, curr});

                }

                // Visited neighbour that is not the parent
                else if (neighbour != par) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean vis[] = new boolean[V];

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (detectCycleUtil(adj, vis, i)) {
                    return true;
                }

            }
        }

        return false;
    }
}
```

---

## Dry Run

Example Graph:

```
0
|\
| \
1--2
    \
     3
```

Adjacency List:

```
0 -> 1, 2
1 -> 0, 2
2 -> 0, 1, 3
3 -> 2
```

### Initial State

```
Queue = [(0, -1)]

Visited = [T, F, F, F]
```

### Step 1

Remove:

```
(0, -1)
```

Neighbours:

```
1
2
```

Both are unvisited.

Mark visited and push:

```
Queue = [(1,0), (2,0)]

Visited = [T, T, T, F]
```

---

### Step 2

Remove:

```
(1,0)
```

Neighbours:

```
0
2
```

Neighbour `0` is the parent → Ignore.

Neighbour `2` is already visited **and is not the parent**.

Therefore,

```
Cycle Found
```

Return `true`.

---

## Why do we store the parent in the queue?

Instead of storing only the node,

```
Queue = [0, 1, 2]
```

we store

```
Queue = [(0,-1), (1,0), (2,0)]
```

This allows us to know **which node we came from**.

Without storing the parent, every visited neighbour would incorrectly appear to form a cycle.

---

## Time Complexity

* **Time:** `O(V + E)`

Each vertex and edge is processed at most once.

---

## Space Complexity

* **Visited Array:** `O(V)`
* **Queue:** `O(V)`

Overall Space Complexity: **O(V)**

---

## Key Takeaways

* Uses **BFS** instead of DFS.
* Stores `(currentNode, parentNode)` in the queue.
* A visited neighbour that is **not** the parent indicates a cycle.
* Works for disconnected graphs by starting BFS from every unvisited vertex.
