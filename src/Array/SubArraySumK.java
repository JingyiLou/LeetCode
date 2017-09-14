package Array;

public class SubArraySumK {
    //store the first j sum in currSum[j]
    //for each i traversed, calculates currSum[j] + nums[i] to see if it matches k
    public int subarraySum(int[] nums, int k) {
        int [] currSum = new int[nums.length];
        int count = 0;
        for(int i=0; i<nums.length; i++){
            currSum[i] = nums[i];
            if(nums[i] == k){
                count++;
            }
            for(int j=0; j<i; j++){
                currSum[j] += nums[i];
                if(currSum[j] == k){
                    count++;
                }
            }
        }
        return count;
    }
}
