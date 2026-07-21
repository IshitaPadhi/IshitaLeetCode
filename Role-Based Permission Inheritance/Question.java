# Role-Based Permission Inheritance

## Problem Statement

A role may inherit permissions from **one parent role**.

Each role contains:

* **Allow List** → Permissions that are explicitly allowed.
* **Deny List** → Permissions that are explicitly denied.

A child role inherits decisions from its parent hierarchy. However, the **nearest explicit decision always overrides** any decision from ancestors.

Given a role and a permission, determine whether the permission is granted.

---

## Rules

Starting from the given role:

1. If the current role explicitly **denies** the permission, return **false**.
2. If the current role explicitly **allows** the permission, return **true**.
3. Otherwise, move to its parent role.
4. If no role in the hierarchy mentions the permission, return **false**.

---

## Example 1

```text
roles = ["employee","engineer","intern"]

parents = ["","employee","engineer"]

allowLists = [
    ["read"],
    ["deploy"],
    []
]

denyLists = [
    [],
    [],
    ["deploy"]
]

role = "intern"
permission = "deploy"

Output:
false
```

### Explanation

```text
Intern
│
├── Deny : deploy   ✅

Return false
```

The intern's explicit deny overrides the engineer's inherited allow.

---

## Example 2

```text
roles = ["employee","engineer","intern"]

parents = ["","employee","engineer"]

allowLists = [
    ["read"],
    ["deploy"],
    []
]

denyLists = [
    [],
    [],
    ["deploy"]
]

role = "intern"
permission = "read"

Output:
true
```

### Explanation

```text
Intern
│
├── No decision
│
▼
Engineer
│
├── No decision
│
▼
Employee
│
├── Allow : read ✅

Return true
```

Since neither Intern nor Engineer mentions the permission, it is inherited from Employee.

---

# Approach

Starting from the given role:

* Find the current role's index.
* Check its **Deny List**.

  * If the permission exists, return `false`.
* Check its **Allow List**.

  * If the permission exists, return `true`.
* If the permission is not found, move to the parent role.
* Repeat until reaching the root.
* If no role contains the permission, return `false`.

---

# Algorithm

1. Start from the given role.
2. Find its index in the `roles` array.
3. Check the deny list.
4. Check the allow list.
5. Move to the parent role.
6. Repeat until the root role is reached.
7. If permission is never found, return `false`.

---

# Time Complexity

Let:

* `n` = Number of roles
* `m` = Average number of permissions in a role

**Time Complexity**

```text
O(height × (n + m))
```

where `height` is the number of ancestors from the given role to the root.

---

# Space Complexity

```text
O(1)
```

Only a few extra variables are used.

---

# Key Observation

The most important rule is:

```text
Nearest Explicit Decision Wins
```

Priority order:

```text
Current Role
      │
      ▼
Check Deny
      │
      ├── Found → false
      │
      ▼
Check Allow
      │
      ├── Found → true
      │
      ▼
Move to Parent
      │
      ▼
Repeat
```

If no role explicitly mentions the permission, the final answer is **false**.
