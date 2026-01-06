# Two Sum

## Problem Overview

Given an array of integers `nums` and an integer `target`, the goal is to identify the indices of two **distinct** elements in the array such that their sum equals `target`.

---

## Key Assumptions

* Each input has **exactly one valid solution**.
* The same array element **cannot be used more than once**.
* The order of the returned indices **does not matter**.

---

## Examples

### Example 1

```
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
```

**Explanation:**
`nums[0] + nums[1] = 2 + 7 = 9`

### Example 2

```
Input: nums = [3, 2, 4], target = 6
Output: [1, 2]
```

### Example 3

```
Input: nums = [3, 3], target = 6
Output: [0, 1]
```

---

## Constraints

* `2 ≤ nums.length ≤ 10⁴`
* `-10⁹ ≤ nums[i] ≤ 10⁹`
* `-10⁹ ≤ target ≤ 10⁹`
* Exactly **one valid answer** exists

---

## Applicable Topics

* Arrays
* Hash Tables

---

## Approaches

### 1. Brute Force Approach

#### Explanation

The brute force approach evaluates all possible pairs of elements using two nested loops. For each element, it checks whether the sum with another element equals the target.

This method is easy to understand and implement but becomes inefficient as the input size increases.

#### Time and Space Complexity

* **Time Complexity:** O(n²)
* **Space Complexity:** O(1)

#### Implementation

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
```

---

### 2. Optimal Approach (Using a Hash Table)

#### Explanation

The optimal solution uses a hash table to store numbers that have already been processed along with their indices. For each element in the array, the algorithm computes its complement (`target - current value`) and checks whether this complement exists in the hash table.

If it exists, the indices of the complement and the current element are returned. Otherwise, the current element and its index are added to the hash table. This allows the problem to be solved in a single pass.

#### Time and Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

#### Implementation

```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

---

## Personal Learning Experience

This was the first LeetCode problem I solved. Initially, the problem was not clear to me, and I spent a significant amount of time analyzing the question without making progress. I then worked through the examples manually using pen and paper, which helped me understand the requirement more clearly.

My first instinct was to apply a brute force approach by using two loops to check every possible pair of elements. Conceptually, this made sense to me, but I encountered several syntax-related issues while implementing it in Java. After multiple attempts and debugging, I was eventually able to pass all test cases using this approach.

Although the brute force solution worked, I recognized that it was not optimal. I began researching better solutions and came across explanations involving hash tables. At the time, I was familiar with the concept but had little practical experience using `HashMap` in Java.

By studying tutorials and examples, I learned how a hash table could be used to solve the problem efficiently in a single pass. I attempted to implement the optimized solution myself and again faced some syntax challenges. However, even when seeking assistance to correct those errors, the underlying concept became clear and meaningful to me.

This problem helped me understand not only how to solve Two Sum efficiently, but also how to approach problem-solving, debug code, and learn new data structures through practice.

---

## Conclusion

The brute force approach provides a straightforward solution but does not scale well for larger inputs. The hash table–based approach significantly improves efficiency and is the preferred solution for this problem. More importantly, this problem serves as an excellent introduction to algorithmic thinking and the practical use of data structures such as hash tables.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> This solution is part of continuous problem-solving practice on LeetCode to strengthen data structures and algorithm fundamentals.
