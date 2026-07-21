# Get Minimum Value

## Problem Statement

You are given an integer array `data` containing `n` positive integers and an integer `maxOperations`.

You must perform **exactly** `maxOperations` operations.

In one operation:

1. Choose two indices `i` and `j` such that `0 ≤ i < j < data.length`.

2. Compute the absolute difference:

   ```text
   |data[i] - data[j]|
   ```

3. Append this difference to the end of the array.

The objective is to **minimize the smallest element** present in the array after performing all operations.

Return the minimum possible value of the smallest element after exactly `maxOperations` operations.

---

## Examples

### Example 1

```text
Input:
data = [42, 47, 50, 54, 62, 79]
maxOperations = 2

Output:
3
```

Explanation:

```text
Operation 1:
|47 - 62| = 15

Array:
[42,47,50,54,62,79,15]

Operation 2:
|47 - 50| = 3

Array:
[42,47,50,54,62,79,15,3]

Minimum element = 3
```

---

### Example 2

```text
Input:
data = [4,2,5,9,3]
maxOperations = 1

Output:
1
```

Explanation:

```text
|4-3| = 1

Final Array:
[4,2,5,9,3,1]
```

Minimum element = **1**

---

## Approach 1: Brute Force (Backtracking)

### Idea

At every operation:

* Try every possible pair.
* Compute their absolute difference.
* Append the difference.
* Recursively solve the remaining operations.
* Remove the appended value (Backtracking).

Finally, after all operations are completed, compute the minimum element of the current array and update the global answer.

---

## Brute Force Algorithm

1. Convert the input array into an `ArrayList`.
2. Recursively explore every possible sequence of operations.
3. For every pair `(i, j)`:

   * Calculate the absolute difference.
   * Append it to the array.
   * Solve for the remaining operations.
   * Remove the appended value (Backtracking).
4. When no operations are left:

   * Find the minimum element of the current array.
   * Update the global answer.

---

## Time Complexity

```text
O((n²)^k)
```

where:

* `n` = size of the array
* `k` = maxOperations

The solution explores every possible pair at every recursive level, making it exponential.

---

## Space Complexity

```text
O(k)
```

Recursive stack depth (excluding the dynamically growing array).

---

## Notes

* This brute-force approach guarantees the correct answer by exploring every possible sequence of operations.
* However, it is **not feasible** for the given constraints (`n ≤ 2000`, `maxOperations ≤ 10^9`) because the search space grows exponentially.
* An optimized solution requires a deeper mathematical observation about repeated absolute-difference operations rather than straightforward recursion or greedy selection.
