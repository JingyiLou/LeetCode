/**
 * Created by jennifer on 17/2/22.
 */
public class MajorityElement169 {
    public int majorityElement(int[] num){

        int major = num[0], count = 1;
        for(int i=1; i<num.length; i++){
            if(count == 0){
                count++;
                major = num[i];
            }else if(major == num[i]){
                count++;
            }else count--;
        }
        return major;
    }

    public static void main(String[] args){
        int[] num = new int[]{1,2,1,1,2,1,5,5,1,5,5,1,1};
        MajorityElement169 i = new MajorityElement169();
        int k = i.majorityElement(num);
        System.out.println(k);
    }

}
