# Count Subarrays with Given XOR K

## Problem Statement

Given an array of integers `nums` and an integer `k`, return the **total number of subarrays** whose XOR of elements is equal to `k`.

A subarray is a **contiguous** part of the array.

---

## Example 1

**Input:**

```text
nums = [4, 2, 2, 6, 4]
k = 6
```

**Output:**

```text
4
```

**Explanation:**

The subarrays whose XOR is `6` are:

```text
[4, 2]                  → 4 ^ 2 = 6
[2, 2, 6]               → 2 ^ 2 ^ 6 = 6
[6]                     → 6
[4, 2, 2, 6, 4]         → 4 ^ 2 ^ 2 ^ 6 ^ 4 = 6
```

Therefore, the answer is **4**.

---

## Example 2

**Input:**

```text
nums = [5, 6, 7, 8, 9]
k = 5
```

**Output:**

```text
2
```

**Explanation:**

The subarrays whose XOR is `5` are:

```text
[5]                  → 5
[5, 6, 7, 8, 9]      → 5
```

Therefore, the answer is **2**.

---

## Your Turn

**Input:**

```text
nums = [5, 2, 9]
k = 7
```

**Output:**

```text
2
```

**Explanation:**

```text
[5, 2] → 5 ^ 2 = 7
```

So, the answer is **2**.

---

## Constraints

* `1 <= nums.length <= 10^5`
* `1 <= nums[i] <= 10^9`
* `1 <= k <= 10^9`

---

## Expected Complexity

Try to solve this problem in:

* **Time:** `O(n)`
* **Space:** `O(n)`

---

## Key Idea

Use **Prefix XOR + HashMap**.

If:

```text
currentXOR ^ previousXOR = k
```

Then:

```text
previousXOR = currentXOR ^ k
```

So, while traversing the array, maintain the frequency of previously seen prefix XOR values in a HashMap.
