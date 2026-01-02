# Palindrome Number

## Problem Overview

Given an integer `x`, determine whether it is a **palindrome**.

A palindrome number reads the same **forward and backward**.

---

## Examples

**Example 1**

```
Input: x = 121
Output: true
Explanation: 121 reads the same from left to right and right to left.
```

**Example 2**

```
Input: x = -121
Output: false
Explanation: -121 becomes 121- when reversed, which is not the same.
```

**Example 3**

```
Input: x = 10
Output: false
Explanation: Reverses to 01, which is not equal to 10.
```

---

## Constraints

* `-2³¹ ≤ x ≤ 2³¹ - 1`

---

## Applicable Topics

* Math
* Integer manipulation
* Stack
* Recursion

---

## Approaches

### 1. Optimal Approach (Reverse Half of the Number)

#### Explanation

This is the most efficient and **LeetCode-recommended** approach.

Key observations:

* Negative numbers can never be palindromes.
* Any number ending with `0` (except `0` itself) cannot be a palindrome.
* Instead of reversing the whole number, we reverse **only half** and compare.

This avoids integer overflow and extra space.

#### Algorithm

1. Reject negative numbers and numbers ending with 0 (except 0).
2. Reverse digits until the reversed half is greater than or equal to the remaining half.
3. Compare the two halves.

#### Time and Space Complexity

* **Time Complexity:** O(log₁₀ n)
* **Space Complexity:** O(1)

#### Implementation

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int halfReversed = 0;

        while (x > halfReversed) {
            halfReversed = (halfReversed * 10) + (x % 10);
            x /= 10;
        }

        return x == halfReversed || x == halfReversed / 10;
    }
}
```

---

### 2. Full Reverse Integer Approach

#### Explanation

In this approach, the entire number is reversed and compared with the original value.

This method is intuitive but slightly riskier due to **integer overflow** (though safe within given constraints).

#### Time and Space Complexity

* **Time Complexity:** O(log₁₀ n)
* **Space Complexity:** O(1)

#### Implementation

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return original == reversed;
    }
}
```

---

### 3. Stack-Based Approach

#### Explanation

Digits are pushed onto a stack while extracting them from the number. The number is reconstructed by popping from the stack and compared with the original.

This approach is conceptually clean but uses extra memory.

#### Time and Space Complexity

* **Time Complexity:** O(log₁₀ n)
* **Space Complexity:** O(log₁₀ n)

#### Implementation

```java
import java.util.Stack;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        Stack<Integer> stack = new Stack<>();
        int original = x;

        while (x != 0) {
            stack.push(x % 10);
            x /= 10;
        }

        int reversed = 0;
        while (!stack.isEmpty()) {
            reversed = reversed * 10 + stack.pop();
        }

        return original == reversed;
    }
}
```

---

### 4. Recursive Approach

#### Explanation

Recursion is used to reverse the number by passing digits through recursive calls.

This approach is elegant but inefficient due to recursion depth and extra stack space.

#### Time and Space Complexity

* **Time Complexity:** O(log₁₀ n)
* **Space Complexity:** O(log₁₀ n)

#### Implementation

```java
class Solution {
    private int reverse(int x, int rev) {
        if (x == 0) return rev;
        return reverse(x / 10, rev * 10 + x % 10);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == reverse(x, 0);
    }
}
```

---

## Comparison Summary

| Approach     | Time     | Space    | Recommended      |
| ------------ | -------- | -------- | ---------------- |
| Half Reverse | O(log n) | O(1)     | ✅ Best           |
| Full Reverse | O(log n) | O(1)     | ⚠️ Acceptable    |
| Stack        | O(log n) | O(log n) | ❌ Extra space    |
| Recursion    | O(log n) | O(log n) | ❌ Stack overhead |

---

## Conclusion

The **half-reversal approach** is the most optimal and professional solution. It avoids unnecessary memory usage, prevents overflow, and directly addresses the follow-up constraint of not converting the integer to a string.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous problem-solving practice to strengthen algorithmic thinking and Java fundamentals.
