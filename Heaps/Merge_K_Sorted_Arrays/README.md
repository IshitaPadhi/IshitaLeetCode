# Merge K Sorted Arrays

## Problem Statement

You are given `k` sorted arrays, each of size `k`. Merge all the arrays into one sorted array and return it.

You should use an efficient algorithm with **O(k² log k)** time complexity.

---

## Examples

### Example 1

**Input:**
```text
k = 3
arr = [[1,2,3],
       [4,5,6],
       [7,8,9]]
```

**Output:**
```text
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

---

### Example 2

**Input:**
```text
k = 4
arr = [[1,2,3,4],
       [2,2,3,4],
       [5,5,6,6],
       [7,8,9,9]]
```

**Output:**
```text
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
```

---

### Example 3

**Input:**
```text
k = 1
arr = [[10]]
```

**Output:**
```text
[10]
```

---

## Constraints

- `1 <= k <= 100`
- Each row `arr[i]` is sorted in ascending order.
- Total elements = `k × k` (i.e., the matrix is `k × k`).
