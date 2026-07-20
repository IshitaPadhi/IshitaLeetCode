# Alternating Parity Permutations

## Problem Statement

Given an integer `n`, generate **all permutations** of the numbers from `1` to `n` such that every pair of adjacent numbers has **alternating parity** (one odd, one even).

The permutations should be returned in **lexicographical order**.

### Example

**Input**

```text
n = 4
```

**Output**

```text
[
  [1,2,3,4],
  [1,4,3,2],
  [2,1,4,3],
  [2,3,4,1],
  [3,2,1,4],
  [3,4,1,2],
  [4,1,2,3],
  [4,3,2,1]
]
```

---

# Approaches

## 1. Brute Force

### Idea

* Generate all possible permutations of numbers `1` to `n`.
* For every permutation, check whether every adjacent pair has opposite parity.
* If valid, store the permutation.

### Algorithm

1. Generate all permutations using Backtracking.
2. After a permutation is complete, validate it.
3. If adjacent elements have alternating parity, add it to the answer.

### Time Complexity

```text
O(n! × n)
```

### Space Complexity

```text
O(n)
```

---

## 2. Optimized Backtracking

### Idea

Instead of generating every permutation and checking later, verify the parity condition **while building the permutation**.

* If the last chosen number is odd, the next must be even.
* If the last chosen number is even, the next must be odd.

This avoids exploring invalid branches.

### Algorithm

1. Start building the permutation.
2. For the first position, any number can be chosen.
3. For every next position, only choose numbers with opposite parity.
4. Continue until the permutation is complete.

### Time Complexity

```text
O(Valid Permutations × n)
```

This is significantly faster than brute force because invalid permutations are never generated.

### Space Complexity

```text
O(n)
```

---

# Concepts Used

* Backtracking
* Recursion
* Permutations
* Parity (Odd & Even)
* Lexicographical Ordering
* Pruning

---

# Learning Outcome

This problem demonstrates how backtracking can be optimized by pruning invalid choices early. Instead of generating all permutations and filtering them afterward, applying constraints during recursion greatly reduces the search space.

---

# Language

Java

---

# Repository Structure

```text
Alternating-Parity-Permutations/
│── BruteForce.java
│── Optimized.java
└── README.md
```
