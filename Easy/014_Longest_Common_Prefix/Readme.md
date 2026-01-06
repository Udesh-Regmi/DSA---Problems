# Longest Common Prefix

## Problem Overview

Given an array of strings `strs`, return the **longest common prefix** shared among all strings.

If there is **no common prefix**, return an empty string `""`.

A prefix is a **starting substring** of a string. For example, `"pre"` is a prefix of `"prefix"`, but not of `"replay"`.

---

## Examples

### Example 1

```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

### Example 2

```
Input: strs = ["dog","racecar","car"]
Output: ""
```

**Explanation:** There is no common prefix among the input strings.

---

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

## Core Idea

This problem is about **reducing comparisons**.

Key observation:

> If all strings are sorted lexicographically, the **longest common prefix of the entire array** must be the common prefix between:
>
> * the **first** string
> * the **last** string

### Why This Works

* Sorting places the most dissimilar strings at the extremes.
* Any mismatch in the prefix will appear between these two strings.
* Comparing only two strings instead of all of them simplifies the logic while remaining correct.

---

## Approach: Sorting + First/Last Comparison

### Explanation

1. If the array is empty, return an empty string.
2. Sort the array lexicographically.
3. Compare characters of:

   * `first = strs[0]`
   * `last = strs[strs.length - 1]`
4. Count matching characters from the start.
5. Return the substring from index `0` to the first mismatch.

This avoids repeated comparisons across all strings.

---

## Time and Space Complexity

* **Time Complexity:**
  `O(n log n + m)`
  where:

  * `n` = number of strings
  * `m` = length of the shortest string

* **Space Complexity:**
  `O(1)` (ignoring sort internals)

---

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

---

## Alternative Approaches (Brief)

### 1. Vertical Scanning

Compare characters column by column across all strings.

* Time: `O(n · m)`
* Space: `O(1)`
* Very intuitive, but involves more comparisons.

### 2. Horizontal Scanning

Start with the first string as the prefix and shrink it while comparing with each string.

* Time: `O(n · m)`
* Space: `O(1)`

### 3. Trie (Prefix Tree)

Insert all strings into a Trie and traverse until characters diverge.

* Time: `O(n · m)`
* Space: `O(n · m)`
* Generally unnecessary unless explicitly required.

---

## Comparison Summary

| Approach        | Time       | Space  | Verdict         |
| --------------- | ---------- | ------ | --------------- |
| Sorting (Used)  | O(n log n) | O(1)   | ✅ Clean & Smart |
| Vertical Scan   | O(n · m)   | O(1)   | ✅ Common        |
| Horizontal Scan | O(n · m)   | O(1)   | ✅ Acceptable    |
| Trie            | O(n · m)   | O(n·m) | ⚠️ Overkill     |

---

## Personal Learning Experience

When I first attempted this problem, my instinct was to compare every string with every other string, which quickly felt messy and inefficient. I then tried vertical scanning, comparing characters column by column, which worked but still felt like more effort than necessary.

After exploring different solutions, the sorting-based approach stood out. Initially, it was not obvious to me why sorting would help. However, once I understood that the longest common prefix must lie between the lexicographically smallest and largest strings, the logic became very clear.

This problem taught me an important lesson: sometimes a preprocessing step like sorting can dramatically simplify a problem. Instead of brute-forcing comparisons, identifying extreme cases can lead to cleaner and more elegant solutions.

---

## Conclusion

The sorting-based approach is concise, readable, and effective. By reducing the problem to a comparison between just two strings, it avoids unnecessary complexity while remaining robust and interview-friendly.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> Part of continuous LeetCode practice focused on building strong data structures and algorithm fundamentals.
