package Integer;

public class DivTwoInteger {
    public int divide(int dividend, int divisor) {
        boolean negative = false;
        if(dividend > 0 && divisor > 0){
            negative = false;
        }else if(dividend < 0 || divisor < 0){
            if (dividend < 0 && divisor < 0){
                negative = false;
            }else{
                negative = true;
            }
        }
        dividend = goPositive(dividend);
        divisor = goPositive(divisor);

        Integer dividendInt = new Integer(dividend);
        Integer divisorInt = new Integer(divisor);
        int divisorLen = divisorInt.toString().length();
        int dividendLen = dividendInt.toString().length();
        int divCounter = 0;
        int outcome = 0;

        if ( divisor == 0 || divisor > dividend ){
            return 0;
        }

        int subDividend = getInitSubDividend(divisor, dividend, divisorLen, dividendLen);

        for (int i=divisorLen; i<=dividendLen; i++){
            int digit = getFrontDigit(dividend, dividendLen-i+1);
            subDividend = reloadSubDividend(subDividend, digit);
            while(subDividend >= divisor){
                subDividend -= divisor;
                divCounter++;
            }
            if(divCounter != 0){
                outcome = reloadOutcome(divCounter, outcome);
                //subDividend = deleteFrontDigit(subDividend);
            }else{
                outcome = outcome<<1;
            }
            if(outcome>=2147483647) break;
            divCounter = 0;
        }
        if(negative){
            return -outcome;
        }else{
            return outcome;
        }
    }

    public int goPositive(int num){
        if (num > 0) return num;
        else{
            return -num;
        }
    }
    public int getInitSubDividend(int divisor, int dividend, int dividsorLen, int dividendLen){
        int subDividend = 0;
        for(int j=0; j<dividsorLen-1; j++){
            int digit = getFrontDigit(dividend, dividendLen-j);
            subDividend = reloadSubDividend(subDividend, digit);
        }
        return subDividend;
    }
    public int getFrontDigit(int dividend, int getPlace){
        //int a  = 1<<getPlace;
        //int b = dividend & a;
        //int c = b >> (getPlace-1);
        //return c;
        if(getPlace == 1){
            return dividend & 0xf;
        }else{
            return (dividend & (1<<getPlace)) >> (getPlace-1);
        }
    }
    public int reloadSubDividend(int subDividend, int digit){
        if(subDividend == 0){
            subDividend = digit;
        }
        else{
            subDividend = (subDividend<<1) | digit;
        }
        return subDividend;
    }
    public int reloadOutcome(int divCounter, int outcome){
        if(outcome == 0){
            return divCounter;
        }else if(Integer.toBinaryString(outcome).length() == 31 && divCounter > 5) {
            return 2147483647;
        }else{
            return outcome = (outcome<<1) | divCounter;
        }
    }
    public int deleteFrontDigit(int subDividend){
        String s = String.valueOf(subDividend);
        s = s.substring(1);
        return Integer.parseInt(s);
    }

    public static void main(String [] args){
        DivTwoInteger div = new DivTwoInteger();
        System.out.println(div.divide(4322222,222));
    }
}
