package Top100;

import sun.awt.windows.ThemeReader;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int num = -nums[i] - nums[j];
                int k = mp.getOrDefault(num, 0);
                if(nums[i] == num) k--;
                if(nums[j] == num) k--;
                if (k!=0 && num>=nums[i] && num>=nums[j]){
                    res.add(Arrays.asList(nums[i], nums[j], num));
                    List<Integer> a = new ArrayList<>();
                    while(j<nums.length-1 && nums[j] == nums[j+1]) j++;
                    if(j == nums.length-1) break;
                }
            }
            while(i<nums.length-1 && nums[i] == nums[i+1]) i++;
            if(i == nums.length-1) break;
        }
        return res;
    }

    public static void main(String [] args){
        ThreeSum test = new ThreeSum();
        int[] arg = new int[]{-2, 0, 0, 2, 2};
        test.threeSum(arg);
    }
}
