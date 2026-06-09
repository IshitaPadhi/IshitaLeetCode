# Longest Word with All Prefixes (Prefix Check Approach)

## Problem Statement

Given a string array `nums` of length `n`. A string is called a **complete string** if every prefix of this string is also present in the array `nums`.

Find the **longest complete string** in the array `nums`.

- If there are multiple strings with the same length, return the **lexicographically smallest** one.
- If no such string exists, return `"None"`.

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

The word `"ninja"` is complete because all its prefixes exist:

```text
n
ni
nin
ninj
ninja
```

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

No string has all its prefixes present in the array.

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

Complete strings are:

```text
cat → c, ca, cat
car → c, ca, car
```

Both have the same length, so the lexicographically smaller string is returned.

---

## Constraints

- `1 <= n <= 10^5`
- `1 <= nums[i].length <= 10^5`
- `1 <= sum(nums[i].length) <= 10^5`
- `nums[i]` consists only of lowercase English characters.

---

## Approach (Trie + Prefix Validation)

1. Insert all words into the Trie.
2. For every word in the array:
   - Traverse the Trie character by character.
   - Ensure that every prefix node has `endOfWord == true`.
3. If all prefixes exist:
   - Update the answer if the current word is longer.
   - If lengths are equal, choose the lexicographically smaller word.
4. Return `"None"` if no complete string exists.

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

for Trie construction.
