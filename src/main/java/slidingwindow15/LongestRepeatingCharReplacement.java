package slidingwindow15;

public class LongestRepeatingCharReplacement {
//    Algorithm Steps
//    Use two pointers (left and right) to maintain a sliding window
//    Expand the right pointer and count character frequencies
//    Keep track of the maximum frequency of any character in the current window
//    If (window length - max frequency) > k, shrink the window from the left
//    Update the answer with the maximum window length seen

    public static void main(String[] args) {
        String str = "ABCBCFG";
        int k=2;

        System.out.println( characterReplacement(str,k));

    }


        public static int characterReplacement(String s, int k) {
            int[] count = new int[26];  // Frequency count for each uppercase letter
            int left = 0;
            int maxCount = 0;  // Maximum frequency of any character in current window
            int maxLength = 0;  // Result

            for (int right = 0; right < s.length(); right++) {
                // Add current character to window
                char currentChar = s.charAt(right);
                count[currentChar - 'A']++;

                // Update maxCount for current window
                maxCount = Math.max(maxCount, count[currentChar - 'A']);

                // Check if window is valid
                // Window length - maxCount <= k means we can replace remaining chars
                while ((right - left + 1) - maxCount > k) {
                    // Shrink window from left
                    char leftChar = s.charAt(left);
                    count[leftChar - 'A']--;
                    left++;

                    // Note: We don't update maxCount here as it would be O(26)
                    // We can keep maxCount as is because if it decreases,
                    // our condition will still be satisfied for smaller windows
                }

                // Update maxLength
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }



