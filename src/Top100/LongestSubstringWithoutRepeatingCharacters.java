package Top100;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0, j=0; i<s.length(); i++){
            if(mp.containsKey(s.charAt(i))){
                j = Math.max(mp.get(s.charAt(i))+1, j);
            }
            maxLen = Math.max(maxLen, i-j+1);
            mp.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
