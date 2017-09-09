package Array;

public class MaximumSwap {
    public int maximumSwap(int num) {
        String number = Integer.toString(num);
        int len = number.length();
        int [] array = new int[len];
        for(int i=len-1; i>=0; i--){
            array[i] = num%10;
            num = num/10;
        }
        int result = Integer.parseInt(doExchange(array));
        return result;
    }

    public String doExchange(int [] num){
        boolean hasExchanged = false;
        if(num.length < 2){
            return toString(num);
        }else{
            for(int i=0; i<num.length-1; i++){
                int biggestNum = i;
                for(int j=i+1; j<num.length; j++){
                    if(num[biggestNum]<num[j]){
                        biggestNum = j;
                    }else if(num[biggestNum] == num[j] && biggestNum != i){
                        biggestNum = j;
                    }
                }
                if(biggestNum != i){
                    int a = num[i];
                    num[i] = num[biggestNum];
                    num[biggestNum] = a;
                    hasExchanged = true;
                }
                if(hasExchanged) break;
            }
            return toString(num);
        }
    }

    public String toString(int [] num){
        StringBuilder strNum = new StringBuilder();
        for(int n: num){
            strNum.append(n);
        }
        return strNum.toString();
    }
}

//Other Solution:
//1. Ignore all digits until decreasing, until (next digit > prev). store the min and minindex
//2. Starting from minindex find the largest digit in the remaining digits.
//3. Iterate through the array till minIndex to find any digit that might be lesser than max
//4. Swap the maxIndex digit with swapIndex
