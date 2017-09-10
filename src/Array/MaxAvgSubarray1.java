package Array;

public class MaxAvgSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double subMax = 0;
        for(int i=0; i<k; i++){
            subMax += nums[i];
        }
        double curSum = subMax;
        for(int j=k; j<nums.length; j++){
            curSum = curSum + nums[j] - nums[j-k];
            if(curSum > subMax) subMax = curSum;
        }
        return subMax/k;
    }
}
