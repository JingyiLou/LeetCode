package String;

public class VaildPalindromeII {
    public boolean validPalindrome(String s) {
        int len = s.length();
        char[] string = s.toCharArray();
        boolean delete = false;
        boolean result = true;
        int head = 0;
        int tail = len-1;
        int head2 = 0;
        int tail2 = 0;
        while(head < tail){
            if(!delete ){
                if((string[head]) != string[tail]){
                    if(string[head] != string[tail-1] && string[head+1] != string[tail]){
                        result = false;
                        break;
                    }else if(string[head] != string[tail-1]){
                        head++;
                        delete = true;
                    }else if(string[head+1] != string[tail]){
                        tail--;
                        delete = true;
                    }else{
                        head2 = head;
                        tail2 = tail-1;
                        head++;
                        delete = true;
                    }
                }else{
                    head++;
                    tail--;
                }
            }else{
                if(string[head] == string[tail]){
                    head++;
                    tail--;
                }else {
                    if (head2 != 0 || tail2 != 0) {
                        while (head2 < tail2) {
                            if (string[head2] != string[tail2]) {
                                result = false;
                                break;
                            } else {
                                head2++;
                                tail2--;
                            }
                        }
                        break;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String [] args){
        VaildPalindromeII a =  new VaildPalindromeII();
        boolean result = a.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        //boolean result = a.validPalindrome("aeeeeeeeeeeeeebeeeeeeeeeeeeca");
        System.out.println(result);
    }
}
