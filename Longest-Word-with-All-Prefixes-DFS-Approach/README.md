# Longest Word with All Prefixes (DFS Approach)

## Problem Statement

Given a string array `nums` of length `n`. A string is called a **complete string** if every prefix of this string is also present in the array `nums`.

Find the **longest complete string** in the array `nums`.

- If there are multiple strings with the same length, return the **lexicographically smallest** one.
- If no complete string exists, return `"None"`.

---

## Example 1

### Input

```text
nums = ["n", "ni", "nin", "ninj", "ninja", "nil"]
```

### Output

```text
ninja
```

### Explanation

The word `"ninja"` is the longest word such that all of its prefixes:

```text
n
ni
nin
ninj
ninja
```

are present in the array.

---

## Example 2

### Input

```text
nums = ["ninja", "night", "nil"]
```

### Output

```text
None
```

### Explanation

No string has all of its prefixes present in the array.

---

## Example 3

### Input

```text
nums = ["cat", "car", "cow", "c", "ca", "t", "r", "w"]
```

### Output

```text
car
```

### Explanation

The complete strings are:

```text
car → c, ca, car
cat → c, ca, cat
```

Both have the same length, so the lexicographically smaller string is returned.

---

## Constraints

- `1 <= n <= 10^5`
- `1 <= nums[i].length <= 10^5`
- `1 <= sum(nums[i].length) <= 10^5`
- `nums[i]` consists only of lowercase English letters.

---

## Approach (DFS on Trie)

1. Insert all words into the Trie.
2. Perform DFS starting from the root.
3. Move to a child only if:
   - the child exists, and
   - `endOfWord == true`
4. Use backtracking to construct valid complete strings.
5. Since DFS explores `'a'` to `'z'`, the lexicographically smallest answer is naturally obtained.

---

## Time Complexity

```text
O(Total Characters)
```

where Total Characters = sum of lengths of all strings.

---

## Space Complexity

```text
O(Total Characters)
```

for Trie construction and DFS recursion.
