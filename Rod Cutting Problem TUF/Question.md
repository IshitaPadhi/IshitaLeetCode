# Rod Cutting Problem

## Problem Statement

Given a rod of length `n` and an array `price[]` where `price[i]` represents the price of a rod piece of length `i + 1`, determine the maximum obtainable value by cutting up the rod and selling the pieces.

You may cut the rod into any number of pieces, and each piece length can be used multiple times.

Return the maximum profit that can be obtained.

---

## Example 1

**Input:**

```text
n = 8
price = [1, 5, 8, 9, 10, 17, 17, 20]
```

**Output:**

```text
22
```

**Explanation:**

The maximum profit is obtained by cutting the rod into pieces of lengths `2` and `6`.

```text
Price(2) + Price(6) = 5 + 17 = 22
```

---

## Example 2

**Input:**

```text
n = 4
price = [2, 5, 7, 8]
```

**Output:**

```text
10
```

**Explanation:**

Cut the rod into two pieces of length `2`.

```text
5 + 5 = 10
```

which is greater than selling the rod as a whole (`8`).

---

## Approach

This problem is a classic **Unbounded Knapsack** problem.

### DP State

`dp[i][j]` represents the maximum profit that can be obtained using the first `i` available rod lengths to form a rod of total length `j`.

### Transition

If the current rod length can be used:

```text
dp[i][j] = max(
    price[i-1] + dp[i][j - length],
    dp[i-1][j]
)
```

- **Include:** Cut the current piece and continue using it (since it can be chosen multiple times).
- **Exclude:** Skip the current piece.

Otherwise,

```text
dp[i][j] = dp[i-1][j]
```

### Base Case

If no rod pieces are available or the required rod length is `0`, the maximum profit is `0`.

```text
dp[0][j] = 0
dp[i][0] = 0
```

---

## Complexity Analysis

- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(n²)`

where `n` is the length of the rod.

---

## Key Concepts

- Dynamic Programming
- Unbounded Knapsack
- Optimization Problems
- Bottom-Up DP
