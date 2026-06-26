# 0-1 Knapsack

## Problem Statement

Given `N` items where each item has a **weight** and a **value**, determine the maximum total value that can be obtained by selecting items such that:

* Each item can be chosen **at most once**.
* The total weight of the selected items does not exceed the knapsack capacity `W`.

---

## Approach

This solution uses **Dynamic Programming (Bottom-Up Tabulation)**.

### DP State

`dp[i][j]` represents the **maximum profit** that can be obtained using the **first `i` items** with a knapsack capacity of **`j`**.

---

## Transition

For every item:

* If the current item's weight is less than or equal to the current capacity:

  * **Include the item**

    * Profit = Current Item Value + Profit from remaining capacity
  * **Exclude the item**

    * Profit = Previous row's value
  * Store the maximum of the two.

* Otherwise:

  * The item cannot be included.
  * Copy the value from the previous row.

Transition:

```text
If (weight <= capacity)

dp[i][j] = max(
    value + dp[i-1][j-weight],
    dp[i-1][j]
)

Else

dp[i][j] = dp[i-1][j]
```

---

## Base Case

* `dp[0][j] = 0` → No items available.
* `dp[i][0] = 0` → Knapsack capacity is zero.

---

## Time Complexity

* **Time:** `O(N × W)`

where:

* `N` = Number of items
* `W` = Knapsack Capacity

---

## Space Complexity

* **Space:** `O(N × W)`

---

## Concepts Used

* Dynamic Programming
* Bottom-Up Tabulation
* Include / Exclude Technique
* 0-1 Knapsack

---

## Learning Notes

* The DP table is **1-indexed** while the arrays are **0-indexed**, therefore the current item is accessed using:

  * `wt[i - 1]`
  * `val[i - 1]`

* For each item, two choices are evaluated:

  1. Include the item (if it fits).
  2. Exclude the item.

* The maximum of these two choices is stored in the DP table.

---

## Status

✅ Solved using Dynamic Programming (Tabulation)
