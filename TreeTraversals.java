class TreeNode{
    int data;
    
    TreeNode left;
    TreeNode right;a
    
    TreeNode(int data){
        this.data = data;
    }
}

class BinaryTree{
    TreeNode root;
    
    BinaryTree(){
        root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
    }
    
    /*
        left -> top -> right
        
        4
       / \
      5   6
     / \
    7   8
    
     7, 5, 8, 4, 6
    */
    public void inOrder(TreeNode node){
        if(node == null) return;
        
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    // inOrder(4)  -> inOrder(5) -> inOrder(7) -> inOrder(null) -> 7 -> inOrder(null) -> 5 -> inOrder(8) -> inOrder(null) -> 8 -> inOrder(null) -> 4 
    /*
        
    */
    public void preOrder(TreeNode node){
        if(node == null) return;
        System.out.print(node.data + " ");
        
        preOrder(node.left);
        preOrder(node.right);
    }
    
    /* */
    public void postOrder(TreeNode node){
        if(node == null) return;        
        
        postOrder(node.left);
        postOrder(node.right);
        
        System.out.print(node.data + " ");
    }
    
    public void levelOrder(){
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        /*
            1st method :
            
            [4, NULL]
            [NULL, 5, 6]
            [5, 6, NULL]
            [6, NULL, 7, 8]
            [NULL, 7, 8, 9 , 10]
            [7, 8, 9 , 10, NULL]
            
            2nd method :
            
            [4]
            [5, 6]
            [7, 8, 9, 10]
        */
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode current = q.remove();
                System.out.print(current.data + " ");
                
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            
            System.out.println();            
        }
    }
}
public class Main {
    public static void experiment(){
        Queue<Integer> q = new LinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
        
        System.out.println(q.remove());
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        //tree.levelOrder();        
        tree.inOrder(tree.root);
        System.out.println();

        tree.preOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
    }
}
