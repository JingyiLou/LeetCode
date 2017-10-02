package Top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            int num = target-nums[i];
            int pos = mp.getOrDefault(nums[i], -1);
            if(pos < 0){
                mp.put(num, i);
            }else{
                res[0] = pos;
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TwoSum test = new TwoSum();
        int arg[] = new int[]{3, 2, 4};
        String res = Arrays.toString(test.twoSum(arg, 6));
        System.out.println(res);
    }
}
