# Top View of Binary Tree

## Problem Statement

Given the root of a binary tree, return the top view of the binary tree.

The top view of a binary tree consists of the set of nodes visible when the tree is observed from above.

Return the values of these nodes ordered from the leftmost to the rightmost position.

If multiple nodes share the same horizontal distance from the root, only the node that appears first when traversing from left to right (i.e., the leftmost node) should be included in the result.

---

## Examples

### Example 1

**Input:**

```
root = [1, 2, 3, 4, 5, 6, 7]
```

**Output:**

```
[4, 2, 1, 3, 7]
```

---

### Example 2

**Input:**

```
root = [10, 20, 30, 40, 60, 90, 100]
```

**Output:**

```
[40, 20, 10, 30, 100]
```

---

## Approach

* Use **Breadth First Search (Level Order Traversal)** to process nodes level by level.
* Assign every node a **Horizontal Distance (HD)** from the root.

  * Root → HD = 0
  * Left Child → HD - 1
  * Right Child → HD + 1
* Store the **first node encountered** for each horizontal distance using a HashMap.
* Track the minimum and maximum horizontal distances.
* Finally, traverse from `min HD` to `max HD` and collect the corresponding node values.

---

## Algorithm

1. If the root is `null`, return an empty list.
2. Initialize a queue storing `(node, horizontal distance)`.
3. Initialize a HashMap to store the first node at each horizontal distance.
4. Perform BFS:

   * Remove the front node.
   * If its HD is not present in the map, insert it.
   * Add the left child with `HD - 1`.
   * Add the right child with `HD + 1`.
   * Update `minHD` and `maxHD`.
5. Traverse from `minHD` to `maxHD` and add the stored node values to the answer list.
6. Return the answer.

---

## Complexity Analysis

* **Time Complexity:** `O(N)`
* **Space Complexity:** `O(N)`

where `N` is the number of nodes in the binary tree.

---

## Tags

`Binary Tree` `BFS` `HashMap` `Queue` `Tree Traversal`
