3️⃣ Algorithm

Create a HashMap

Loop through each word

Sort the word

Use sorted word as key

Store original word in list

Return all map values

| Step | Word | Sorted Word (Key) | HashMap After Insertion                                  |
| ---- | ---- | ----------------- | -------------------------------------------------------- |
| 1    | eat  | aet               | { aet → [eat] }                                          |
| 2    | tea  | aet               | { aet → [eat, tea] }                                     |
| 3    | tan  | ant               | { aet → [eat, tea], ant → [tan] }                        |
| 4    | ate  | aet               | { aet → [eat, tea, ate], ant → [tan] }                   |
| 5    | nat  | ant               | { aet → [eat, tea, ate], ant → [tan, nat] }              |
| 6    | bat  | abt               | { aet → [eat, tea, ate], ant → [tan, nat], abt → [bat] } |
