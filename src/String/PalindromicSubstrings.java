package String;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s.length() == 0) return 0;
        int count = s.length();

        for(int size=2; size<=s.length(); size++){
            for(int i=0; i+size-1 < s.length(); i++){
                if(checkSubString(s, i, i+size-1)) count++;
            }
        }
        return count;
    }

    public boolean checkSubString(String s, int l, int r){
        while(l<r && s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }
        if(l >= r) return true;
        else return false;
    }
}
