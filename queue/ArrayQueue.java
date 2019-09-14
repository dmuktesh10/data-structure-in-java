class ArrayQueue
{
  int front, rear;
  int size, capacity;
  int ar[];
  public static void main(String []args)
  {
    ArrayQueue q=new ArrayQueue(10);
    q.printQueue();
    System.out.println("fornt: "+q.front()+ " rear: "+q.rear());
    System.out.println("empty?: "+q.isEmpty()+ " full?: "+q.isFull());
    q.enqueue(4);
    q.printQueue();
    q.enqueue(23);
    q.printQueue();
    q.enqueue(86);
    q.printQueue();
    q.deque();
    q.printQueue();
    q.deque();
    q.printQueue();
    q.deque();
    q.printQueue();
    q.deque();
    q.printQueue();


  }
  ArrayQueue(int capacity)
  {
    this.capacity = capacity;
    front=this.size=0;
    rear=capacity-1;
    ar=new int[this.capacity];
  } 
  boolean isFull()
  {
    return(size==capacity);
  }
  boolean isEmpty()
  {
    return size==0;
  }
  void printQueue()
  {
    System.out.println("________________________\n");
    for(int i=front;i<=rear;i++)
    {
      System.out.print(ar[i] + " ");
    }
    System.out.println("________________________\n");
  }
  void enqueue(int val)
  {
    if(isFull())
    {
      System.out.println("Queue overflow");
    }
    else
    {
      rear=(rear+1)%capacity;
      ar[rear]=val;
      size+=1;
      System.out.println(val+" is enqueued.");
    }
  }
  int deque()
  {
    if(isEmpty())
    {  
      System.out.println("Queue overflow");
      return -1;
    }
    int val=ar[front];
    front+=1;
    size-=1;
    return val;
  }
  int front()
  {
    if(isEmpty())
      return -1;
    return ar[front];
  }
  int rear()
  {
    if(isEmpty())
      return -1;
    return ar[rear];
  }
}