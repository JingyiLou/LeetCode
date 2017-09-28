package String;

import java.util.Arrays;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        String [] s = time.split(":");
        Integer hour = Integer.parseInt(s[0]);
        Integer min = Integer.parseInt(s[1]);
        int [] num = new int[4];
        num[0] = hour/10;
        num[1] = hour%10;
        num[2] = min/10;
        num[3] = min%10;
        Arrays.sort(num);
        String nextMin;
        String nextHour;
        nextMin = findNextTime(0, min, num);
        if(nextMin.equals(s[1])){
            nextHour = findNextTime(1, hour, num);
            if(nextHour.equals(s[0])){
                nextMin= nextHour= findMinTime(num);
            }else{
                nextMin = findMinTime(num);
            }
        }else
            nextHour = s[0];
        StringBuilder nextTime = new StringBuilder();
        nextTime.append(nextHour);
        nextTime.append(':');
        nextTime.append(nextMin);
        return nextTime.toString();

    }
    public String findNextTime(int pos, int orig, int[] num){
        boolean isFind = false;
        int digitMax;
        int tenMax;

        //find next minute [00,59]
        int digit = orig%10;
        int ten = orig/10;
        for(int i=0; i<num.length; i++){
            if(digit<num[i]){
                digit = num[i];
                isFind = true;
                break;
            }
        }
        if(!isFind){
            for(int i=0; i<num.length; i++){
                if(ten<num[i]){
                    ten = num[i];
                    digit = num[0];
                    isFind = true;
                    break;
                }
            }
        }

        if(pos==0){
            if((digit+ten*10) >59) return Integer.toString(orig);
        }else{
            if((digit+ten*10) >24) return Integer.toString(orig);
        }
        StringBuilder s = new StringBuilder();
        s.append(ten);
        s.append(digit);
        return s.toString();
    }
    public String findMinTime(int[] num){
        StringBuilder s = new StringBuilder();
        s.append(num[0]);
        s.append(num[0]);
        return s.toString();
    }
    public static void main(String [] agrs){
        NextClosestTime nc = new NextClosestTime();
        String result = nc.nextClosestTime("13:55");
        System.out.println(result);
    }
}
