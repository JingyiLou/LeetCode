package Top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = findSumSet(candidates, target, 0);
        return res;
    }

    public List<List<Integer>> findSumSet(int[] candidates, int target, int head){
        List<List<Integer>> res = new LinkedList<>();
        for(int i=head; i < candidates.length; i++){
            if(candidates[i] == target){
                List<Integer> l = new LinkedList<>();
                l.add(target);
                res.add(l);
                return res;
            }else if(candidates[i]*2 <= target){
                List<List<Integer>> subres = findSumSet(candidates, target - candidates[i], i);
                for(List<Integer> l: subres){
                    l.add(0, candidates[i]);
                }
                res.addAll(subres);
            }
        }
        return res;
    }

    public static void main(String [] args){
        CombinationSum test = new CombinationSum();
        int [] c = new int[]{1};
        List<List<Integer>> res= test.combinationSum(c, 2);
        for(List<Integer> l: res){
            System.out.println(l);
        }

    }
}
