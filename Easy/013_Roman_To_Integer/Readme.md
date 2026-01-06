# Roman to Integer

## Problem Overview

Roman numerals are represented using seven symbols, each associated with a fixed integer value:

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

Roman numerals are typically written from **largest to smallest**, left to right. However, **subtractive notation** is used in six specific cases:

* `I` before `V` or `X` → 4, 9
* `X` before `L` or `C` → 40, 90
* `C` before `D` or `M` → 400, 900

---

## Examples

### Example 1

```
Input: s = "III"
Output: 3
```

### Example 2

```
Input: s = "LVIII"
Output: 58
```

**Explanation:**
`L = 50`, `V = 5`, `III = 3`

### Example 3

```
Input: s = "MCMXCIV"
Output: 1994
```

**Explanation:**
`M = 1000`, `CM = 900`, `XC = 90`, `IV = 4`

---

## Constraints

* `1 ≤ s.length ≤ 15`
* `s` contains only `I, V, X, L, C, D, M`
* `s` is guaranteed to be valid and within the range `[1, 3999]`

---

## Applicable Topics

* Hash Table
* String Traversal
* Greedy Strategy
* Math

---

## Core Idea

This problem is not about memorizing Roman numerals. It is fundamentally about **pattern recognition**.

Key observation:

* If a **smaller value appears before a larger value**, it should be **subtracted**.
* Otherwise, values are **added** normally.

Once this rule is understood, multiple traversal strategies become possible.

---

## Approaches

### 1. Right-to-Left Traversal (Recommended)

#### Explanation

This is the most robust and interview-preferred approach.

By traversing the string from **right to left**, each character can be compared with the previously processed value:

* If the current value is smaller than the previous value, subtract it.
* Otherwise, add it.

This strategy naturally handles all subtractive cases without requiring special logic or lookahead checks.

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

This approach traverses the string from left to right and compares the current value with the next value:

* If the current value is smaller than the next value, subtract it.
* Otherwise, add it.

While intuitive, this method requires careful boundary handling and is slightly more error-prone than right-to-left traversal.

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

This approach explicitly checks for subtractive pairs such as `IV`, `IX`, `XL`, and similar combinations.

While it works correctly, it is verbose, harder to maintain, and prone to edge-case errors.

---

### 4. String Replacement Approach (Not Recommended)

#### Explanation

This method replaces subtractive patterns (e.g., `IV` → `4`) and then sums the remaining characters.

Although creative, this approach results in poor readability and unnecessary complexity, making it unsuitable for professional or interview settings.

---

## Comparison Summary

| Approach       | Time  | Space | Verdict      |
| -------------- | ----- | ----- | ------------ |
| Right-to-Left  | O(n)  | O(1)  | ✅ Best       |
| Left-to-Right  | O(n)  | O(1)  | ✅ Acceptable |
| Explicit Pairs | O(n)  | O(1)  | ⚠️ Verbose   |
| String Replace | O(n²) | O(1)  | ❌ Avoid      |

---

## How to Approach Similar Problems

1. Identify **ordering rules** (smaller vs larger values).
2. Focus on **patterns rather than hardcoded cases**.
3. Prefer **single-pass solutions** when possible.
4. Avoid unnecessary data structures when simple comparisons are sufficient.

This mindset applies broadly to problems involving:

* Encoded strings
* Symbol-to-value mappings
* Greedy decision-making

---

## Personal Learning Experience

When I first encountered this problem, I had little idea how to approach it. After noticing the relevance of hash tables, I decided to map each Roman numeral to its corresponding integer value using a `HashMap`.

By traversing the string from right to left, I observed that whenever the current value was smaller than the previously processed value, it should be subtracted. Otherwise, it should be added. This realization simplified the problem significantly and helped me understand why the right-to-left approach is both elegant and reliable.

This problem strengthened my understanding of greedy strategies and reinforced the importance of identifying patterns instead of memorizing rules.

---

## Conclusion

The **right-to-left traversal approach** is the cleanest, safest, and most professional solution for converting Roman numerals to integers. It naturally handles all valid cases without special conditions and should be the default choice in interviews and production-quality code.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong data structures and algorithm fundamentals.
