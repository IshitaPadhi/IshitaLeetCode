# Maximum Sum Combination (Brute Force)

## Problem Statement

Given two integer arrays `nums1` and `nums2` and an integer `k`, return the maximum `k` valid sum combinations from all possible sum combinations using the elements of `nums1` and `nums2`.

A valid sum combination is made by adding one element from `nums1` and one element from `nums2`.

Return the answer in **non-increasing order**.

---

## Example 1

**Input:**

```text
nums1 = [7, 3]
nums2 = [1, 6]
k = 2
```

**Output:**

```text
[13, 9]
```

**Explanation:**

The 2 maximum combinations are:

```text
7 + 6 = 13
3 + 6 = 9
```

---

## Example 2

**Input:**

```text
nums1 = [3, 4, 5]
nums2 = [2, 6, 3]
k = 2
```

**Output:**

```text
[11, 10]
```

**Explanation:**

The 2 maximum combinations are:

```text
5 + 6 = 11
4 + 6 = 10
```

---

## Approach: Brute Force + Min Heap

### Intuition

- Generate all possible pair sums.
- Maintain a min heap of size `k`.
- Remove the smallest element whenever the heap size exceeds `k`.
- The heap finally stores the `k` largest sums.
- Reverse the extracted elements to obtain the answer in non-increasing order.

---

## Time Complexity

```text
O(n² log k)
```

---

## Space Complexity

```text
O(k)
```

---

## Note

This brute-force approach may result in **TLE** for large constraints (`n ≤ 10⁵`) because it evaluates all `n²` combinations.

An optimized approach using sorting and a max heap exists.
