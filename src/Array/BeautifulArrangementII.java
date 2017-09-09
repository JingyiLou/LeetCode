package Array;

public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int [] array = new int[n];
        array[0] = 1;
        int low = 2;
        int high = n;
        boolean odd = true;
        //set the first k number as [1,n,2,n-1,3,n-2...], so there would be k-1 individual diffs.
        for(int i=1; i<k; i++){
            if(odd){
                array[i] = high;
                high = high-1;
                odd = false;
            }else{
                array[i] = low;
                low = low+1;
                odd = true;
            }
        }
        //let the remaining n-k numbers continuously go up or down by one step and it would occur one diff, add the total diff to k.
        int prev = array[k-1];
        for(int j=k; j<n; j++){
            if(odd){
                array[j] = prev+1;
                prev += 1;
            }else{
                array[j] = prev-1;
                prev -=1;
            }
        }
        return array;

    }
}
