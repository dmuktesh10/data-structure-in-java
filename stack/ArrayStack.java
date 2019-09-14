class ArrayStack
{
  int top;
  static final int MAX=1000;
  int a[] = new int [MAX];
  ArrayStack()
  {
    top=-1;
  }
  boolean isEmpty()
  {
    return (top<0);
  }
  boolean push(int val)
  {
    if(top==(MAX-1))
    {
      System.out.println("Stack overflow.");
      return false;
    }
    else
    {
      a[++top]=val;
      System.out.println(val+" is pushed on stack");
      return true;
    }  
  }
  int pop()
  {
    if(top<0)
    {
      System.out.println("Stack underflow");
      return -1;
    }
    else
    {
      int x=a[top--];
      return x;
    }
  }
  int peek()
  {
    if(top<0)
    {
      System.out.println("Empty stack");
      return -1;
    }
    else
      return a[top];
  }
  void printStack()
  {
    int temp_top=top;
    System.out.println("___________________");
    while(temp_top>=0)
    {
      System.out.println(a[temp_top]);
      temp_top--;
    }
    System.out.println("___________________");
  } 
  public static void main(String [] args)
  {
    ArrayStack s= new ArrayStack();
    s.printStack();
    s.push(4);
    s.printStack();
    s.push(34);
    s.printStack();
    s.push(52);
    s.printStack();
    System.out.println(s.peek());
    s.printStack();
    System.out.println(s.pop());
    s.printStack();
  }
}
