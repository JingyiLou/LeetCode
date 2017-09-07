package Tree;

//import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by jennifer on 17/2/26.
 */
public class SerializeAndDeserializeBST {
    private StringBuilder A = new StringBuilder();

    public String serializeBST(TreeNode root){
        if(root == null) return A.append(' ').toString();
        A.append(Integer.toString(root.val)+' ');
        if (root.left != null) serializeBST(root.left);
        if (root.right != null) serializeBST(root.right);
        return A.toString();
    }

    public TreeNode deserializeBST(String serial){
        if(serial.equals(" ")) return null;
        else {
            String[] nodes = serial.split(" ");
            int rightIndex = nodes.length;
            int current = 0;
            TreeNode parent = null;
            boolean isleft = false;
            TreeNode root = buildBST(nodes, current, rightIndex, parent, isleft);
            return root;
        }
    }

    public TreeNode buildBST(String[] nodes, int current, int rightIndex, TreeNode parent, boolean isLeft){
        boolean hasLeftNode = false;
        boolean hasRightNode = false;
        int nextRightIndex = rightIndex;
        if(nodes[current]!=null){
            TreeNode root = new TreeNode(Integer.parseInt(nodes[current]));
            if(parent!=null){
                if(isLeft) parent.left = root;
                else parent.right = root;
            }
            if (current < nodes.length-1 && Integer.parseInt(nodes[current+1])< Integer.parseInt(nodes[current])){
                hasLeftNode = true;
            }
            for(int j=current; j< rightIndex; j++){
                if(Integer.parseInt(nodes[j])>Integer.parseInt(nodes[current])){
                    nextRightIndex = j;
                    hasRightNode = true;
                    break;
                }
            }
            if(hasLeftNode) buildBST(nodes, current+1, nextRightIndex, root, true);
            if(hasRightNode) buildBST(nodes, nextRightIndex, rightIndex, root, false);
            return root;
        }
        return null;
    }

    public TreeNode buildTree(){
        TreeNode root = new TreeNode(8);
        TreeNode two = new TreeNode(3);
        root.left = two;
        TreeNode three = new TreeNode(10);
        root.right = three;
        TreeNode four = new TreeNode(1);
        four.left = four.right = null;
        two.left = four;
        TreeNode five = new TreeNode(6);
        two.right = five;
        TreeNode seven = new TreeNode(4);
        five.left = seven;
        seven.left = seven.right = null;
        TreeNode eight = new TreeNode(7);
        five.right = eight;
        eight.left = eight.right = null;
        TreeNode six = new TreeNode(14);
        three.right = six;
        TreeNode nine = new TreeNode(13);
        six.left = nine;
        nine.left = nine.right = null;
        return root;
    }

    public TreeNode buildTree2(){
        TreeNode root = new TreeNode(2);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = three;
        return root;
    }

    public void printTree(TreeNode root){
        if (root!=null){
            System.out.print(Integer.toString(root.val)+' ');
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args){
        SerializeAndDeserializeBST test = new SerializeAndDeserializeBST();
        //TreeNode root = test.buildTree();
        //test.printTree(root);
        //StringBuilder serializeBST= new StringBuilder();
        //serializeBST = test.serializeBST(root);
        //System.out.print(serializeBST);
        //test.printTree(test.deserializeBST(serializeBST.toString()));
        TreeNode root = test.buildTree2();
        test.printTree(test.deserializeBST(test.serializeBST(root).toString()));
    }
}
