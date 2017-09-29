package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root != null){
            if(level >= res.size()){
                res.add(new LinkedList<Integer>());
            }
            helper(root.left, res, level+1);
            res.get(level).add(root.val);
            helper(root.right, res, level+1);
        }else return;
    }
}
