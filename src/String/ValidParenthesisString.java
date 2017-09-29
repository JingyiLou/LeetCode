package String;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == "") return true;
        int l = 0;
        int r = s.length() - 1;
        l = findNextCha(s, l, r);
        r = findPreCha(s, l, r);
        if (l == -1 && r == -1) return true;
        else {
            return checkSubString(s, l, r);
        }


    }

    public int findNextCha(String s, int l, int r) {
        while(!(s.charAt(l) == '(' || s.charAt(l) == '*' || s.charAt(l) == ')') ){
            l++;
            if (l >= r) {
                l = -1;
                break;
            }
        }
        return l;
    }

    public int findPreCha(String s, int l, int r) {
        while(!(s.charAt(r) == '(' || s.charAt(r) == '*' || s.charAt(r) == ')' )){
            r--;
            if (r <= l) {
                r = -1;
                break;
            }
        }
        return r;
    }

    public boolean checkSubString(String s, int l, int r) {
        if (s.charAt(l) == ')' || s.charAt(r) == '(') return false;
        if (l==r ) {
            if (s.charAt(l) != '*') return false;
            else return true;
        }
        int l2 = findNextCha(s, l+1, r);
        int r2 = findPreCha(s, l, r-1);
        if(l2 == -1 || r2 ==-1 || l2>=r2) return true;
        if (s.charAt(l) == '(' && s.charAt(r) == ')') {
            return checkSubString(s, l2, r2);
        }else return checkSubString(s, l2, r) || checkSubString(s, l, r2);
    }

    public static void main(String[] args) {
        ValidParenthesisString s = new ValidParenthesisString();
        boolean result = s.checkValidString("*");
        System.out.println(result);
    }
}

