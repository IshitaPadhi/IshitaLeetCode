# Pascal's Triangle I - Find Element at (r, c)

## Problem Statement

Given two integers **r** and **c**, return the value present at the **rth row** and **cth column** (1-indexed) of **Pascal's Triangle**.

In Pascal's Triangle:

* The first row contains a single element **1**.
* Each row has one more element than the previous row.
* Every row starts and ends with **1**.
* Every interior element is the sum of the two elements directly above it.

[
Pascal[r][c] = Pascal[r-1][c-1] + Pascal[r-1][c]
]

---

## Example

### Example 1

**Input**

```
r = 4, c = 2
```

**Output**

```
3
```

**Explanation**

```
        1
      1   1
    1   2   1
  1   3   3   1
```

The element at **row 4, column 2** is **3**.

---

### Example 2

**Input**

```
r = 5, c = 3
```

**Output**

```
6
```

**Explanation**

```
          1
        1   1
      1   2   1
    1   3   3   1
  1   4   6   4   1
```

The element at **row 5, column 3** is **6**.

---

## Approach

Instead of constructing the entire Pascal's Triangle, directly compute the required element using the **Combination (nCr)** formula.

For the element at:

* Row = `r`
* Column = `c`

The value is:

```
C(r - 1, c - 1)
```

where

```
C(n, k) = n! / (k! * (n-k)!)
```

To avoid factorial computations and overflow, compute the combination iteratively:

```
result = result * (n - i) / (i + 1)
```

This gives the answer in linear time.

---

## Algorithm

1. Convert to zero-based indexing:

   * `n = r - 1`
   * `k = c - 1`
2. Initialize `result = 1`.
3. Iterate from `0` to `k - 1`:

   * Multiply by `(n - i)`
   * Divide by `(i + 1)`
4. Return `result`.

---

## Complexity Analysis

* **Time Complexity:** `O(c)`
* **Space Complexity:** `O(1)`

---

## Key Concept

The element at the **rth row** and **cth column** of Pascal's Triangle is simply:

```
C(r - 1, c - 1)
```

This mathematical approach is much more efficient than generating the entire triangle.
