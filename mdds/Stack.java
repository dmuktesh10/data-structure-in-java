package mdds;
public class Stack
{
  Node head;

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