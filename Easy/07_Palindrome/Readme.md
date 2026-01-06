# Palindrome Number

## Problem Overview

Given an integer `x`, determine whether it is a **palindrome**.

A palindrome number reads the same **forward and backward**.

---

## Examples

### Example 1

```
Input: x = 121
Output: true
```

**Explanation:**
`121` reads the same from left to right and from right to left.

### Example 2

```
Input: x = -121
Output: false
```

**Explanation:**
When reversed, `-121` becomes `121-`, which is not the same as the original number.

### Example 3

```
Input: x = 10
Output: false
```

**Explanation:**
Reversing `10` produces `01`, which is not equal to `10`.

---

## Constraints

* `-2³¹ ≤ x ≤ 2³¹ - 1`

---

## Applicable Topics

* Math
* Integer Manipulation

---

## Approaches

### 1. Optimal Approach (Reverse Half of the Number)

#### Explanation

This is the most efficient and **LeetCode-recommended** approach.

Key observations:

* Negative numbers can never be palindromes.
* Any number ending with `0` (except `0` itself) cannot be a palindrome.
* Instead of reversing the entire number, we reverse **only half** of it and compare the two halves.

This approach avoids unnecessary computation, prevents integer overflow, and uses constant space.

#### Algorithm

1. Reject negative numbers and numbers ending with `0` (except `0`).
2. Reverse digits until the reversed half becomes greater than or equal to the remaining half.
3. Compare the two halves to determine if the number is a palindrome.

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

This approach reverses the entire number and compares it with the original value.

While intuitive and easy to implement, it is slightly less robust due to potential integer overflow (although overflow does not occur within the given constraints).

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

## Comparison Summary

| Approach      | Time     | Space | Recommendation |
| ------------- | -------- | ----- | -------------- |
| Half Reversal | O(log n) | O(1)  | ✅ Preferred    |
| Full Reversal | O(log n) | O(1)  | ⚠️ Acceptable  |

---

## Personal Learning Experience

When I first encountered this problem, my initial instinct was to reverse the entire number and compare it with the original value. This approach worked correctly and helped me understand the core requirement of the problem.

After further research and reviewing optimized solutions, I learned about reversing only half of the number. This idea initially seemed unintuitive, but it quickly became clear that fully reversing the number is unnecessary. By comparing just the two halves, the solution becomes more efficient and avoids potential overflow issues.

This problem reinforced an important lesson for me: a working solution is not always the best solution. With deeper analysis, it is often possible to improve both efficiency and clarity.

---

## Conclusion

The **half-reversal approach** is the most optimal and professional solution to the Palindrome Number problem. It avoids unnecessary memory usage, prevents integer overflow, and directly satisfies the constraint of solving the problem without converting the integer to a string.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous problem-solving practice to strengthen algorithmic thinking and Java fundamentals.
