import java.util.regex.Pattern;

/**
 * Created by jennifer on 17/2/3.
 */
public class ValidataIPAddr {
    public String validIPAddress(String IP) {
        String[] subString1 = IP.split("\\.");
        String[] subString2 = IP.split(":");
        if(subString1.length == 4){
            boolean isIPv4 = checkIPv4(subString1);
            if(isIPv4) return "IPv4";
            else return "Neither";
        }else if(subString2.length == 8 ){
            boolean isIPv6 = checkIPv6(subString2);
            if(isIPv6) return "IPv6";
            else return "Neither";
        }else return "Neither";
    }

    public boolean checkIPv4(String[] subString){
        boolean isIPv4 = true;
        int firstNonZeroIndex = 2;
        int lengthOfSubString;
        for(int i=0; i<4; i++){
            Pattern pattern = Pattern.compile("[0-9]*");
            if(subString[i].length()>0 && subString[i].length()<=3) {
                if (!pattern.matcher(subString[i]).matches()) {
                    isIPv4 = false;
                    break;
                }
                Integer num = Integer.parseInt(subString[i]);
                lengthOfSubString = num.toString().length();
                for (int j = 0; j < subString[i].length(); j++) {
                    if (subString[i].charAt(j) != '0') {
                        firstNonZeroIndex = j;
                        break;
                    }
                }
                if (num < 0 || num > 255 || firstNonZeroIndex != subString[i].length() - lengthOfSubString)
                    isIPv4 = false;
            }else{
                isIPv4 = false;
                break;
            }
        }
        return isIPv4;
    }

    public boolean checkIPv6(String[] subString){
        boolean isIPv6 = true;
        for (int i = 0; i < 8; i++) {
            if(!isIPv6) break;
            if (subString[i].length() == 1) {
                if (subString[i].charAt(0) == '0') isIPv6 = true;
                else isIPv6 = false;
            } else if (subString[i].length() <= 4 && subString[i].length()>0) {
                char[] subChar = subString[i].toCharArray();
                for (int j = 0; j < subChar.length; j++) {
                    if (subChar[j] > 'f' || subChar[j] < '0') {
                        isIPv6 = false;
                        break;
                    }
                    if (j == subChar.length-1) isIPv6 = true;
                }
            }else isIPv6=false;
        }
        return isIPv6;
    }

    public static void main(String[] args){
        ValidataIPAddr IP = new ValidataIPAddr();
        String result = IP.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        System.out.println(result);
    }
}
