package Top100;

import java.util.ArrayList;
import java.util.List;

public class LetterComOfAPhoneNum {
    public List<String> letterCombinations(String digits) {
        //List<StringBuilder> d = new ArrayList<>();
        List<String> res = new ArrayList<>();
        List<StringBuilder> r1 = new ArrayList<>();
        List<StringBuilder> r2 = new ArrayList<>();
        if (digits.length() == 0) return res;
        int dig = Character.getNumericValue(digits.charAt(0));
        r1 = dic(dig);
        for (int i=1; i<digits.length(); i++){
            dig = Character.getNumericValue(digits.charAt(i));
            r2 = dic(dig);
            r1 = combination(r1, r2);
        }
        for(int j=0; j<r1.size(); j++){
            res.add(r1.get(j).toString());
        };
        return res;
    }

    public List<StringBuilder> combination(List<StringBuilder> l, List<StringBuilder> r){
        List<StringBuilder> s = new ArrayList<>();
        for(int i=0; i<l.size(); i++){
            for(int j=0; j<r.size(); j++){
                StringBuilder b = new StringBuilder();
                b.append(l.get(i));
                b.append(r.get(j));
                s.add(b);
            }
        }
        return s;
    }

    public List<StringBuilder> dic (int num){
        List<StringBuilder> s = new ArrayList<>();
        switch(num){
            case 2: s.add(new StringBuilder("a"));
                    s.add(new StringBuilder("b"));
                    s.add(new StringBuilder("c"));
                    break;
            case 3: s.add(new StringBuilder("d"));
                    s.add(new StringBuilder("e"));
                    s.add(new StringBuilder("f"));
                    break;
            case 4: s.add(new StringBuilder("g"));
                    s.add(new StringBuilder("h"));
                    s.add(new StringBuilder("i"));
                    break;
            case 5: s.add(new StringBuilder("j"));
                    s.add(new StringBuilder("k"));
                    s.add(new StringBuilder("l"));
                    break;
            case 6: s.add(new StringBuilder("m"));
                    s.add(new StringBuilder("n"));
                    s.add(new StringBuilder("o"));
                    break;
            case 7: s.add(new StringBuilder("p"));
                    s.add(new StringBuilder("q"));
                    s.add(new StringBuilder("r"));
                    s.add(new StringBuilder("s"));
                    break;
            case 8: s.add(new StringBuilder("t"));
                    s.add(new StringBuilder("u"));
                    s.add(new StringBuilder("v"));
                    break;
            case 9: s.add(new StringBuilder("w"));
                    s.add(new StringBuilder("x"));
                    s.add(new StringBuilder("y"));
                    s.add(new StringBuilder("z"));
                    break;
        }
        return s;
    }

    public static void main(String [] args){
        LetterComOfAPhoneNum test = new LetterComOfAPhoneNum();
        String s = "2";
        List<String> strings= test.letterCombinations(s);
        for(String str: strings) {
            System.out.println(str);
        }
    }
}
