class BST
{
   Node root;
   BST()
   {
     root=null;
   }
  public static void main(String args[])
  {
    BST bst=new BST();
    bst.insertc(5);
    bst.insertc(7);
    bst.insertc(9);
    bst.insertc(1);
    bst.insertc(4);
    bst.insertc(2);
    bst.inorder(bst.root);
    bst.deletec(1);
    bst.inorder(bst.root);


  }
  void insertc(int val)
   {
     root=insert(root,val);
   }
  Node insert(Node current, int val)
   {
     if(current==null)
      {
        Node newNode= new Node(val);
        current=newNode;
        return current;
      }
      if(val<current.data)
        current.left= insert(current.left, val);
      else 
        current.right= insert(current.right, val);
      
      return current;  
    }
  void deletec(int val)
  {
    root=delete(root,val);
  }
  Node delete(Node current, int val)
  {
    if(current==null)
      return current; 
    if(current.data==val)
    {
      if(current.left==null)
        return current.right;
      if(current.right==null)
        return current.left;
      current.data=minValue(current.right);
      root.right = delete(root.right, root.data); 

    }
    else if (current.data > val)
    {
      current.left=delete(current.left, val);
    }
    else
    {
      current.right=delete(current.right, val);
    }
    return current;
  }
  int minValue(Node current) 
  { 
      int minv = current.data; 
      while (current.left != null) 
      { 
          minv = current.left.data; 
          root = current.left; 
      } 
      return minv; 
  } 
  void inorder(Node current)
  {
    if(current==null)
    return;
    inorder(current.left);
    System.out.println(current.data+ " ");
    inorder(current.right);
  }

}
class Node
{
  int data;
  Node left;
  Node right;
  Node(int val)
  {
    data=val;
    left=right=null;
  }
}