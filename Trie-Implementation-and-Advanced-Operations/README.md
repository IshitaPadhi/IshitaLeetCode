# Trie Implementation and Advanced Operations

## Problem Statement

Implement a **Trie** data structure from scratch with the following functions:

- `Trie()` : Initialize the Trie object.
- `insert(String word)` : Insert the string `word` into the Trie.
- `countWordsEqualTo(String word)` : Return the number of times `word` is present in the Trie.
- `countWordsStartingWith(String prefix)` : Return the number of words in the Trie that have `prefix` as a prefix.
- `erase(String word)` : Delete one occurrence of `word` from the Trie.

---

## Example 1

### Input

```text
["Trie", "insert", "countWordsEqualTo", "insert",
 "countWordsStartingWith", "erase", "countWordsStartingWith"]

[[], ["apple"], ["apple"], ["app"],
 ["app"], ["apple"], ["app"]]
```

### Output

```text
[null, null, 1, null, 2, null, 1]
```

### Explanation

```text
Trie trie = new Trie();

trie.insert("apple");

trie.countWordsEqualTo("apple");      // returns 1

trie.insert("app");

trie.countWordsStartingWith("app");   // returns 2

trie.erase("apple");

trie.countWordsStartingWith("app");   // returns 1
```

---

## Example 2

### Input

```text
["Trie", "insert", "countWordsEqualTo",
 "insert", "erase", "countWordsStartingWith"]

[[], ["mango"], ["apple"],
 ["app"], ["app"], ["mango"]]
```

### Output

```text
[null, null, 0, null, null, 1]
```

### Explanation

```text
Trie trie = new Trie();

trie.insert("mango");

trie.countWordsEqualTo("apple");      // returns 0

trie.insert("app");

trie.erase("app");

trie.countWordsStartingWith("mango"); // returns 1
```

---

## Constraints

- `1 <= word.length(), prefix.length() <= 2000`
- `word` and `prefix` consist only of lowercase English letters.
- At most `3 × 10^4` calls will be made to:
  - `insert`
  - `countWordsEqualTo`
  - `countWordsStartingWith`
  - `erase`

---

## Approach

> *Solution to be added.*

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert | O(L) |
| Count Words Equal To | O(L) |
| Count Words Starting With | O(L) |
| Erase | O(L) |

Where **L** is the length of the word.

---

## Space Complexity

```text
O(N × 26)
```

where **N** is the total number of Trie nodes created.
