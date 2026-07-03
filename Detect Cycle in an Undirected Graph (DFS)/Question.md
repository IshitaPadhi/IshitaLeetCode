# Detect Cycle in an Undirected Graph (DFS)

## Problem Statement

Given an undirected graph with `V` vertices labeled from `0` to `V-1`, determine whether the graph contains a cycle.

The graph is represented using an adjacency list where `adj[i]` contains all the neighbours of vertex `i`.

---

## Approach

We use **Depth First Search (DFS)** along with a **parent node** to detect cycles.

### Idea

* Traverse every connected component using DFS.
* Mark each visited node.
* While exploring neighbours:

  * If the neighbour is **not visited**, continue DFS.
  * If the neighbour is **already visited** and **is not the parent**, then a cycle exists.

The parent node is required because, in an undirected graph, every edge appears twice. Visiting the parent again is normal and should **not** be considered a cycle.

---

## Algorithm

1. Create a `visited` array.
2. Traverse every vertex (to handle disconnected graphs).
3. For every unvisited vertex:

   * Start DFS with parent = `-1`.
4. During DFS:

   * Mark the current node as visited.
   * Traverse all neighbours.
   * If a neighbour is unvisited, recursively call DFS.
   * If a neighbour is already visited and is **not** the parent, return `true`.
5. If no cycle is found after traversing the entire graph, return `false`.

---

## Java Solution

```java
class Solution {

    public boolean detectCycleUtil(List<Integer>[] adj, boolean vis[],
                                   int curr, int par) {

        // Mark current node as visited
        vis[curr] = true;

        // Traverse all neighbours
        for (int i = 0; i < adj[curr].size(); i++) {

            int neighbour = adj[curr].get(i);

            // If neighbour is not visited
            if (!vis[neighbour]) {

                if (detectCycleUtil(adj, vis, neighbour, curr)) {
                    return true;
                }

            }

            // Visited neighbour that is not the parent -> Cycle found
            else if (neighbour != par) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean vis[] = new boolean[V];

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (detectCycleUtil(adj, vis, i, -1)) {
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

Traversal:

```
DFS(0, -1)
    ↓
DFS(1, 0)
    ↓
DFS(2, 1)
```

At node `2`:

* Neighbour `0` is already visited.
* Parent of `2` is `1`.
* Since `0 != 1`, a cycle is detected.

Return `true`.

---

## Why do we pass `-1` as the parent?

The starting node has **no parent**, so we pass `-1`, which is not a valid vertex.

```
detectCycleUtil(adj, vis, 0, -1);
```

During recursion:

```
detectCycleUtil(adj, vis, neighbour, curr);
```

This allows the algorithm to distinguish:

* Returning to the **parent** → Normal traversal
* Visiting any **other visited node** → Cycle detected

---

## Time Complexity

* **Time:** `O(V + E)`

Every vertex and every edge is visited at most once.

---

## Space Complexity

* **Visited Array:** `O(V)`
* **Recursion Stack:** `O(V)` (worst case)

Overall Space Complexity: **O(V)**

---

## Key Takeaways

* Works for disconnected graphs.
* Uses DFS with a parent node.
* A visited neighbour that is **not** the parent indicates a cycle.
* Initial parent is `-1` because the starting node has no parent.
