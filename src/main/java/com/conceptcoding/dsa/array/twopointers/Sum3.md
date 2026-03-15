The **3Sum** problem is one of the most famous **Two Pointer** interview questions.

---

# 1. Problem Statement

Given an integer array `nums`, return **all unique triplets** `[nums[i], nums[j], nums[k]]` such that:

```
nums[i] + nums[j] + nums[k] = 0
```

Conditions:

* `i ≠ j ≠ k`
* Triplets must be **unique**

---

### Example

Input

```
nums = [-1,0,1,2,-1,-4]
```

Output

```
[[-1,-1,2],[-1,0,1]]
```

---

# 2. Core Idea (Two Pointer Approach)

Steps:

1. **Sort the array**
2. Fix one element `i`
3. Use **two pointers**

```
left = i + 1
right = n - 1
```

4. Check sum

```
nums[i] + nums[left] + nums[right]
```

5. Move pointers accordingly.

---

# 3. Algorithm Steps

1. Sort array
2. Loop `i` from `0 → n-3`
3. Skip duplicates
4. Set `left = i+1`, `right = n-1`
5. Calculate sum
6. If sum = 0 → store triplet
7. If sum < 0 → move left++
8. If sum > 0 → move right--

---

# 4. Pseudocode

```
sort nums

for i = 0 to n-3

    if i > 0 and nums[i] == nums[i-1]
        continue

    left = i + 1
    right = n - 1

    while left < right

        sum = nums[i] + nums[left] + nums[right]

        if sum == 0
            add triplet
            left++
            right--

        else if sum < 0
            left++

        else
            right--
```

---

# 5. Java Code

```java
import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }

                else if (sum < 0) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }

        return result;
    }
}
```

---

# 6. Line-by-Line Explanation

---

### Sorting

```java
Arrays.sort(nums);
```

Sort array.

Example

| Before           | After            |
| ---------------- | ---------------- |
| [-1,0,1,2,-1,-4] | [-4,-1,-1,0,1,2] |

Sorting helps **use two pointers**.

---

### Loop for first number

```java
for (int i = 0; i < nums.length - 2; i++)
```

Pick first element of triplet.

Example

```
i = -4
i = -1
i = -1
i = 0
```

---

### Skip duplicates

```java
if (i > 0 && nums[i] == nums[i - 1]) continue;
```

Avoid repeated triplets.

Example

```
-1 appears twice
```

We process it only once.

---

### Two pointers

```java
int left = i + 1;
int right = nums.length - 1;
```

Example

```
i = -1

left = next number
right = last number
```

---

### While loop

```java
while (left < right)
```

Check pairs between left and right.

---

### Calculate sum

```java
int sum = nums[i] + nums[left] + nums[right];
```

Example

```
-1 + -1 + 2 = 0
```

---

### If sum = 0

```java
result.add(Arrays.asList(nums[i], nums[left], nums[right]));
```

Add triplet.

Example

```
[-1,-1,2]
```

---

### Move pointers

```java
left++;
right--;
```

Search next possible pair.

---

### Skip duplicate numbers

```java
while (left < right && nums[left] == nums[left - 1]) left++;
```

Avoid duplicate triplets.

---

# 7. Full Dry Run (Tabular)

Sorted array

```
[-4,-1,-1,0,1,2]
```

| i  | left | right | Sum | Action |
| -- | ---- | ----- | --- | ------ |
| -4 | -1   | 2     | -3  | left++ |
| -4 | -1   | 2     | -3  | left++ |
| -4 | 0    | 2     | -2  | left++ |
| -4 | 1    | 2     | -1  | left++ |
| -1 | -1   | 2     | 0   | store  |
| -1 | 0    | 1     | 0   | store  |

Result

```
[-1,-1,2]
[-1,0,1]
```

---

# 8. Time Complexity

Sorting

```
O(N log N)
```

Two pointer traversal

```
O(N^2)
```

Final

```
O(N^2)
```

---

# 9. Space Complexity

```
O(1)
```

(ignoring output list)

---

# 10. Why This Problem is Important

This problem teaches:

* Sorting + Two Pointer
* Duplicate handling
* Optimization from **O(N³) → O(N²)**

Very frequently asked in companies like:

* Amazon
* Google
* Meta
* Microsoft

---

✅ If you want, I can also show:

1️⃣ **3Sum visual diagram (best way to understand two pointers)**
2️⃣ **How 3Sum evolves into 4Sum and kSum problems**
3️⃣ **The hidden trick interviewers expect in 3Sum** (very important).
