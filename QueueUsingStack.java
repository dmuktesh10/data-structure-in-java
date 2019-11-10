import java.util.*;
public class QueueUsingStack
{
     Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
  public static void main(String []args)
  {
 
    QueueUsingStack q = new QueueUsingStack();
    q.enQueue(1);  
    q.enQueue(2);  
    q.enQueue(3);  
  
    System.out.println(q.deQueue());  
    System.out.println(q.deQueue()); 
    System.out.println(q.deQueue()); 
  }

  void enQueue(int val)
  {
    s1.push(val);
  }
  int deQueue()
  {
    if(s2.isEmpty())
    {
      while(!s1.isEmpty())
      {
        int p=s1.pop();
        s2.push(p);
      }
    }
    return s2.pop();
  }
}