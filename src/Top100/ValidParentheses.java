package Top100;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> a = new Stack<>();
        for(char p: s.toCharArray()){
            if(p == '('){
                a.push(')');
            }else if(p == '{'){
                a.push('}');
            }else if(p == '['){
                a.push(']');
            }else if(a.empty() || p != a.pop()){
                return false;
            }
        }
        if(!a.empty()) return false;
        return true;
    }
}
