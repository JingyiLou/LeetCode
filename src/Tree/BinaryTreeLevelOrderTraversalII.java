package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        int level = 0;
        helper(root, res, level);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root != null){
            if (level >= res.size()) res.add(0, new LinkedList<Integer>());
            helper(root.left, res, level+1);
            res.get(res.size()-level-1).add(root.val);
            helper(root.right, res, level+1);
        }else{
            return;
        }
    }
}
