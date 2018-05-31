// "static void main" must be defined in a public class.
class BSTNode{
    int data;
    
    BSTNode left;
    BSTNode right;
    
    BSTNode(int data){
        this.data = data;
    }
}

class BST{
    BSTNode root;
    
    void insert(int data){
        if(root == null){
            root = new BSTNode(data);
            return;
        }
        
        insertRecursive(root, data);
    }
    
    BSTNode insertRecursive(BSTNode node, int data){
        if(node == null) return new BSTNode(data);
        
        if(node.data < data){
             node.right = insertRecursive(node.right, data);   
        }
        else node.left = insertRecursive(node.left, data);        
        
        return node;
    }
    
    public void order(){
        inOrder(root);
    }
    
    public void inOrder(BSTNode node){
        if(node == null) return;
        
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
    
    public BSTNode search(int key){
        return searchRecursive(root, key);
    }
    
    public BSTNode searchRecursive(BSTNode node, int key){
        if(node == null) return null;
        if(node.data == key) return node;
        
        if(node.data > key) return searchRecursive(node.left, key);
        return searchRecursive(node.right, key);
    }
    
    public BSTNode lca(int n1, int n2){
        return BSTRecursive(root, n1, n2);
    }
    
    public BSTNode BSTRecursive(BSTNode node, int n1, int n2){
        if(node == null) return null;
        if(node.data == n1 || node.data == n2) return node;
        if(node.data > n1 && node.data < n2) return node;
        
        if(node.data > n1 && node.data > n2) return BSTRecursive(node.left, n1, n2);
        return BSTRecursive(node.right, n1, n2);
    }
    
    public void levelOrder(){
        Queue<BSTNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                BSTNode current = q.remove();
                System.out.print(current.data + " ");
                
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
            
            System.out.println();            
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        
        BSTNode node = tree.search(2);
        //System.out.println(node.data);
        
        /*
        AVL rotation to conserve height
        
        1
         \
          2         2
           \      /   \
            3  - 1     3
        
        */
        
        //tree.order();
        //tree.levelOrder();
        
        /*
            6
           4 7
          3 5 
        */
        
        System.out.println(tree.lca(3, 5).data);
        System.out.println(tree.lca(4, 4).data);
        System.out.println(tree.lca(4, 10).data);
    }
}
