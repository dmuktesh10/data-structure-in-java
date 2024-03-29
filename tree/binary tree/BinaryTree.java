class BinaryTree
{
  Node root;
  public static void main(String []args)
  {
    BinaryTree bt= new BinaryTree(1);
    System.out.println("root: "+bt.root.data);
    bt.root.left=new Node(2);
    bt.root.right=new Node(3);
    bt.root.left.left=new Node(4);
    bt.root.left.right=new Node(5);
    bt.root.right.left=new Node(6);
    bt.root.right.right=new Node(7);
    //                    1
    //                2       3
    //              4   5   6   7
    bt.inorder(bt.root);
    System.out.println("");
    bt.preorder(bt.root);
    System.out.println("");
    bt.postorder(bt.root);
    System.out.println("");
    bt.iInorder(bt.root);
    System.out.println("");
    bt.iPreorder(bt.root);
    System.out.println("");
    bt.levelOrder(bt.root);

  }
  BinaryTree(int val)
  {
    root=new Node(val);
  }
  void inorder(Node current)
  {
    if(current==null)
      return;
    inorder(current.left);
    current.print();
    inorder(current.right);
  }
  void preorder(Node current)
  {
    if(current==null)
      return;
    current.print();
    preorder(current.left);
    preorder(current.right);
  }
  void postorder(Node current)
  {
    if(current==null)
      return;
    postorder(current.left);
    postorder(current.right);
    current.print();
  }
  void iInorder(Node root)
  {
    StackAsLinkList s= new StackAsLinkList();
    Node current = root;
    while(!s.isEmpty()||current!=null)
    {
      if(current!=null)
      {
        s.push(current);
        current=current.left;
      }
      else
      {
        current=s.pop();
        System.out.print(current.data+" ");
        current=current.right;
      }
    }
  }
  void iPreorder(Node root)
  {
    if(root==null)
    return;
    StackAsLinkList s= new StackAsLinkList();
    Node current = root;
    s.push(current);
    while(!s.isEmpty())
    {
      current = s.pop();
      System.out.print(current.data + " ");
      if(current.right!=null)
        s.push(current.right);
      if(current.left!=null)  
        s.push(current.left);
    }
  }

  void levelOrder(Node root)
  {
    QueueAsLinkedList q=new QueueAsLinkedList();
    q.enqueue(root);
    while(!q.isEmpty())
    {
      Qnode temp = q.dequeue();
      Node node = temp.tnode;
      System.out.print(node.data + " ");
      if(node.left!=null)
        q.enqueue(node.left);
      if(node.right!=null)
        q.enqueue(node.right);
    }
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
  }
  void print()
  {
    System.out.print(data+" ");
  }
}

class StackAsLinkList
{
  Snode head;
  boolean isEmpty()
  {
    return (head==null);
  }
  void push(Node node)
  {
    Snode newNode = new Snode(node);
    newNode.next=head;
    head=newNode;
  }
  Node pop()
  {
    Snode current = head;
    if(current==null)
    {
      Node n=null;
      System.out.println("Stack underflow");
      return n;
    }
    else
    {
      head=current.next;
      return current.tnode;
    }
  }
}
class Snode
{
  Node tnode;
  Snode next;
  Snode(Node node)
  {
    tnode=node;
  }
}

class QueueAsLinkedList
{
  Qnode front;
  Qnode rear;
  boolean isEmpty()
  {
    return front==null;
  }
  
  void enqueue(Node tnode)
  {
    Qnode newNode = new Qnode(tnode);
    newNode.next=null;
    if(front==null)
    {  
        front=newNode;
    }  
    else
    {
      rear.next=newNode;
    }
    rear=newNode;
  }
  Qnode dequeue()
  {
    if(front==null)
    {  
      Qnode n=new Qnode();
      System.out.println("Queue underflow");
      return n;
    }
    else
    {
      Qnode temp = front;
      front = front.next;
      return temp;
    }
  }
}
class Qnode
{
  Node tnode;
  Qnode next;
  Qnode(Node node)
  {
    tnode = node;
  }
  Qnode()
  {

  }
}