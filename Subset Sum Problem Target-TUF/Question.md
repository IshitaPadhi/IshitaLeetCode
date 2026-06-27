# Subset Sum Problem

## Problem Statement

Given an array `arr[]` of positive integers and an integer `target`, determine whether there exists a subset of the array whose sum is exactly equal to `target`.

Return:
- `true` if such a subset exists.
- `false` otherwise.

---

## Example 1

**Input:**
```text
arr = [3, 34, 4, 12, 5, 2]
target = 9
```

**Output:**
```text
true
```

**Explanation:**
The subset `{4, 5}` has a sum of `9`.

---

## Example 2

**Input:**
```text
arr = [3, 34, 4, 12, 5, 2]
target = 30
```

**Output:**
```text
false
```

**Explanation:**
No subset of the array sums to `30`.

---

## Approach

This problem is solved using **Dynamic Programming (0/1 Knapsack Pattern).**

### DP State

`dp[i][j]` represents whether it is possible to obtain a sum `j` using the first `i` elements of the array.

### Transition

- If the current element can be included:

```text
dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j]
```

- Otherwise:

```text
dp[i][j] = dp[i-1][j]
```

### Base Case

- A sum of `0` is always possible by choosing no elements.
- Therefore:

```text
dp[i][0] = true
```

---

## Complexity Analysis

- **Time Complexity:** `O(n × target)`
- **Space Complexity:** `O(n × target)`

where:
- `n` = number of elements
- `target` = required subset sum

---

## Concepts Used

- Dynamic Programming
- 0/1 Knapsack Pattern
- Subset Problems
- Boolean DP
