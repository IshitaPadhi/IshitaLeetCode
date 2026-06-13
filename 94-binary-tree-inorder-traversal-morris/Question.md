# 94. Binary Tree Inorder Traversal (Morris Traversal)

## Problem Statement

Given the `root` of a binary tree, return the **inorder traversal** of its nodes' values.

The inorder traversal follows the order:

> **Left → Root → Right**

This solution implements **Morris Inorder Traversal**, which achieves **O(1) auxiliary space** without using recursion or an explicit stack.

---

## LeetCode Link

https://leetcode.com/problems/binary-tree-inorder-traversal/

---

## Examples

### Example 1

**Input:**

```text
root = [1,null,2,3]
```

**Output:**

```text
[1,3,2]
```

---

### Example 2

**Input:**

```text
root = []
```

**Output:**

```text
[]
```

---

### Example 3

**Input:**

```text
root = [1]
```

**Output:**

```text
[1]
```

---

## Approach: Morris Inorder Traversal

Morris Traversal performs inorder traversal without using recursion or an auxiliary stack.

### Algorithm

1. Initialize `curr` as the root node.
2. While `curr` is not `null`:
   - If `curr.left` is `null`:
     - Visit the current node.
     - Move to `curr.right`.
   - Otherwise:
     - Find the inorder predecessor of `curr` (rightmost node in the left subtree).
     - If the predecessor's right child is `null`:
       - Create a temporary thread from predecessor to current node.
       - Move to the left child.
     - Otherwise:
       - Remove the temporary thread.
       - Visit the current node.
       - Move to the right child.
3. Return the inorder traversal list.

---

## Why Morris Traversal?

Unlike recursive or stack-based solutions, Morris Traversal temporarily modifies the tree structure to simulate the return path.

This allows traversal using **constant extra space**.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - Each edge is traversed at most twice.

- **Space Complexity:** `O(1)`
  - No recursion stack or auxiliary data structure is used.

---

## Topics

- Binary Tree
- Tree Traversal
- Inorder Traversal
- Morris Traversal
- Constant Space Algorithms

---

## Notes

- The original tree structure is restored before the algorithm terminates.
- Morris Traversal is a commonly asked interview technique for achieving inorder traversal with `O(1)` extra space.
