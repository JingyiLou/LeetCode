package Top100;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = findPalindrome(s, i, i);
            int len2 = findPalindrome(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > maxLen){
                maxLen = len;
                if(len%2 == 0){
                    start = i-(len-1)/2;
                    end = i+len/2;
                }else{
                    start = i-len/2;
                    end = i+len/2;
                }
            }
        }
        String res = s.substring(start, end+1);
        return res;
    }

    public int findPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

    public static void main(String [] args){
        longestPalindrome test = new longestPalindrome();
        String s = test.longestPalindrome("cbbd");
        System.out.println(s);
    }
}
