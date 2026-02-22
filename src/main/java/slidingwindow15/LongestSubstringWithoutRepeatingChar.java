package slidingwindow15;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println( longestSubStr(str));
    }

    public static int longestSubStr(String str) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int left=0;
       for(int i=0;i<str.length();i++){
           char c=str.charAt(i);
           if(map.containsKey(c)) {
//               Ab right = 3 par 'a' aata hai:
//               map mein 'a' already exists (index 0)
//               map.get('a') + 1 = 0 + 1 = 1
//               Math.max(left, 1) = Math.max(0, 1) = 1
//               Isliye left = 1 ho jata hai
//               Iska matlab: ab window "bca" hogi (index 1 se 3 tak)

               left = Math.max(left, map.get(c) + 1);
           }

           map.put(c, i);
           maxLen = Math.max(maxLen, i - left + 1);
       }

        return maxLen;
    }
}
