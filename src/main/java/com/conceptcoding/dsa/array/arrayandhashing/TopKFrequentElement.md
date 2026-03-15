The **Top K Frequent Elements** is a very common **Array + HashMap + Heap / Bucket Sort** interview problem.

---

# 1. Problem Statement

Given an integer array `nums` and an integer `k`, return the **k most frequent elements**.

### Example

```
Input:
nums = [1,1,1,2,2,3]
k = 2

Output:
[1,2]
```

Explanation

| Number | Frequency |
| ------ | --------- |
| 1      | 3         |
| 2      | 2         |
| 3      | 1         |

Top 2 frequent → **1 and 2**

---

# 2. Core Idea

Two steps:

1️⃣ Count frequency using **HashMap**
2️⃣ Extract **top K frequent elements**

Approaches:

| Approach           | Time Complexity |
| ------------------ | --------------- |
| Sorting            | O(N log N)      |
| Min Heap           | O(N log K)      |
| Bucket Sort (Best) | **O(N)** ✅      |

The **most optimized solution uses Bucket Sort**.

---

# 3. Algorithm (Bucket Sort — Optimal)

### Key Idea

Frequency of any element can be **at most N**.

So we create **buckets where index = frequency**.

Example

```
frequency = 3 → bucket[3]
```

---

### Steps

1. Create HashMap to store frequency
2. Create bucket array of size `n+1`
3. Put numbers into bucket using frequency
4. Traverse bucket from **end to start**
5. Collect **k elements**

---

# 4. Pseudocode

```
function topKFrequent(nums, k)

    create map

    for num in nums
        map[num]++

    create bucket array of size n+1

    for each key in map
        freq = map[key]
        add key into bucket[freq]

    result = empty list

    for i from n down to 1
        for each num in bucket[i]
            add num to result
            if result size == k
                return result
```

---

# 5. Java Code (Most Optimized)

```java
import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : freqMap.keySet()) {

            int freq = freqMap.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {

            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
```

---

# 6. Line-by-Line Code Explanation

---

### Line

```java
Map<Integer, Integer> freqMap = new HashMap<>();
```

Create a **frequency map**

| Number | Frequency |
| ------ | --------- |
| 1      | 3         |
| 2      | 2         |
| 3      | 1         |

---

### Line

```java
for (int num : nums)
```

Loop through each number.

Example

```
1 1 1 2 2 3
```

---

### Line

```java
freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
```

Increase frequency.

Example

| Step | Map           |
| ---- | ------------- |
| 1    | {1=1}         |
| 2    | {1=2}         |
| 3    | {1=3}         |
| 4    | {1=3,2=1}     |
| 5    | {1=3,2=2}     |
| 6    | {1=3,2=2,3=1} |

---

### Line

```java
List<Integer>[] bucket = new List[nums.length + 1];
```

Create bucket array.

Index = frequency.

Example

```
bucket[1]
bucket[2]
bucket[3]
```

---

### Line

```java
for (int key : freqMap.keySet())
```

Iterate through map elements.

---

### Line

```java
int freq = freqMap.get(key);
```

Get frequency of number.

Example

```
1 → 3
2 → 2
3 → 1
```

---

### Line

```java
bucket[freq].add(key);
```

Put element into corresponding bucket.

Example

| Bucket Index | Elements |
| ------------ | -------- |
| 1            | [3]      |
| 2            | [2]      |
| 3            | [1]      |

---

### Line

```java
for (int i = bucket.length - 1; i >= 0; i--)
```

Traverse buckets **from highest frequency**.

Example

```
bucket[3]
bucket[2]
bucket[1]
```

---

### Line

```java
result.addAll(bucket[i]);
```

Add elements to result.

Example

```
result = [1]
result = [1,2]
```

Stop when `k` elements collected.

---

# 7. Full Execution (Tabular)

Input

```
nums = [1,1,1,2,2,3]
k = 2
```

### Step 1: Frequency Map

| Number | Count |
| ------ | ----- |
| 1      | 3     |
| 2      | 2     |
| 3      | 1     |

---

### Step 2: Bucket Structure

| Index (Frequency) | Bucket |
| ----------------- | ------ |
| 0                 | []     |
| 1                 | [3]    |
| 2                 | [2]    |
| 3                 | [1]    |

---

### Step 3: Traverse From End

| Frequency | Result |
| --------- | ------ |
| 3         | [1]    |
| 2         | [1,2]  |

Stop (k=2)

---

# 8. Time Complexity

### Frequency Map

```
O(N)
```

### Bucket Placement

```
O(N)
```

### Traversal

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

---

# 10. Why This Problem is Important

Companies that frequently ask this problem:

* Amazon
* Google
* Microsoft
* Meta

Because it tests:

* HashMap
* Heap / Bucket Sort
* Frequency counting
* Optimization

---

✅ If you want, I can also show:

1️⃣ **Min Heap solution (used in many interviews)**
2️⃣ **Step-by-step dry run visualization**
3️⃣ **How this question is extended into harder interview variants**.
