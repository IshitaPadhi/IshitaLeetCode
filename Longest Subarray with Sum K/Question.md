# Longest Subarray with Sum K

## Problem Statement

Given an array `nums` of size `n` and an integer `k`, find the length of the **longest sub-array** whose sum is equal to `k`.

If no such sub-array exists, return `0`.

## Examples

### Example 1

**Input:**

```text
nums = [10, 5, 2, 7, 1, 9]
k = 15
```

**Output:**

```text
4
```

**Explanation:**

The longest sub-array with a sum equal to `15` is:

```text
[5, 2, 7, 1]
```

Its length is `4` and:

```text
5 + 2 + 7 + 1 = 15
```

The sub-array starts at index `1` and ends at index `4`.

---

### Example 2

**Input:**

```text
nums = [-3, 2, 1]
k = 6
```

**Output:**

```text
0
```

**Explanation:**

There is no sub-array whose sum is equal to `6`, so the answer is `0`.

---

### Example 3

**Input:**

```text
nums = [-1, 1, 1]
k = 1
```

**Output:**

```text
3
```

**Explanation:**

The entire array has sum:

```text
-1 + 1 + 1 = 1
```

Therefore, the longest sub-array has length `3`.

## Constraints

* `1 <= n <= 10^5`
* `-10^5 <= nums[i] <= 10^5`
* `-10^9 <= k <= 10^9`

## Approach

### Approach 1: Prefix Sum + HashMap

Use a prefix sum and store the **first occurrence** of each prefix sum in a HashMap.

For every index `i`:

```text
prefixSum = prefixSum + nums[i]
```

We need a previous prefix sum such that:

```text
prefixSum - previousSum = k
```

Therefore:

```text
previousSum = prefixSum - k
```

If `prefixSum - k` exists in the HashMap, we have found a sub-array whose sum is `k`.

Store only the **first occurrence** of each prefix sum because the earliest index gives the maximum possible sub-array length.

### Complexity

* **Time Complexity:** `O(N)`
* **Space Complexity:** `O(N)`

> **Note:** A simple Sliding Window/Two Pointer approach works when the array contains only non-negative numbers. Since this problem allows negative numbers, Prefix Sum + HashMap is the general solution.

## Key Takeaway

```text
Current Prefix Sum - Previous Prefix Sum = K
```

So, while traversing the array, check whether:

```text
prefixSum - k
```

already exists in the HashMap.
