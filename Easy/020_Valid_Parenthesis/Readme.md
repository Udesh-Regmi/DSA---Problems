# Valid Parentheses

## Problem Overview

Given a string `s` containing only the characters
`'(' , ')' , '{' , '}' , '[' , ']'`,
determine whether the input string is **valid**.

A string is considered valid if:

1. Open brackets are closed by the **same type** of brackets.
2. Open brackets are closed in the **correct order**.
3. Every closing bracket has a **corresponding opening bracket**.

---

## Examples

### Example 1

```
Input: s = "()"
Output: true
```

### Example 2

```
Input: s = "()[]{}"
Output: true
```

### Example 3

```
Input: s = "(]"
Output: false
```

### Example 4

```
Input: s = "([)]"
Output: false
```

### Example 5

```
Input: s = "{[]}"
Output: true
```

---

## Constraints

* `1 ≤ s.length ≤ 10⁴`
* `s` consists only of `'(){}[]'`

---

## Applicable Topics

* Stack
* String Traversal
* Hashing / Mapping
* LIFO Data Structures
* Validation Logic

---

## Core Idea

This is a **classic stack problem**.

Key observations:

* Opening brackets must be matched **later**, so they need to be stored.
* Closing brackets must match the **most recent unmatched opening bracket**.
* This behavior maps perfectly to a **stack (LIFO)**.

If at any point:

* a closing bracket appears without a matching opening bracket,
* brackets are mismatched, or
* unmatched opening brackets remain at the end,

the string is invalid.

---

## Approach: Stack-Based Validation (Recommended)

### Explanation

1. Initialize an empty stack.
2. Traverse the string character by character.
3. If the character is an **opening bracket**, push it onto the stack.
4. If it is a **closing bracket**:

   * If the stack is empty → invalid.
   * Check whether the top of the stack matches the closing bracket.
   * If it matches, pop the stack.
   * Otherwise, return `false`.
5. After traversal, the stack must be empty for the string to be valid.

---

## Time and Space Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (stack in the worst case)

---

## Implementation

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;

                char top = st.peek();

                if ((top == '(' && ch == ')') ||
                    (top == '{' && ch == '}') ||
                    (top == '[' && ch == ']')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
```

---

## Alternative Approaches (Brief)

### 1. Stack + HashMap

Map closing brackets to their corresponding opening brackets.

* Cleaner condition checks
* Same time and space complexity
* Slightly more readable for larger bracket sets

### 2. Repeated String Replacement (Not Recommended)

Repeatedly remove `"()"`, `"{}"`, and `"[]"` from the string.

* Inefficient
* Poor scalability
* Not interview-friendly

---

## Comparison Summary

| Approach           | Time  | Space | Verdict |
| ------------------ | ----- | ----- | ------- |
| Stack (Used)       | O(n)  | O(n)  | ✅ Best  |
| Stack + Map        | O(n)  | O(n)  | ✅ Clean |
| String Replacement | O(n²) | O(n)  | ❌ Avoid |

---

## Personal Learning Experience

When I first encountered this problem, I tried to solve it by simply looping through each character and checking pairs directly. Very quickly, I realized that this approach broke down as soon as nested brackets were involved. I had no clear way to track which opening bracket should be matched next.

After researching and reviewing similar problems, I learned about using a stack to handle order-sensitive validation. Once I understood that the **most recently opened bracket must be closed first**, the problem became much clearer. The LIFO behavior of a stack fit the problem perfectly.

This problem helped me recognize stack patterns early. Now, whenever I see matching pairs, nesting, and order constraints together, I immediately consider a stack-based solution.

---

## Conclusion

The stack-based approach is the industry-standard solution for validating parentheses. It is simple, efficient, and directly models the real-world behavior of nested structures.

When a problem involves:

* matching pairs,
* nesting, and
* order-sensitive validation,

a stack should be your first instinct.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong data structures and algorithm fundamentals.
