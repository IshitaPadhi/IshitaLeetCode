# Longest Substring with At Most K Distinct Characters

## Problem Statement

Given a string `s` and an integer `k`, find the length of the longest substring containing at most `k` distinct characters.

If no valid non-empty substring exists, return `-1`.

## Example

**Input:**
```text
s = "aabacbebebe"
k = 3
```

**Output:**
```text
7
```

**Explanation:**

The longest valid substring is `"cbebebe"`, which has length `7` and contains three distinct characters: `c`, `b`, and `e`.

---

## Approach 1: Brute Force

### Logic
- Fix the starting index `i` of the substring.
- Create a new `HashMap` to store character frequencies.
- Move the ending index `j` from `i` to the end of the string.
- Add each character to the map and update its frequency.
- If the number of distinct characters exceeds `k`, break the inner loop.
- Otherwise, update `maxLen`.

### Java Code

```java
import java.util.*;

class Solution {
    public int kDistinctChar(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen == 0 ? -1 : maxLen;
    }
}
```

### Complexity
- **Time Complexity:** `O(N²)` average
- **Space Complexity:** `O(min(N, C))`

Here, `N` is the string length and `C` is the size of the character set.

---

## Approach 2: Sliding Window Using `while`

### Logic
- Maintain two pointers, `l` and `r`, representing the current window.
- Expand the window by moving `r` forward.
- Store character frequencies in a `HashMap`.
- If the number of distinct characters exceeds `k`, shrink the window by moving `l` forward until it becomes valid.
- Remove a character from the map when its frequency becomes zero.
- Update `maxLen` whenever the window is valid.

### Java Code

```java
import java.util.*;

class Solution {
    public int kDistinctChar(String s, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen == 0 ? -1 : maxLen;
    }
}
```

### Complexity
- **Time Complexity:** `O(N)` average
- **Space Complexity:** `O(min(N, C))`

Each pointer moves forward at most `N` times, so the total number of pointer movements is linear.

---

## Approach 3: Optimized Sliding Window Using `if`

### Logic

This approach replaces the inner `while` loop with an `if` statement.

1. Expand the window by adding `s.charAt(r)` to the map.
2. If the number of distinct characters exceeds `k`, shrink the window by exactly one position.
3. Decrease the frequency of the leftmost character.
4. Remove that character from the map if its frequency becomes zero.
5. Move both pointers forward as needed and track the maximum window length.

**Why replace `while` with `if`?**

The `while` approach repeatedly shrinks the window until it becomes valid. The `if` approach shrinks it only once per iteration.

The window may temporarily contain more than `k` distinct characters. This is acceptable because we are tracking the maximum length, and the left and right pointers each move forward at most `N` times.

### Java Code

```java
import java.util.*;

class Solution {
    public int kDistinctChar(String s, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++;
            }

            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen == 0 ? -1 : maxLen;
    }
}
```

### Complexity
- **Time Complexity:** `O(N)` average
- **Space Complexity:** `O(min(N, C))`

The `if` approach avoids repeatedly shrinking the window within a single iteration. Both sliding-window approaches have linear time complexity.

---

## Comparison of Approaches

| Approach | Technique | Time Complexity | Space Complexity |
|---|---|---|---|
| Brute Force | Nested loops + HashMap | `O(N²)` average | `O(min(N, C))` |
| Sliding Window | Two pointers + inner `while` | `O(N)` average | `O(min(N, C))` |
| Optimized Sliding Window | Two pointers + `if` | `O(N)` average | `O(min(N, C))` |

`N` = length of the string  
`C` = character-set size

## Key Learnings

- `HashMap.size()` gives the number of distinct characters.
- `getOrDefault()` simplifies frequency counting.
- Remove a character from the map when its frequency becomes zero.
- The current window length is `r - l + 1`.
- Nested loops do not automatically imply `O(N²)`; count total pointer movements in sliding-window algorithms.
- Replacing `while` with `if` works here because we only need to track the maximum valid window length, not maintain a valid window after every iteration.

## Related Concept

**Sliding Window + HashMap**

This pattern is useful for problems involving:
- Longest substring without repeating characters
- Longest substring with exactly `K` distinct characters
- Fruit Into Baskets
- Longest substring with at most `K` distinct characters
