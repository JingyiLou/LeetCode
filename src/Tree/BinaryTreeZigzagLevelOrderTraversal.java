package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root != null){
            if(level >= res.size()) res.add(level, new LinkedList<Integer>());
            helper(root.left, res, level+1);
            if(level%2 == 0) res.get(level).add(root.val);
            else res.get(level).add(0, root.val);
            helper(root.right, res, level+1);
        }else return;
    }
}
