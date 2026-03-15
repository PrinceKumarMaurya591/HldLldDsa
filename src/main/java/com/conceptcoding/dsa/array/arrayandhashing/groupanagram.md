The **Group Anagrams** problem is a classic **Array + HashMap** interview question.

---

# 1. Problem Statement

Given an array of strings `strs`, group the **anagrams** together.

Two strings are **anagrams** if:

* They contain the **same characters**
* With the **same frequency**
* Order **doesn't matter**

### Example

```
Input:
["eat","tea","tan","ate","nat","bat"]

Output:
[
 ["eat","tea","ate"],
 ["tan","nat"],
 ["bat"]
]
```

---

# 2. Core Idea (Algorithm)

Key observation:

If we **sort the characters of a word**, all its anagrams will produce the **same sorted string**.

Example:

| Word | Sorted |
| ---- | ------ |
| eat  | aet    |
| tea  | aet    |
| ate  | aet    |
| tan  | ant    |
| nat  | ant    |
| bat  | abt    |

So we:

1. Create a **HashMap**
2. Key = **sorted string**
3. Value = **list of anagrams**
4. Loop through all words
5. Sort each word
6. Store word in map using sorted key
7. Return all values of map

---

# 3. Algorithm Steps

1. Create a HashMap `map`
2. Iterate over each string `s` in array
3. Convert string to char array
4. Sort char array
5. Convert sorted array back to string → `key`
6. If `key` not in map → create new list
7. Add original word to list
8. Return all values of map

---

# 4. Pseudocode

```
function groupAnagrams(strs):

    create map

    for each word in strs:

        chars = convert word to char array
        sort chars
        key = convert chars to string

        if key not in map
            map[key] = new empty list

        add word to map[key]

    return all values of map
```

---

# 5. Java Code

```java
import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

}
```

---

# 6. Line-by-Line Code Explanation

### Line 1

```
Map<String, List<String>> map = new HashMap<>();
```

Create a **HashMap**

| Key         | Value            |
| ----------- | ---------------- |
| sorted word | list of anagrams |

Example

```
aet → [eat, tea, ate]
```

---

### Line 2

```
for (String word : strs)
```

Loop through every word in input array.

Example iteration

```
eat
tea
tan
ate
nat
bat
```

---

### Line 3

```
char[] chars = word.toCharArray();
```

Convert word into character array.

Example

| Word | Char Array |
| ---- | ---------- |
| eat  | [e,a,t]    |

---

### Line 4

```
Arrays.sort(chars);
```

Sort characters.

| Before  | After   |
| ------- | ------- |
| [e,a,t] | [a,e,t] |

---

### Line 5

```
String key = new String(chars);
```

Convert sorted array back into string.

| Sorted chars | Key   |
| ------------ | ----- |
| [a,e,t]      | "aet" |

This **key identifies anagram group**.

---

### Line 6

```
if (!map.containsKey(key))
```

Check if this anagram group already exists.

Example

```
aet → exists?
```

---

### Line 7

```
map.put(key, new ArrayList<>());
```

If not present, create new list.

```
aet → []
```

---

### Line 8

```
map.get(key).add(word);
```

Add original word into the group.

Example

| Key | List            |
| --- | --------------- |
| aet | [eat]           |
| aet | [eat, tea]      |
| aet | [eat, tea, ate] |

---

### Line 9

```
return new ArrayList<>(map.values());
```

Return all grouped anagrams.

Example

```
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]
```

---

# 7. Full Execution Example (Tabular)

Input

```
["eat","tea","tan","ate","nat","bat"]
```

| Word | Sorted Key | HashMap State       |
| ---- | ---------- | ------------------- |
| eat  | aet        | aet → [eat]         |
| tea  | aet        | aet → [eat,tea]     |
| tan  | ant        | ant → [tan]         |
| ate  | aet        | aet → [eat,tea,ate] |
| nat  | ant        | ant → [tan,nat]     |
| bat  | abt        | abt → [bat]         |

Final Map

| Key | Value         |
| --- | ------------- |
| aet | [eat,tea,ate] |
| ant | [tan,nat]     |
| abt | [bat]         |

Output

```
[[eat,tea,ate],[tan,nat],[bat]]
```

---

# 8. Time & Space Complexity

### Time Complexity

```
Sorting each word → O(K log K)

Total → O(N * K log K)
```

Where

| Symbol | Meaning           |
| ------ | ----------------- |
| N      | number of strings |
| K      | max string length |

---

### Space Complexity

```
O(N*K)
```

for storing strings in hashmap.

---

# 9. Interview Follow-up (Important)

Optimized approach (without sorting):

Use **character frequency array** of size 26 as key.

Time complexity improves to:

```
O(N*K)
```

instead of

```
O(N*K logK)
```

---

✅ If you want, I can also show the **most optimized solution (frequency hash method) with visualization used in FAANG interviews.**




The most optimized solution for **Group Anagrams** avoids sorting and instead uses a **character frequency count**.

This improves the time complexity.

---

# 1. Core Idea (Most Optimized)

Instead of sorting the string, we:

1. Count frequency of each character (`a–z`)
2. Use the **frequency array as a key**
3. All anagrams will have the **same frequency pattern**

Example

```
eat → a1 e1 t1
tea → a1 e1 t1
ate → a1 e1 t1
```

So they belong to the **same group**.

---

# 2. Algorithm Steps

1. Create a HashMap
2. Key → frequency signature
3. Value → list of anagrams
4. For every word

    * create `int[26]` array
    * count letters
    * convert array into key string
5. Store word in hashmap
6. Return all grouped lists

---

# 3. Pseudocode

```
function groupAnagrams(strs)

    create map

    for each word in strs

        count = array[26] initialized to 0

        for each character c in word
            count[c - 'a']++

        key = convert count array to string

        if key not in map
            create new list

        add word to map[key]

    return map values
```

---

# 4. Java Code (Optimized)

```java
import java.util.*;

public class GroupAnagramsOptimized {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

}
```

---

# 5. Line-by-Line Explanation

### Line

```java
Map<String, List<String>> map = new HashMap<>();
```

HashMap to store grouped anagrams.

| Key                 | Value            |
| ------------------- | ---------------- |
| frequency signature | list of anagrams |

---

### Line

```java
for (String word : strs)
```

Iterate through each word.

Example

```
eat
tea
tan
ate
nat
bat
```

---

### Line

```java
int[] count = new int[26];
```

Create frequency array for letters **a–z**.

| Index | Letter |
| ----- | ------ |
| 0     | a      |
| 1     | b      |
| 2     | c      |
| ...   | ...    |
| 25    | z      |

---

### Line

```java
for (char c : word.toCharArray())
```

Iterate each character of word.

Example

```
eat → e,a,t
```

---

### Line

```java
count[c - 'a']++;
```

Convert letter to index.

Example

| Char | Calculation | Index |
| ---- | ----------- | ----- |
| e    | 'e'-'a'     | 4     |
| a    | 'a'-'a'     | 0     |
| t    | 't'-'a'     | 19    |

Result array

```
[a=1,e=1,t=1]
```

---

### Line

```java
String key = Arrays.toString(count);
```

Convert frequency array into string key.

Example

```
[1,0,0,0,1,0,...,1]
```

This uniquely identifies an anagram group.

---

### Line

```java
map.putIfAbsent(key, new ArrayList<>());
```

If key does not exist → create new list.

Example

```
[1,0,0,0,1,0,...] → []
```

---

### Line

```java
map.get(key).add(word);
```

Add word to group.

Example

```
key → [eat]
key → [eat,tea]
key → [eat,tea,ate]
```

---

### Line

```java
return new ArrayList<>(map.values());
```

Return grouped anagrams.

Output

```
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]
```

---

# 6. Full Execution (Tabular Visualization)

Input

```
["eat","tea","tan","ate","nat","bat"]
```

| Word | Frequency Key | HashMap              |
| ---- | ------------- | -------------------- |
| eat  | a1 e1 t1      | key1 → [eat]         |
| tea  | a1 e1 t1      | key1 → [eat,tea]     |
| tan  | a1 n1 t1      | key2 → [tan]         |
| ate  | a1 e1 t1      | key1 → [eat,tea,ate] |
| nat  | a1 n1 t1      | key2 → [tan,nat]     |
| bat  | a1 b1 t1      | key3 → [bat]         |

Final Output

```
[
 [eat,tea,ate],
 [tan,nat],
 [bat]
]
```

---

# 7. Time Complexity

| Step                 | Complexity |
| -------------------- | ---------- |
| Counting characters  | O(K)       |
| Processing N strings | O(N*K)     |

Final

```
Time Complexity = O(N * K)
```

Better than sorting method:

```
O(N * K logK)
```

---

# 8. Space Complexity

```
O(N * K)
```

for storing grouped strings.

---

# 9. Why FAANG prefers this solution

| Method          | Time         |
| --------------- | ------------ |
| Sorting         | O(N K logK)  |
| Frequency Count | **O(N K)** ✅ |

So **frequency hashing** is considered the **most optimized interview solution**.

---

If you want, I can also show **3 more important things interviewers ask after this problem:**

1️⃣ **Dry Run Visualization (step-by-step animation style)**
2️⃣ **Follow-up: Group Anagrams without converting array to string (even faster)**
3️⃣ **How this question appears in Google / Amazon interviews**.
