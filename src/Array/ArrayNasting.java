package Array;

public class ArrayNasting {
    public int arrayNesting(int[] nums) {
        int maxSet = 0;
        for(int i=0; i<nums.length; i++){
            int count = 0;
            while(nums[i]>=0){
                count++;
                int curr = nums[i];
                nums[i] = -1;
                i = curr;
            }
            if(count > maxSet){
                maxSet = count;
            }
        }
        return maxSet;
    }
}
