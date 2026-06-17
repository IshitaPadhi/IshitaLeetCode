# Pre, Post and Inorder Traversal in One Traversal

## Problem Statement

Given the root of a binary tree, return the **Inorder**, **Preorder**, and **Postorder** traversals of the tree.

Return the traversals in the following order:

```text
[
    Inorder Traversal,
    Preorder Traversal,
    Postorder Traversal
]
```

---

## Example

### Input

```text
root = [1, 3, 4, 5, 2, 7, 6]
```

### Output

```text
[
    [5, 3, 2, 1, 7, 4, 6],
    [1, 3, 5, 2, 4, 7, 6],
    [5, 2, 3, 7, 6, 4, 1]
]
```

---

## Approach 1: Three Separate Traversals

### Idea

Perform the three traversals independently using recursion:

* **Inorder:** Left → Root → Right
* **Preorder:** Root → Left → Right
* **Postorder:** Left → Right → Root

Store each traversal in a separate list and return all three lists together.

### Complexity Analysis

* **Time Complexity:** `O(3N)` ≈ `O(N)`
* **Space Complexity:** `O(H)`

where `H` is the height of the tree.

---

## Approach 2: Single Stack Traversal

### Intuition

We simulate recursion using a stack and process each node three times using different states.

| State | Traversal |
| ----- | --------- |
| 1     | Preorder  |
| 2     | Inorder   |
| 3     | Postorder |

### State Transitions

```text
State 1:
    Perform preorder operation.
    Push current node with state 2.
    Move to the left child.

State 2:
    Perform inorder operation.
    Push current node with state 3.
    Move to the right child.

State 3:
    Perform postorder operation.
```

### Why Left in State 1?

Preorder follows:

```text
Root → Left → Right
```

After visiting the root, recursion naturally moves to the left subtree.

---

### Why Right in State 2?

Inorder follows:

```text
Left → Root → Right
```

When we reach State 2, the left subtree has already been processed. Therefore, after visiting the root, recursion naturally moves to the right subtree.

---

## Dry Run Logic

```text
State 1 → PRE → push(node, 2) → go LEFT

State 2 → IN → push(node, 3) → go RIGHT

State 3 → POST
```

---

## Java Code (Single Stack Approach)

```java
class Solution {

    class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            ans.add(inorder);
            ans.add(preorder);
            ans.add(postorder);
            return ans;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {

            Pair curr = stack.pop();

            TreeNode node = curr.node;
            int state = curr.state;

            // Preorder
            if (state == 1) {

                preorder.add(node.data);

                stack.push(new Pair(node, 2));

                if (node.left != null) {
                    stack.push(new Pair(node.left, 1));
                }
            }

            // Inorder
            else if (state == 2) {

                inorder.add(node.data);

                stack.push(new Pair(node, 3));

                if (node.right != null) {
                    stack.push(new Pair(node.right, 1));
                }
            }

            // Postorder
            else {

                postorder.add(node.data);
            }
        }

        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);

        return ans;
    }
}
```

---

## Key Takeaway

This approach efficiently generates all three traversals in a **single iteration** over the tree.

Although each node is pushed into the stack three times, the overall complexity remains linear.

### Complexity Analysis

* **Time Complexity:** `O(3N)` ≈ `O(N)`
* **Space Complexity:** `O(N)`

---

## Interview Tip

Remember the sequence:

```text
1 → PRE
2 → IN
3 → POST
```

Think of it as manually simulating recursion:

```java
dfs(node) {

    // State 1
    preorder work;

    dfs(node.left);

    // State 2
    inorder work;

    dfs(node.right);

    // State 3
    postorder work;
}
```

If you understand the recursive flow, the iterative solution becomes easy to derive during interviews.
