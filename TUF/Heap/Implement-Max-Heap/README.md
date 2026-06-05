Here's the clean, paste-ready version:

---

# 🏔️ Max Heap Implementation

## Problem Statement

Implement a **Max Heap** data structure supporting the following operations:

| Method | Description |
|--------|-------------|
| `initializeHeap` | Initialize the heap to an empty state |
| `insert(x)` | Insert value `x` into the max heap |
| `getMax` | Return the maximum value (root) without removing it |
| `extractMax` | Remove and return the maximum element |
| `heapSize` | Return the current number of elements in the heap |
| `isEmpty` | Return `0` (false) or `1` (true) depending on whether heap is empty |
| `changeKey(ind, val)` | Update the element at 0-based index `ind` to `val`, then re-heapify |

> ⚠️ **Important:** When extracting the max, if both left and right children are equal, swap with the **LEFT child**.

---

## Examples

### Example 1

**Input:**
```
operations = ["initializeHeap", "insert", "insert", "insert", "getMax", "heapSize", "isEmpty", "extractMax", "changeKey", "getMax"]
nums       = [[4], [1], [10], [0, 16]]
```

**Output:**
```
[null, null, null, null, 10, 3, 0, null, null, 16]
```

**Step-by-step trace:**

| Step | Operation | Heap State | Output |
|------|-----------|------------|--------|
| 1 | `initializeHeap` | `[]` | `null` |
| 2 | `insert(4)` | `[4]` | `null` |
| 3 | `insert(1)` | `[4, 1]` | `null` |
| 4 | `insert(10)` | `[10, 1, 4]` | `null` |
| 5 | `getMax` | `[10, 1, 4]` | `10` |
| 6 | `heapSize` | `[10, 1, 4]` | `3` |
| 7 | `isEmpty` | `[10, 1, 4]` | `0` |
| 8 | `extractMax` | `[4, 1]` | `null` |
| 9 | `changeKey(0, 16)` | `[16, 1]` | `null` |
| 10 | `getMax` | `[16, 1]` | `16` |

---

### Example 2

**Input:**
```
operations = ["initializeHeap", "insert", "insert", "extractMax", "getMax", "insert", "heapSize", "isEmpty", "extractMax", "changeKey", "getMax"]
nums       = [[4], [1], [4], [0, 2]]
```

**Output:**
```
[null, null, null, null, 1, null, 2, 0, null, null, 2]
```

---

## Constraints

- `1 <= n <= 10^5`
- `-10^5 <= nums[i] <= 10^5`

---

## Tags

`Data Structures` `Heap` `Priority Queue` `Binary Tree` `Implementation`

---

*Problem source: Take U Forward (TUF)*
