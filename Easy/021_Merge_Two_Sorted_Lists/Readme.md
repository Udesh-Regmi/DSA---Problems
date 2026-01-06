# Merge Two Sorted Lists

## Problem Overview

You are given the heads of two **sorted linked lists** `list1` and `list2`.

Merge the two lists into **one sorted linked list** and return the head of the merged list.

The merged list should be made by **splicing together the nodes** of the first two lists, not by creating new nodes.

---

## Examples

**Example 1**
```

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

```

**Example 2**
```

Input: list1 = [], list2 = []
Output: []

```

**Example 3**
```

Input: list1 = [], list2 = [0]
Output: [0]

````

---

## Constraints

* The number of nodes in both lists is in the range `[0, 50]`
* `-100 ≤ Node.val ≤ 100`
* Both `list1` and `list2` are sorted in **non-decreasing order**

---

## Applicable Topics

* Linked List
* Recursion
* Two Pointers
* Divide & Conquer
* Data Structure Traversal

---

## Core Idea to Solve This Problem

This problem is about **ordered merging**, not random insertion.

Key observations:

* Both lists are already sorted.
* At every step, the **smaller head node** must be chosen.
* After choosing a node, the same logic applies to the **remaining lists**.

This recursive structure makes the problem ideal for a **recursive solution**.

---

## Step-by-Step Thinking (How to Reach the Solution)

### Step 1: Understand the Base Cases

If either list is empty:
* Return the other list.
* There is nothing to merge.

These conditions stop the recursion.

```java
if (list1 == null) return list2;
if (list2 == null) return list1;
````

---

### Step 2: Compare Current Nodes

Compare the values at the heads:

* If `list1.val <= list2.val`

  * `list1` should come first
* Else

  * `list2` should come first

This mirrors how you would merge two sorted arrays.

---

### Step 3: Recursive Reduction

Once a node is chosen:

* Set its `next` to the result of merging the **rest of the lists**
* Reduce the problem size by one node

This is the key recursion idea:

> “Solve the smaller problem and attach the result.”

---

### Step 4: Return the Chosen Node

Each recursive call returns a sorted list.
The recursion builds the final list from **smallest to largest**.

---

## Recursive Implementation (Used Approach)

```java
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
```

---

## Visualization of Recursion

For:

```
list1 = [1,2,4]
list2 = [1,3,4]
```

Steps:

```
1 <= 1 → pick list1(1)
  merge [2,4] with [1,3,4]

1 < 2 → pick list2(1)
  merge [2,4] with [3,4]

2 < 3 → pick list1(2)
  merge [4] with [3,4]
...
```

Each call reduces the problem until a list becomes null.

---

## Time and Space Complexity

* **Time Complexity:** `O(n + m)`

  * Each node is visited exactly once
* **Space Complexity:** `O(n + m)`

  * Due to recursive call stack

---

## Alternative Approach: Iterative (Two Pointers)

### Idea

* Use a dummy node.
* Compare pointers iteratively.
* Attach smaller nodes step by step.

### Tradeoff

| Approach  | Space | Readability     | Risk                          |
| --------- | ----- | --------------- | ----------------------------- |
| Recursive | O(n)  | Very clean      | Stack overflow for huge lists |
| Iterative | O(1)  | Slightly longer | Safer                         |

---

## Comparison Summary

| Approach  | Time   | Space  | Verdict      |
| --------- | ------ | ------ | ------------ |
| Recursive | O(n+m) | O(n+m) | ✅ Elegant    |
| Iterative | O(n+m) | O(1)   | ✅ Production |

---

## How to Approach Similar Linked List Problems

1. Identify **base cases** first.
2. Ask: can this be broken into a **smaller subproblem**?
3. If the structure repeats → recursion is likely valid.
4. If memory matters → consider iterative.

This logic applies to:

* Merging lists
* Reversing lists
* Removing nodes
* Sorting linked lists

---

## Real-World Use Cases

* **Merge operations** in databases
* **Sorted stream processing**
* **Task scheduling systems**
* **Version control diff algorithms**
* **Event timeline merging**

Any system combining sorted data streams uses this idea.

---


## Personal Learning Experience 

When I first encountered this problem, my instinct was to **loop through both lists manually** and compare values step by step, similar to merging two sorted arrays. I understood *what* needed to happen, but managing pointers without breaking the list felt messy at first.

My early attempts failed for predictable reasons:

* I lost track of the head of the merged list.
* I moved pointers incorrectly and skipped nodes.
* I tried to “build” the list without a clear anchor point.

The breakthrough was learning to use a **dummy node**.

Once I introduced a dummy node:

* I stopped worrying about initializing the head.
* Pointer movement became mechanical and predictable.
* Each comparison felt intentional instead of fragile.

The loop-based approach taught me an important linked list lesson:

> Most linked list bugs come from **poor pointer management**, not logic errors.

By maintaining:

* one pointer for traversal,
* and two pointers for the input lists,

the solution became straightforward and safe. This approach also made me more comfortable with **in-place list manipulation**, which shows up repeatedly in linked list problems.

After understanding the iterative solution, the recursive version made more sense conceptually. But the loop-based approach felt more **production-ready**, especially when thinking about stack limits and real-world constraints.

This problem helped me shift from “trying things until it works” to **designing pointer flow before coding**, which significantly reduced mistakes in later linked list problems.



## Conclusion

The recursive approach mirrors how humans naturally think about merging sorted lists:
pick the smaller value, then repeat.

It is clean, readable, and perfect for interviews and learning recursion.
Once this clicks, many linked list problems stop being scary and start being mechanical.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong DSA fundamentals.

