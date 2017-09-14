package Array;

import java.util.*;


public class FindAllNumDisappearedInArray {
    class Solution {
        //do directly on the array cost less time
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Map<Integer, Integer> hash = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            for(int num: nums){
                hash.put(num, hash.getOrDefault(num, 0) + 1);
            }
            for(int i=1; i<=nums.length; i++){
                if(!hash.containsKey(i)){
                    result.add(i);
                }
            }
            return result;
        }
    }
}
