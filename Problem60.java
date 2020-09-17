//Time Complexity: O(n)
//Space Complexity: O(n) with recursive stack
//Did it run on leetcode: yes
//Problems faced any: No

public class Problem60 {
    //will assign values when we find x and y in the tree
    private int depthX=-1;
    private int depthY=-1;
    private TreeNode parentX=null;
    private TreeNode parentY=null;

    public boolean isCousins(TreeNode root, int x, int y) {
        //implementing dfs approach;
        recursiveDFS(root, x, y, null, 0);

        if(depthX == depthY){
            if(parentX != parentY)
                return true;
        }

        return false;

    }

    private void recursiveDFS(TreeNode root, int x, int y, TreeNode parentNode, int depth){
        if(root==null)
            return;

        depth += 1;

        if(root.val==x){
            depthX = depth;
            parentX = parentNode;
        }
        if(root.val==y){
            depthY = depth;
            parentY = parentNode;
        }

        recursiveDFS(root.left, x, y, root, depth);
        recursiveDFS(root.right, x, y, root, depth);
    }
}
