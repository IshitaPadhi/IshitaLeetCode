# Count Inversions (Merge Sort)

## Problem Statement

Given an integer array `nums`, return the number of **inversions** present in the array.

Two elements `nums[i]` and `nums[j]` form an inversion if:

* `nums[i] > nums[j]`
* `i < j`

A sorted array has **0 inversions**, while a reverse sorted array has the **maximum number of inversions**.

---

## Example

### Example 1

```text
Input:
nums = [2, 3, 7, 1, 3, 5]

Output:
5
```

### Example 2

```text
Input:
nums = [-10, -5, 6, 11, 15, 17]

Output:
0
```

---

# Intuition

A brute force solution checks every pair of elements and counts inversions whenever:

```text
nums[i] > nums[j] and i < j
```

This takes **O(N²)** time, which is too slow for `N = 10⁵`.

To optimize, we use **Merge Sort**.

Since Merge Sort divides the array into sorted halves, during the merge step we can efficiently count inversions.

---

# Key Observation

Suppose during merging:

```text
Left  = [2, 5, 8]
Right = [1, 3, 6]
```

We compare:

```text
2 > 1
```

Since the left half is already sorted,

```text
2 > 1
5 > 1
8 > 1
```

All remaining elements in the left half are also greater than `1`.

Therefore, instead of counting one inversion, we count:

```text
mid - left + 1
```

This counts all inversions in a single step.

---

# Algorithm

1. Divide the array into two halves using Merge Sort.
2. Recursively sort both halves.
3. During merging:

   * If `left <= right`, copy the left element.
   * Otherwise:

     * Copy the right element.
     * Count all remaining elements in the left half as inversions.
4. Merge the sorted halves back.

---

# Dry Run

```text
nums = [9, 5, 4, 2]
```

Inversions:

```text
(9,5)
(9,4)
(9,2)
(5,4)
(5,2)
(4,2)
```

Total inversions = **6**

---

# Java Solution

```java
class Solution {

    static long count = 0;

    public static long inversionCount(int[] nums) {

        count = 0;

        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    static void mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {

                temp[k++] = arr[left++];

            } else {

                temp[k++] = arr[right++];

                count += (mid - left + 1);
            }
        }

        while (left <= mid)
            temp[k++] = arr[left++];

        while (right <= high)
            temp[k++] = arr[right++];

        for (int i = low; i <= high; i++)
            arr[i] = temp[i - low];
    }
}
```

---

# Complexity Analysis

| Complexity | Value          |
| ---------- | -------------- |
| Time       | **O(N log N)** |
| Space      | **O(N)**       |

---

# Key Takeaway

The only extra step compared to a normal Merge Sort is counting inversions when:

```java
arr[left] > arr[right]
```

At that moment, every remaining element from `left` to `mid` is also greater than `arr[right]`, so we add:

```java
count += (mid - left + 1);
```

This allows us to count all inversions efficiently in **O(N log N)** time instead of **O(N²)**.
