# Longest Common Prefix

## Problem Overview

Given an array of strings `strs`, return the **longest common prefix** shared among all strings.

If there is **no common prefix**, return an empty string `""`.

A prefix is a **starting substring** of a string.  
For example, `"pre"` is a prefix of `"prefix"`, but not of `"replay"`.

---

## Examples

**Example 1**
```

Input: strs = ["flower","flow","flight"]
Output: "fl"

```

**Example 2**

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix.



## Constraints

* `1 ≤ strs.length ≤ 200`
* `0 ≤ strs[i].length ≤ 200`
* `strs[i]` consists of only lowercase English letters

---

## Applicable Topics

* String Manipulation
* Arrays
* Sorting
* Prefix Matching
* Greedy Strategy

---

## Core Idea to Solve This Problem

This problem is about **reducing comparisons**.

Key observation:

> If all strings are sorted lexicographically,  
> the **longest common prefix of the entire array** must be the common prefix between:
>
> * the **first** string
> * the **last** string

Why this works:
* Sorting places the most dissimilar strings at the extremes.
* Any mismatch in prefix will appear between these two.
* Comparing only two strings instead of all improves clarity and simplicity.

---

## Approach: Sorting + First/Last Comparison

### Explanation

1. If the array is empty, return `""`.
2. Sort the array lexicographically.
3. Compare characters of:
   * `first = strs[0]`
   * `last = strs[strs.length - 1]`
4. Count matching characters from the start.
5. Return the substring from index `0` to the first mismatch.

This avoids nested comparisons across all strings.


## Time and Space Complexity

* **Time Complexity:**  
  `O(n log n + m)`  
  where:
  * `n` = number of strings
  * `m` = length of the shortest string

* **Space Complexity:**  
  `O(1)` (ignoring sort internals)


## Implementation

```java
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        while (i < first.length() && i < last.length()) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            i++;
        }

        return first.substring(0, i);
    }
}
```

## Alternative Approaches (Brief)

### 1. Vertical Scanning

Compare characters column by column across all strings.

* Time: `O(n * m)`
* Space: `O(1)`
* Very intuitive, slightly more comparisons.

### 2. Horizontal Scanning

Start with the first string as prefix and shrink it.

* Time: `O(n * m)`
* Space: `O(1)`

### 3. Trie (Prefix Tree)

Insert all strings into a Trie and traverse until divergence.

* Time: `O(n * m)`
* Space: `O(n * m)`
* Overkill for interviews unless explicitly required.

---

## Comparison Summary

| Approach        | Time       | Space  | Verdict         |
| --------------- | ---------- | ------ | --------------- |
| Sorting (Used)  | O(n log n) | O(1)   | ✅ Clean & Smart |
| Vertical Scan   | O(n · m)   | O(1)   | ✅ Common        |
| Horizontal Scan | O(n · m)   | O(1)   | ✅ Acceptable    |
| Trie            | O(n · m)   | O(n·m) | ⚠️ Overkill     |

---

## How to Approach Similar Problems

1. Identify **shared structure** (prefix, suffix, overlap).
2. Minimize comparisons by finding **extreme cases**.
3. Prefer **single-pass or reduced-input strategies**.
4. Ask:

   * Do I really need to compare everything?
   * Can sorting simplify the problem?

This mindset applies to:

* Autocomplete systems
* Search suggestions
* URL routing
* Command parsing
* Configuration key matching

---

## Real-World Use Cases

* **Search engines:** autocomplete suggestions
* **ID or SKU validation:** shared prefixes
* **File system tools:** directory path matching
* **Routing systems:** common API route detection
* **Text processing pipelines**

Any system that groups or validates strings based on shared beginnings benefits from this logic.

---

## Conclusion

The sorting-based approach is concise, readable, and effective.
By reducing the problem to a comparison between two strings, it avoids unnecessary complexity while remaining robust and interview-friendly.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong DSA fundamentals.
