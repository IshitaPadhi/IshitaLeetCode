# Find Missing and Repeating Number

## Problem Statement

You are given an array `nums` of size `n` containing numbers from `1` to `n`.

- Exactly **one number is missing**.
- Exactly **one number appears twice**.

Return the repeating number and the missing number in the format:

```text
[repeating, missing]
```

### Example

**Input:**
```text
nums = [1, 2, 2, 4]
```

**Output:**
```text
[2, 3]
```

---

## Approach

This solution uses a **Mathematical Equations** approach.

Let:

- `x` = Repeating number
- `y` = Missing number

### Step 1: Form the first equation

Expected Sum:

```text
SN = n(n + 1) / 2
```

Actual Sum:

```text
S
```

Since one number repeats and one is missing,

```text
S - SN = x - y
```

Let,

```text
val1 = x - y
```

---

### Step 2: Form the second equation

Expected Sum of Squares:

```text
S2N = n(n + 1)(2n + 1) / 6
```

Actual Sum of Squares:

```text
S2
```

Therefore,

```text
S2 - S2N = x² - y²
```

Using,

```text
x² - y² = (x - y)(x + y)
```

we get,

```text
x + y = (S2 - S2N) / (S - SN)
```

Let,

```text
val2 = x + y
```

---

### Step 3: Solve the equations

Now,

```text
x - y = val1
x + y = val2
```

Adding both equations,

```text
2x = val1 + val2

x = (val1 + val2) / 2
```

Then,

```text
y = x - val1
```

---

## Java Solution

```java
class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int[] ans = new int[2];

        long n = nums.length;

        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0;
        long S2 = 0;

        for (int num : nums) {
            S += num;
            S2 += (long) num * num;
        }

        long val1 = S - SN;        // x - y
        long val2 = S2 - S2N;      // x² - y²

        val2 = val2 / val1;        // x + y

        long x = (val1 + val2) / 2;
        long y = x - val1;

        ans[0] = (int) x;
        ans[1] = (int) y;

        return ans;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Key Learning

- Convert the problem into **two mathematical equations**.
- Use:
  - Sum of first `n` natural numbers.
  - Sum of squares of first `n` natural numbers.
- Solve the equations to obtain the repeating and missing numbers in constant extra space.

---

## Tags

`Arrays` `Math` `Striver SDE Sheet` `O(1) Space` `Interview Question`
