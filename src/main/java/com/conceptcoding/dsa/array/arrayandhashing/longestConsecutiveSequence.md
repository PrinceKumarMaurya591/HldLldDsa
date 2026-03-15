This code solves the **Longest Consecutive Sequence**.

It finds the **length of the longest consecutive elements sequence** in an array.

---

# 1. Problem Statement

Given an unsorted array of integers `nums`, return the **length of the longest consecutive elements sequence**.

The algorithm must run in **O(N)** time.

### Example

```
Input:
nums = [100,4,200,1,3,2]

Output:
4
```

Explanation

```
Sequence → 1,2,3,4
Length = 4
```

---

# 2. Core Idea (Most Optimized)

Key observation:

If a number **does not have a predecessor**, it is the **start of a sequence**.

Example

```
1 2 3 4
```

`1` is start because `0` does not exist.

From there we expand:

```
1 → 2 → 3 → 4
```

We use a **HashSet** for **O(1) lookup**.

---

# 3. Algorithm Steps

1. Insert all numbers into a **HashSet**
2. Loop through the set
3. If `(num - 1)` is not in set → start of sequence
4. Expand sequence using `(num + length)`
5. Track longest sequence length

---

# 4. Pseudocode

```
function longestConsecutive(nums)

    create set

    for each num in nums
        add num to set

    longest = 0

    for each num in set

        if (num - 1) not in set

            length = 1

            while set contains (num + length)
                length++

            longest = max(longest, length)

    return longest
```

---

# 5. Java Code

```java
import java.util.*;

public class Solution {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {

            if (!numSet.contains(num - 1)) {

                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
```

---

# 6. Line-by-Line Explanation

---

### Line

```java
Set<Integer> numSet = new HashSet<>();
```

Create a **HashSet** to store numbers.

Why?

```
Lookup time = O(1)
```

Example

```
nums = [100,4,200,1,3,2]
```

Set becomes

| Values |
| ------ |
| 100    |
| 4      |
| 200    |
| 1      |
| 3      |
| 2      |

---

### Line

```java
for (int num : nums)
```

Loop through the array.

---

### Line

```java
numSet.add(num);
```

Insert numbers into set.

Final set

```
{100,4,200,1,3,2}
```

---

### Line

```java
int longest = 0;
```

Stores **maximum sequence length**.

---

### Line

```java
for (int num : numSet)
```

Iterate through set.

Example order

```
100
4
200
1
3
2
```

---

### Line

```java
if (!numSet.contains(num - 1))
```

Check if **num is start of sequence**.

Example

| num | num-1 exists? | Start? |
| --- | ------------- | ------ |
| 100 | 99 ❌          | YES    |
| 4   | 3 ✅           | NO     |
| 200 | 199 ❌         | YES    |
| 1   | 0 ❌           | YES    |

So **1 starts a sequence**.

---

### Line

```java
int length = 1;
```

Start counting sequence.

---

### Line

```java
while (numSet.contains(num + length))
```

Expand sequence forward.

Example

```
start = 1
```

Check

| Condition | Result     |
| --------- | ---------- |
| 1+1=2     | exists     |
| 1+2=3     | exists     |
| 1+3=4     | exists     |
| 1+4=5     | not exists |

---

### Line

```java
length++;
```

Increase sequence length.

```
1 → 2 → 3 → 4
length = 4
```

---

### Line

```java
longest = Math.max(longest, length);
```

Update longest sequence.

Example

```
longest = max(0,4)
longest = 4
```

---

### Line

```java
return longest;
```

Return final answer.

```
4
```

---

# 7. Full Dry Run (Tabular)

Input

```
[100,4,200,1,3,2]
```

### Step 1: HashSet

| Numbers |
| ------- |
| 100     |
| 4       |
| 200     |
| 1       |
| 3       |
| 2       |

---

### Step 2: Start Points

| num | num-1 exists? | Start |
| --- | ------------- | ----- |
| 100 | no            | yes   |
| 4   | yes           | no    |
| 200 | no            | yes   |
| 1   | no            | yes   |

---

### Step 3: Sequence Expansion

| Start | Sequence | Length |
| ----- | -------- | ------ |
| 100   | 100      | 1      |
| 200   | 200      | 1      |
| 1     | 1,2,3,4  | 4      |

---

### Step 4: Longest

```
longest = 4
```

---

# 8. Time Complexity

### HashSet insertion

```
O(N)
```

### Sequence expansion

Each element visited **once**

```
O(N)
```

Final

```
Time Complexity = O(N)
```

---

# 9. Space Complexity

```
O(N)
```

for HashSet.

---

# 10. Why This Solution is Brilliant

Naive solution requires **sorting**

```
O(N log N)
```

But this **HashSet trick** reduces it to:

```
O(N)
```

That is why this is a **very famous interview optimization trick**.

---

✅ If you want, I can also show:

* **Visual diagram of how the sequence grows (very intuitive)**
* **Another FAANG trick version (Union Find approach)**
* **Top 10 similar HashSet interview problems**.
