package Array;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        //determine there are no more than two pair of nums that satisfies array[i] > array[i+1];
        //there two conditions: 1. array[i] is larger than base line; 2. array[i+1] is smaller than base line
        if(nums.length == 1) return true;
        boolean detected = false;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                //detected sign should be considered once there is an i satisfies nums[i] > nums[i+1];
                if(detected){
                    return false;
                }else{
                    if(i == nums.length-2){
                        return true;
                    }else if(i == 0){
                        detected = true;
                    }else{
                        if(nums[i] <= nums[i+2]){
                            detected = true;
                        }else if(nums[i-1] <= nums[i+1]){
                            detected = true;
                        }else return false;
                    }
                }
            }
        }
        return true;
    }
}
