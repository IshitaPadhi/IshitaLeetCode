# Maximum Sum Increasing Subsequence

## Problem Statement

Given an array `arr[]` of positive integers, find the **maximum possible sum** of a subsequence such that the elements of the subsequence are in **strictly increasing order**.

A subsequence does **not** need to be contiguous, but the relative order of elements must be preserved.

---

## Approach

This problem is a variation of the **Longest Increasing Subsequence (LIS)** Dynamic Programming pattern.

Instead of storing the **length** of the LIS, we store the **maximum sum** of an increasing subsequence ending at each index.

* Let `dp[i]` represent the **maximum sum of an increasing subsequence ending at index `i`**.
* Initially, every element can form a subsequence of its own.

```
dp[i] = arr[i]
```

For every index `i`, check all previous indices `j`.

If `arr[j] < arr[i]`, then the current element can extend the increasing subsequence ending at `j`.

Transition:

```
dp[i] = max(dp[i], dp[j] + arr[i])
```

Finally, the answer is the maximum value present in the `dp` array because the optimal subsequence can end at any index.

---

## Algorithm

1. Create a DP array of size `n`.
2. Initialize `dp[i] = arr[i]`.
3. Traverse all previous elements for every index.
4. If `arr[j] < arr[i]`, update the DP value.
5. Return the maximum value in the DP array.

---

## Dry Run

### Input

```
arr = [1, 101, 2, 3, 100]
```

Initial DP:

```
[1, 101, 2, 3, 100]
```

After processing:

```
[1, 101, 3, 6, 106]
```

Maximum value:

```
106
```

Increasing subsequence:

```
1 → 2 → 3 → 100
```

Sum:

```
106
```

---

## Complexity Analysis

* **Time Complexity:** `O(n²)`
* **Space Complexity:** `O(n)`

---

## Key Learning

This problem follows the exact same DP pattern as the classic Longest Increasing Subsequence (LIS).

| Longest Increasing Subsequence | Maximum Sum Increasing Subsequence |
| ------------------------------ | ---------------------------------- |
| `dp[i] = length ending at i`   | `dp[i] = sum ending at i`          |
| Initialize with `1`            | Initialize with `arr[i]`           |
| Transition: `dp[j] + 1`        | Transition: `dp[j] + arr[i]`       |
| Answer = maximum length        | Answer = maximum sum               |

The only difference from LIS is **what the DP array stores**:

* **LIS** stores the length.
* **MSIS** stores the maximum sum.
