# Two Sum

## Problem Overview

Given an array of integers `nums` and an integer `target`, the objective is to identify the indices of the two distinct elements in the array whose sum equals the given `target`.

### Key Assumptions

* Each input has **exactly one valid solution**.
* The same array element **cannot be used twice**.
* The order of the returned indices does **not** matter.

---

## Examples

**Example 1**

```
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

**Example 2**

```
Input: nums = [3, 2, 4], target = 6
Output: [1, 2]
```

**Example 3**

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

The brute force solution checks all possible pairs of elements using two nested loops. For each element, it compares the sum with every other element until the target is found.

Although simple to understand and implement, this approach is inefficient for large inputs.

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

### 2. Optimal Approach (Using Hash Table)

#### Explanation

This approach leverages a hash table to store previously visited numbers along with their indices. For each element, it calculates the complement (`target - current value`) and checks if it already exists in the hash table.

This allows the problem to be solved in a single pass.

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

## Conclusion

While the brute force approach is straightforward, it does not scale well. The hash table–based solution significantly improves performance and is the preferred method for this problem, especially under tight time constraints.

---

## Author & Links

* **GitHub:** [https://github.com/Udesh-Regmi](https://github.com/Udesh-Regmi)
* **LinkedIn:** [https://www.linkedin.com/in/udesh-regmi/](https://www.linkedin.com/in/udesh-regmi/)
* **LeetCode:** [https://leetcode.com/u/Udesh-Regmi/](https://leetcode.com/u/Udesh-Regmi/)

---

> This solution is part of continuous problem-solving practice on LeetCode to strengthen data structures and algorithm fundamentals.
