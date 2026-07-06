# Topological Sort using BFS (Kahn's Algorithm)

## Problem Statement

Given a **Directed Acyclic Graph (DAG)** with **V** vertices labeled from **0** to **V - 1**, where the graph is represented using an adjacency list `adj`, find **any valid Topological Ordering** of the graph using **BFS (Kahn's Algorithm)**.

In a topological ordering, for every directed edge **u → v**, vertex **u** must appear **before** vertex **v**.

Return an array representing one valid topological ordering of the graph.

The output will be validated by the driver code. If the returned ordering satisfies all the dependencies of the graph, it will print **True**; otherwise, it will print **False**.

---

## Example 1

**Input**

```text
V = 6
adj = [[], [], [3], [1], [0,1], [0,2]]
```

**Output**

```text
[5, 4, 2, 3, 1, 0]
```

**Explanation**

A graph may have multiple valid topological orderings.

* 5 must appear before 0 and 2
* 2 must appear before 3
* 3 must appear before 1
* 4 must appear before 0 and 1

One valid ordering is:

```text
[5, 4, 2, 3, 1, 0]
```

---

## Example 2

**Input**

```text
V = 4
adj = [[], [0], [0], [0]]
```

**Output**

```text
[3, 2, 1, 0]
```

**Explanation**

The required conditions are:

* 1 must appear before 0
* 2 must appear before 0
* 3 must appear before 0

The relative order among 1, 2, and 3 can vary.

One valid ordering is:

```text
[3, 2, 1, 0]
```

---

## Example 3

**Input**

```text
V = 3
adj = [[1], [2], []]
```

**Output**

```text
[0, 1, 2]
```

---

## Constraints

* `1 ≤ V ≤ 10⁴`
* `0 ≤ Number of Edges ≤ 10⁴`

---

## Approach

Use **Kahn's Algorithm (BFS)**:

1. Compute the indegree of every vertex.
2. Push all vertices with indegree `0` into a queue.
3. Repeatedly:

   * Remove a vertex from the queue.
   * Add it to the answer.
   * Decrease the indegree of all its adjacent vertices.
   * If any adjacent vertex's indegree becomes `0`, push it into the queue.
4. The resulting order is a valid topological ordering.

---

## Time Complexity

* **O(V + E)**

## Space Complexity

* **O(V)**
