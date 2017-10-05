package Top100;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return binarySearch(nums, target, 0, nums.length-1);
    }


    public int binarySearch(int [] nums, int target, int l, int r){
        if(l<0 || r>nums.length-1 || l>r) return -1;
        //if(r == l && nums[l] != target) return -1;
        int mid = (r + l)/2;
        if(nums[mid] < nums[r]){
            if(target < nums[mid] || target > nums[r]){
                return binarySearch(nums, target, l, mid-1);
            }else if(nums[mid] < target && target <= nums[r]) {
                return binarySearch(nums, target, mid + 1, r);
            }else return mid;
        }else if(nums[mid] > nums[r]){
            if(target <= nums[r] || target > nums[mid]){
                return binarySearch(nums, target, mid+1, r);
            }else if(nums[r] < target && target < nums[mid]){
                return binarySearch(nums, target, l, mid-1);
            }else return mid;
        }else if(nums[mid] == nums[r] && nums[mid] == target){
            return mid;
        }
        else return -1;
    }

    public static void main(String [] args){
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int [] nums = new int[]{1, 3};
        int res = test.search(nums, 3);
        System.out.println(res);
    }
}
