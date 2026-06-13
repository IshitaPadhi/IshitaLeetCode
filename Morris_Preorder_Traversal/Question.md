# Morris Preorder Traversal

## Problem Statement

Given the root of a binary tree, return the preorder traversal of the binary tree.

Morris Preorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of **O(1)** without using recursion or an external data structure like a stack.

---

## Examples

### Example 1

**Input:**

```text
root = [1, 4, null, 4, 2]
```

**Output:**

```text
[1, 4, 4, 2]
```

---

### Example 2

**Input:**

```text
root = [1]
```

**Output:**

```text
[1]
```

---

## Approach

- Use a pointer `curr` to traverse the tree.
- If `curr.left == null`:
  - Visit the current node.
  - Move to the right child.
- Otherwise:
  - Find the inorder predecessor (rightmost node in the left subtree).
  - If the predecessor's right pointer is `null`:
    - Visit the current node.
    - Create a temporary thread to `curr`.
    - Move to the left child.
  - Else:
    - Remove the thread.
    - Move to the right child.

---

## Algorithm

1. Initialize `curr = root`.
2. While `curr != null`:
   - If `curr.left == null`:
     - Add `curr.data` to the answer.
     - Move to `curr.right`.
   - Else:
     - Find the predecessor.
     - If no thread exists:
       - Visit current node.
       - Create thread.
       - Move left.
     - Otherwise:
       - Remove thread.
       - Move right.
3. Return the answer list.

---

## Time Complexity

```text
O(N)
```

Each edge is traversed at most twice.

---

## Space Complexity

```text
O(1)
```

No recursion or stack is used.

---

## Java Solution

```java
class Solution {
    public List<Integer> getPreorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            }
            else {

                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    ans.add(curr.data);
                    pred.right = curr;
                    curr = curr.left;
                }
                else {
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}
```

---

## Key Observation

```text
Morris Inorder:
Visit when removing the thread.

Morris Preorder:
Visit when creating the thread.
```

This single change converts Morris Inorder Traversal into Morris Preorder Traversal.
