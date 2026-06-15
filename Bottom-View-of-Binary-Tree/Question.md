# Bottom View of Binary Tree

## Problem Statement

Given the root of a binary tree, return the bottom view of the binary tree.

The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Return nodes from the leftmost node to the rightmost node.

If two nodes are at the same horizontal distance and depth, consider the node that appears later in level order traversal.

---

## Example 1

**Input:**
```text
root = [20, 8, 22, 5, 3, null, 25, null, null, 10, 14]
```

**Output:**
```text
[5, 10, 3, 14, 25]
```

**Explanation:**

- HD = -2 → 5
- HD = -1 → 8, 10 → 10 is visible from the bottom
- HD = 0 → 20, 3 → 3 is visible from the bottom
- HD = 1 → 22, 14 → 14 is visible from the bottom
- HD = 2 → 25

Bottom View: `[5, 10, 3, 14, 25]`

---

## Example 2

**Input:**
```text
root = [20, 8, 22, 5, 3, 4, 25, null, null, 10, 14]
```

**Output:**
```text
[5, 10, 4, 14, 25]
```

**Explanation:**

Nodes 3 and 4 share the same horizontal distance and level. Since node 4 appears later in level order traversal, it is included in the bottom view.

---

## Approach

- Use Breadth First Search (BFS) along with horizontal distances (HD).
- Assign:
  - Root → HD = 0
  - Left Child → HD - 1
  - Right Child → HD + 1
- Store nodes in a HashMap using HD as the key.
- Unlike Top View, always overwrite the existing node for a given HD.
- Track the minimum and maximum horizontal distances encountered.
- Traverse from minimum HD to maximum HD to generate the final answer.

---

## Algorithm

1. If the root is null, return an empty list.
2. Initialize a queue storing `(node, horizontalDistance)`.
3. Initialize a HashMap to store the latest node for each HD.
4. Perform BFS:
   - Remove the front node.
   - Update the map for the current HD.
   - Add left child with `HD - 1`.
   - Add right child with `HD + 1`.
   - Update minimum and maximum HD.
5. Traverse from `minHD` to `maxHD` and add node values to the answer list.
6. Return the answer.

---

## Complexity Analysis

- **Time Complexity:** `O(N)`
- **Space Complexity:** `O(N)`

where `N` is the number of nodes in the binary tree.

---

## Tags

`Binary Tree` `BFS` `HashMap` `Queue` `Tree Traversal`
