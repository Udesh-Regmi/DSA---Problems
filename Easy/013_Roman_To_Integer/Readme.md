# Roman to Integer

## Problem Overview

Roman numerals are represented by seven symbols, each with a fixed integer value:

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Given a valid Roman numeral string `s`, convert it into its corresponding integer value.

Roman numerals are usually written from **largest to smallest**, left to right. However, **subtractive notation** is used in six specific cases:

* `I` before `V` or `X` → 4, 9
* `X` before `L` or `C` → 40, 90
* `C` before `D` or `M` → 400, 900

---

## Examples

**Example 1**

```
Input: s = "III"
Output: 3
```

**Example 2**

```
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V = 5, III = 3
```

**Example 3**

```
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90, IV = 4
```

---

## Constraints

* `1 ≤ s.length ≤ 15`
* `s` contains only `I, V, X, L, C, D, M`
* `s` is guaranteed to be valid and in the range `[1, 3999]`

---

## Applicable Topics

* Hash Table
* String Traversal
* Greedy Strategy
* Math
---

## Core Idea to Solve This Problem

This problem is not about memorization of Roman numerals. It is about **pattern recognition**.

Key observation:

* If a **smaller value appears before a larger value**, it should be **subtracted**.
* Otherwise, values are simply **added**.

Once this rule is understood, multiple traversal strategies become possible.

---

## Approaches

### 1. Right-to-Left Traversal (Best & Most Reliable)

#### Explanation

This is the most robust and interview-preferred approach.

By traversing the string from **right to left**, we can compare the current value with the previous value:

* If the current value is smaller than the previous one, subtract it.
* Otherwise, add it.

This avoids complex lookahead logic and handles all subtractive cases naturally.

#### Time and Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

#### Implementation

```java
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = map.get(s.charAt(i));

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }
}
```

---

### 2. Left-to-Right Traversal

#### Explanation

In this approach, we traverse from left to right and **compare the current value with the next value**.

* If the current value is smaller than the next one, subtract it.
* Otherwise, add it.

This approach is intuitive but requires careful boundary handling.

#### Time and Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

#### Implementation

```java
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;

            if (current < next) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }
}
```

---

### 3. Explicit Subtractive Pair Handling

#### Explanation

This approach checks for specific subtractive pairs like `IV`, `IX`, `XL`, etc., and skips characters accordingly.

While valid, it is verbose and error-prone.

#### Why It Matters

* Demonstrates pattern matching
* Helps beginners understand Roman numeral rules

However, it does not scale well and is not recommended for interviews.

---

### 4. String Replacement Approach (Not Recommended)

#### Explanation

Replace subtractive patterns (e.g., `IV` → `4`) and then sum remaining characters.

#### Why It Matters

* Shows creativity
* Poor performance and readability

This approach is generally discouraged in professional environments.

---

## Comparison Summary

| Approach       | Time  | Space | Verdict      |
| -------------- | ----- | ----- | ------------ |
| Right-to-Left  | O(n)  | O(1)  | ✅ Best       |
| Left-to-Right  | O(n)  | O(1)  | ✅ Acceptable |
| Explicit Pairs | O(n)  | O(1)  | ⚠️ Verbose   |
| String Replace | O(n²) | O(1)  | ❌ Avoid      |

---

## How to Tackle Similar Problems

1. Identify **ordering rules** (greater vs smaller value).
2. Look for **patterns instead of hardcoding cases**.
3. Prefer **single-pass solutions**.
4. Avoid unnecessary data structures when simple comparisons work.

This mindset applies to many problems involving:

* Encoded strings
* Symbol-value mappings
* Greedy decisions

---

## Conclusion

The **right-to-left traversal approach** is the cleanest, safest, and most professional solution. It naturally handles all Roman numeral rules without special cases and should be your default choice.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong DSA fundamentals.
