package Tree;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int count = 0;
        while(root!=null){
            int h = height(root);
            int h2 = height(root.right);
            if(h == h2+1){
                count += 1 << h2;
                root = root.right;
            }else{
                count += 1 << h2;
                root = root.left;
            }
        }
        return count;
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
}
