package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDupSubtree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> dup = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        helper(dup, mp, root);
        return dup;
    }

    public String helper(List<TreeNode> dup, Map<String, Integer> mp, TreeNode root){
        if(root == null) return "#";
        String s = root.val + "," + helper(dup, mp, root.left) + "," + helper(dup, mp, root.right);
        if(mp.getOrDefault(s, 0) == 1) dup.add(root);
        mp.put(s, mp.getOrDefault(s, 0)+1);
        return s;
    }
}
