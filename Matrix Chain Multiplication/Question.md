# Matrix Chain Multiplication

## Problem Statement

Given a chain of matrices `A₁, A₂, A₃, ..., Aₙ`, determine the most efficient way to multiply these matrices by placing parentheses such that the **total number of scalar multiplications is minimized**.

The dimensions of the matrices are provided in an array `nums` of size `n`, where the dimension of matrix `Aᵢ` is:

```text
nums[i - 1] × nums[i]
```

Return the **minimum number of scalar multiplications** required to multiply the entire matrix chain.

---

## Examples

### Example 1

**Input**

```text
nums = [10, 15, 20, 25]
```

**Output**

```text
8000
```

**Explanation**

There are two possible parenthesizations:

```text
A1 × (A2 × A3)
```

Cost:

```text
15 × 20 × 25 + 10 × 15 × 25
= 7500 + 3750
= 11250
```

```text
(A1 × A2) × A3
```

Cost:

```text
10 × 15 × 20 + 10 × 20 × 25
= 3000 + 5000
= 8000
```

Minimum cost = **8000**

---

### Example 2

**Input**

```text
nums = [4, 2, 3]
```

**Output**

```text
24
```

**Explanation**

Only one multiplication is possible.

```text
A1 × A2

Cost = 4 × 2 × 3 = 24
```

---

## Approach (Dynamic Programming - Tabulation)

This is an **Interval DP** problem.

### State

```text
dp[i][j]
```

represents the **minimum multiplication cost required to multiply matrices from `Aᵢ` to `Aⱼ`**.

---

### Transition

For every possible partition point `k` between `i` and `j`:

```text
(Ai ... Ak) | (Ak+1 ... Aj)
```

Total cost becomes:

```text
Cost of Left Part
+
Cost of Right Part
+
Cost of multiplying the two resulting matrices
```

Transition:

```text
dp[i][j] =
min(
    dp[i][k]
    +
    dp[k+1][j]
    +
    nums[i-1] × nums[k] × nums[j]
)
```

---

## Algorithm

1. Create a 2D DP table.
2. Initialize diagonal values to `0` (a single matrix requires no multiplication).
3. Iterate over chain lengths from `2` to `n-1`.
4. For every interval `(i, j)`, try every partition `k`.
5. Store the minimum multiplication cost.
6. Return `dp[1][n-1]`.

---

## Complexity Analysis

* **Time Complexity:** `O(n³)`

  * Three nested loops (`len`, `i`, `k`).

* **Space Complexity:** `O(n²)`

  * DP table of size `n × n`.

---

## Key Learning

This is the classic **Interval Dynamic Programming** problem.

The main idea is:

* Solve **smaller matrix chains first**.
* Try **every possible partition**.
* Choose the partition with the **minimum total multiplication cost**.

This Interval DP pattern is also used in problems like:

* Burst Balloons
* Minimum Cost to Cut a Stick
* Boolean Parenthesization
* Palindrome Partitioning II
* Optimal Binary Search Tree
