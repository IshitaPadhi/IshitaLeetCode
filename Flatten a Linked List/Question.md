Flatten a Linked List

📌 Problem Statement

You are given a linked list where each node contains three fields:

val --- stores the value of the node.

next --- points to the next node in the main linked list.

child --- points to another linked list below the current node.

Flatten the given linked list into a single linked list such that:

All the elements from the main list and all child lists are
included.

The elements in the final linked list are arranged in ascending
order.

The final flattened list uses the child pointer to connect
consecutive nodes.

The next pointers of the flattened list are not required.

Example

Given the linked list:

        3 → 2 → 1 → 4 → 5
            ↓   ↓   ↓   ↓
            10  7   9   6
                ↓       ↓
                11      8

All the elements are:

3, 2, 1, 4, 5, 10, 7, 9, 6, 11, 8

After flattening and sorting:

1
↓
2
↓
3
↓
4
↓
5
↓
6
↓
7
↓
8
↓
9
↓
10
↓
11

Here, the child pointer is used to connect the nodes.

💡 Approach

We can solve this problem in 3 simple steps.

1. Traverse the entire linked list

Use:

temp = temp.next;

to move through the main horizontal list.

For every main node, use another pointer:

t2 = t2.child;

to traverse its child list.

Store every value in an ArrayList.

2. Sort the ArrayList

Use:

Collections.sort(arr);

This arranges all values in ascending order.

3. Convert the sorted ArrayList back to a linked list

Create nodes using the sorted values and connect them using the child
pointer:

temp.child = newNode;

🧠 Important Pointer Concept

There are two different traversals:

temp → main linked list
        uses next

t2   → child linked list
        uses child

So remember:

temp = temp.next;    // → Main list

t2 = t2.child;       // ↓ Child list

💻 Java Solution

import java.util.*;

class Solution {

    // Converts sorted ArrayList into a linked list
    // using child pointers
    static ListNode convert(ArrayList<Integer> arr) {

        int n = arr.size();

        // Agar ArrayList empty hai
        if(n == 0) {
            return null;
        }

        // First element ko head bana do
        ListNode head = new ListNode(arr.get(0));

        // Current node
        ListNode temp = head;

        // Remaining elements ke nodes banao
        for(int i = 1; i < n; i++) {

            ListNode newNode = new ListNode(arr.get(i));

            // Current node ke child mein new node lagao
            temp.child = newNode;

            // temp ko next child node par move karo
            temp = temp.child;
        }

        return head;
    }


    // Flattens the complete linked list
    public ListNode flattenLinkedList(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();

        // Main linked list traverse karne ke liye
        ListNode temp = head;

        // Main list ke har node ko visit karo
        while(temp != null) {

            // Current node ki child list traverse karne ke liye
            ListNode t2 = temp;

            // Child list ke saare elements store karo
            while(t2 != null) {

                arr.add(t2.val);

                // Child list mein neeche jao
                t2 = t2.child;
            }

            // Main list mein next node par jao
            temp = temp.next;
        }

        // Saare elements ko ascending order mein sort karo
        Collections.sort(arr);

        // Sorted ArrayList ko linked list mein convert karo
        head = convert(arr);

        return head;
    }
}

🔍 Dry Run --- One Iteration

Suppose:

        3 → 2 → 1 → 4
            ↓   ↓   ↓
            10  7   9
                ↓
                11

Initially:

ArrayList<Integer> arr = new ArrayList<>();
ListNode temp = head;

So:

temp → 3
arr = []

First outer iteration:

ListNode t2 = temp;

Now:

t2 → 3

Then:

arr.add(t2.val);

So:

arr = [3]

Then:

t2 = t2.child;

Since 3.child = null:

t2 = null

Inner loop ends.

Now we move through the main list:

temp = temp.next;

So:

3 → 2
    ↑
   temp

For node 2:

t2 → 2

Add 2:

arr = [3, 2]

Move through child:

t2 = t2.child

Now:

t2 → 10

Add 10:

arr = [3, 2, 10]

Then 10.child = null, so:

t2 = null

Again:

temp = temp.next;

moves to node 1.

The same process continues for all nodes.

Finally:

arr = [3, 2, 10, 1, 7, 11, 4, 9, 5, 6, 8]

After sorting:

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Then convert(arr) creates:

1
↓
2
↓
3
↓
4
↓
5
↓
6
↓
7
↓
8
↓
9
↓
10
↓
11

⏱️ Complexity Analysis

Let N be the total number of nodes in the complete linked structure.

Time Complexity

Traversal  → O(N)
Sorting    → O(N log N)
Conversion → O(N)

Total      → O(N log N)

Space Complexity

ArrayList → O(N)
New list  → O(N)

Total     → O(N)

📝 Key Takeaways

next → main horizontal list

child → downward/child list

Store all values in an ArrayList.

Sort using Collections.sort().

Rebuild the flattened list using child.

Final answer is a sorted linked list connected through child
pointers.

Quick Memory Trick

MAIN LIST  → next
CHILD LIST → child

Collect → Sort → Convert
