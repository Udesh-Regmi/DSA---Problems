# Valid Parentheses

## Problem Overview

Given a string `s` containing only the characters  
`'(' , ')' , '{' , '}' , '[' , ']'`,  
determine if the input string is **valid**.

A string is considered valid if:

1. Open brackets are closed by the **same type** of brackets.
2. Open brackets are closed in the **correct order**.
3. Every closing bracket has a **corresponding opening bracket**.

---

## Examples

**Example 1**
```

Input: s = "()"
Output: true

```

**Example 2**
```

Input: s = "()[]{}"
Output: true

```

**Example 3**
```

Input: s = "(]"
Output: false

```

**Example 4**
```

Input: s = "([)]"
Output: false

```

**Example 5**
```

Input: s = "{[]}"
Output: true

````

---

## Constraints

* `1 ≤ s.length ≤ 10⁴`
* `s` consists of only `'(){}[]'`

---

## Applicable Topics

* Stack
* String Traversal
* Hashing / Mapping
* LIFO Data Structures
* Validation Logic

---

## Core Idea to Solve This Problem

This is a **classic stack problem**.

Key observations:

* Opening brackets must be **matched later**, so they need to be stored.
* Closing brackets must match the **most recent unmatched opening bracket**.
* This behavior is exactly what a **stack (LIFO)** provides.

If at any point:
* a closing bracket appears without a matching opening one, or
* brackets are mismatched, or
* some opening brackets remain unmatched at the end,

the string is invalid.

---

## Approach: Stack-Based Validation (Recommended)

### Explanation

1. Initialize an empty stack.
2. Traverse the string character by character.
3. If the character is an **opening bracket**, push it onto the stack.
4. If it is a **closing bracket**:
   * If the stack is empty → invalid.
   * Check if the top of the stack matches the closing bracket.
   * If it matches, pop the stack.
   * Otherwise, return false.
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
````

---

## Alternative Approaches (Brief)

### 1. Stack + HashMap

Map closing brackets to their opening counterparts.

* Cleaner condition checks
* Same time and space complexity
* Slightly more readable for larger bracket sets

### 2. Replace Pairs Repeatedly (Not Recommended)

Repeatedly remove `"()"`, `"{}"`, `"[]"` from the string.

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

## How to Approach Similar Problems

1. Identify **pairing rules**.
2. Check if order matters → if yes, think **stack**.
3. Validate as early as possible to fail fast.
4. Always verify leftover state at the end.

This applies to problems involving:

* Expression parsing
* Syntax validation
* Compiler design basics
* Nested structure checks

---

## Real-World Use Cases

* **Code editors:** syntax checking
* **Compilers & interpreters:** parsing expressions
* **Math expression evaluators**
* **Configuration file validation**
* **Template engines (HTML, JSX, XML)**

Anywhere nested structures must open and close correctly, this logic appears.

---

## Conclusion

The stack-based approach is the industry-standard solution.
It is simple, efficient, and maps directly to the real-world behavior of nested structures.

If you see:

* matching pairs
* nesting
* order-sensitive validation

your brain should immediately say: **use a stack**.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong DSA fundamentals.

