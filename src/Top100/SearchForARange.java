package Top100;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int index = BinarySearch(nums, target);
        int count = 0;
        int lo = -1;
        int hi = -1;
        if(index != -1){
            count++;
            lo = hi = index;
            int index2 = index;
            while(index>0  && nums[index-1] == nums[index]){
                count++;
                index--;
            }
            lo = index;
            while(index2<nums.length-1 && nums[index2+1] == nums[index2]){
                count++;
                index2++;
            }
            hi = index2;
        }
        int [] res = new int[]{lo, hi};
        return res;
    }

    public int BinarySearch(int[] nums, int target){
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(target > nums[mid]){
                lo = mid+1;
            }else if(target < nums[mid]){
                hi = mid-1;
            }else return mid;
        }
        return -1;
    }
}
