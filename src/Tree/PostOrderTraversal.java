package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    //Use Recursion
    public List<Integer> postorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if(root != null){
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }

    //Use Stack
    public List<Integer> postorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while(curr != null || !s.isEmpty()){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if(curr.right == null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode next = curr.right;
                curr.right = null;
                s.push(curr);
                curr = next;
            }
        }
        return res;
    }
}
