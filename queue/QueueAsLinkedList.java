class QueueAsLinkedList
{
  public static void main(String []args)
  {
    Queue q= new Queue();
    q.printQueue();
    System.out.println("empty? "+q.isEmpty());
    q.enqueue(24);
    q.printQueue();
    q.enqueue(231);
    q.printQueue();
    q.enqueue(87);
    q.printQueue();
    q.dequeue();
    q.printQueue();
    q.dequeue();
    q.printQueue();
    q.dequeue();
    q.printQueue();
    q.dequeue();
    q.printQueue();
    System.out.println("empty? "+q.isEmpty());

  }
}
class Queue
{
  Node front;
  Node rear;
  boolean isEmpty()
  {
    return front==null;
  }
  void printQueue()
  {
    System.out.println("_______________________________\n");
    if(isEmpty())
      System.out.println("Queue is empty");
    Node current = front;
    while(current!=null)
    {
      System.out.println(current.data+ " ");
      current=current.next;
    }
    System.out.println("_______________________________\n");
  }
  void enqueue(int val)
  {
    Node newNode = new Node(val);
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

    System.out.println(val + " is inqueued");  
  }
  Node dequeue()
  {
    if(front==null)
    {  
      Node n=new Node(-1);
      System.out.println("Queue underflow");
      return n;
    }
    else
    {
      Node temp = front;
      front = front.next;
      System.out.println(temp.data+ " Dequeued");
      return temp;
    }
  }
}
class Node
{
  int data;
  Node next;
  Node(int val)
  {
    data = val;
    next=null;
  }
}