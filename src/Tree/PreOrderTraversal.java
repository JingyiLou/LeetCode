package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    //Use recursion
    public List<Integer> preorderTraversalI(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if(root != null){
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }

    //Use stack
    public List<Integer> preorderTraversalII(TreeNode root){
        List <Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()){
            while(curr != null){
                res.add(curr.val);
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            curr = curr.right;
        }
        return res;
    }
}
