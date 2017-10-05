package Top100;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> resL = new LinkedList<>();
        //Set<String> resS = new HashSet<>();
        List<Set<String>> subRes = new ArrayList<>();
        Set<String> resS = generate(subRes, n);
        resL.addAll(resS);
        return resL;
    }

    public Set<String> generate(List<Set<String>> subRes, int n){
        Set<String> p = new HashSet<>();
        if(n == 1){
            p.add("()");
            subRes.add(p);
        }
        else{
            for(String s: generate(subRes, n-1)){
                p.add("()" + s);
                p.add(s + "()");
                p.add("(" + s + ")");
            }
            for(int i = 2; i<n-1; i++){
                Set<String> p1 = subRes.get(i-1);
                Set<String> p2 = subRes.get(n-i-1);
                for(String s1: p1){
                    for(String s2: p2){
                        StringBuilder sb = new StringBuilder();
                        sb.append(s1);
                        sb.append(s2);
                        p.add(sb.toString());
                    }
                }
            }
            subRes.add(p);
        }
        return p;
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String [] args){
        GenerateParentheses test = new GenerateParentheses();
        //List<String> parenthesis = test.generateParenthesis(2);
        //for(String s: parenthesis){
        //    System.out.println(s);
        //}
        List<String> parenthesis2 = test.generateParenthesis2(2);
        for(String s: parenthesis2){
            System.out.println(s);
        }
    }
}
