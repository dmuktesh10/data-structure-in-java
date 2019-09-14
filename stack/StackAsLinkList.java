class StackAsLinkList
{
  Node head;
  public static void main(String args[])
  {
    StackAsLinkList s=new StackAsLinkList();
    System.out.println(s.isEmpty());
    System.out.println(s.peek());
    s.printStack();
    s.push(23);
    System.out.println(s.isEmpty());
    s.printStack();
    s.push(53);
    System.out.println(s.peek());
    s.printStack();
    s.push(134);
    s.printStack();
    s.push(5654);
    s.printStack();
    s.pop();
    System.out.println(s.isEmpty());
    s.printStack();
    s.pop();
    s.printStack();
    s.pop();
    s.printStack();
    System.out.println(s.isEmpty());
    System.out.println(s.peek());

  }
  void printStack()
  {
    Node current =head;
    System.out.println("____________________");
    while(current!=null)
    {
      System.out.println(current.data);
      current=current.next;
    }
    System.out.println("____________________");
  }
  boolean isEmpty()
  {
    return (head==null);
  }
  void push(int val)
  {
    Node newNode = new Node(val);
    newNode.next=head;
    head=newNode;
    System.out.println(val+" pushed on stack");
  }
  int pop()
  {
    Node current = head;
    if(current==null)
    {
      System.out.println("Stack underflow");
      return -1;
    }
    else
    {
      System.out.println("Popped "+current.data);
      head=current.next;
      return current.data;
    }
  }
  int peek()
  {
    if(head==null)
      return -1;
    else 
      return head.data;
  }
}
class Node
{
  int data;
  Node next;
  Node(int val)
  {
    data=val;
  }
}