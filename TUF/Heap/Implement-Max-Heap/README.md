🏔️ Max Heap Implementation
Problem Statement
Implement a Max Heap data structure supporting the following operations:
MethodDescriptioninitializeHeapInitialize the heap to an empty stateinsert(x)Insert value x into the max heapgetMaxReturn the maximum value (root) without removing itextractMaxRemove and return the maximum elementheapSizeReturn the current number of elements in the heapisEmptyReturn 0 (false) or 1 (true) depending on whether heap is emptychangeKey(ind, val)Update the element at 0-based index ind to val, then re-heapify

⚠️ Important: When extracting the max, if both left and right children are equal, swap with the LEFT child.


Examples
Example 1
Input:
operations = ["initializeHeap", "insert", "insert", "insert", "getMax", "heapSize", "isEmpty", "extractMax", "changeKey", "getMax"]
nums       = [[4], [1], [10], [0, 16]]
Output:
[null, null, null, null, 10, 3, 0, null, null, 16]
Step-by-step trace:
StepOperationHeap StateOutput1initializeHeap[]null2insert(4)[4]null3insert(1)[4, 1]null4insert(10)[10, 1, 4]null5getMax[10, 1, 4]106heapSize[10, 1, 4]37isEmpty[10, 1, 4]08extractMax[4, 1]null9changeKey(0, 16)[16, 1]null10getMax[16, 1]16

Example 2
Input:
operations = ["initializeHeap", "insert", "insert", "extractMax", "getMax", "insert", "heapSize", "isEmpty", "extractMax", "changeKey", "getMax"]
nums       = [[4], [1], [4], [0, 2]]
Output:
[null, null, null, null, 1, null, 2, 0, null, null, 2]
