package Top100;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxContainer = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r){
            maxContainer = Math.max(Math.min(height[l], height[r])*(r-l), maxContainer);
            if(height[l] < height[r]) l++;
            else r--;
        }
        return maxContainer;
    }
}
