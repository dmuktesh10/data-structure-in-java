// class LinkedList
// {
//   Node head;
//   class Node
//   {
//     int data;
//     Node next;
//     Node(int val)
//     {
//       data = val;
//     }
//   }
// }
class LinkedList
{
  Node head;
  public static void main (String []args)
  {
    LinkedList list = new LinkedList();
    list.head = new Node(5);
    Node second = new Node(4);
    Node third = new Node(2);
    list.head.next = second;
    second.next = third;
    list.printList();
    list.push(43);
    list.printList();
    list.push_after_val(4, 122);
    list.printList();
    list.push_after_node(third, 643);
    list.printList();
    list.append(8888);
    list.printList();
    list.delete_val(2);
    list.printList();
    list.delete_node_at(3);
    list.printList();
    System.out.println(list.list_length());
    System.out.println("________________________");
    System.out.println(list.list_length_r(list.head));
    System.out.println("________________________");
    System.out.println(list.find(643));
    System.out.println("________________________");
    System.out.println(list.find_r(list.head,643));
    System.out.println("________________________");
    System.out.println(list.isPresent(4));
    System.out.println("________________________");
    System.out.println(list.isPresent_r(list.head,4));
    System.out.println("________________________");
    System.out.println(list.getNth(1).data);
    System.out.println("________________________");
    System.out.println(list.getNth_r(list.head,1).data);
    System.out.println("________________________");
    list.printList();
    System.out.println(list.getNthFromEnd(2).data);
    System.out.println("________________________");
    System.out.println(list.getNthFromEndUsingTwoPointers(2).data);
    System.out.println("________________________");

  }
  void printList()
  {
    Node current = head;
    System.out.println("________________________");
    while(current!=null)
    {
      System.out.print(" ");
      System.out.print(current.data);
      current = current.next;
    }
    System.out.println("\n________________________");
  }
  void push(int val)
  { //time complexity: O(1)
    Node new_node = new Node(val);
    new_node.next = head;
    head = new_node;
  }
  void push_after_val(int targetVal, int val)
  { //time complexity: O(n)
    Node current = head;
    while(current.data!=targetVal && current!=null)
      current=current.next;
    if(current==null)
    {
      System.out.println("Target not found.");
      return;
    }
    else
    {
      Node new_node = new Node(val);
      new_node.next = current.next;
      current.next = new_node;
    }
  }
  void push_after_node(Node targetNode, int val)
  { //time complexity: O(1)
    if(targetNode==null)
    {
      System.out.println("Target node can not be null");
      return;
    }
    else
    {
      Node newNode = new Node(val);
      newNode.next = targetNode.next;
      targetNode.next = newNode;
    }
  }
  void append(int val)
  { // time complexity: O(n) 
    Node current = head;
    Node newNode = new Node(val);
    newNode.next = null;
    if(current==null)
    {
      head= newNode;
      return;
    }
    while(current.next!=null)
      current = current.next;
    current.next = newNode;
  }
  void delete_val(int val)
  {
    Node current = head, previous = null;
    while(current.data!=val && current!=null)
    {
      previous = current;
      current = current.next;
    }
    if(current.data!=val)
    {
      System.out.println("Not not found");
      return;
    }
    else
    {
      if(previous==null)
        head = current.next;
      else
      {
        previous.next = current.next;
        current.next =null;
      }
    }
  }
  void delete_node_at(int target)
  {
    if(head==null)
    return;
    Node current = head;
    if(target==0)
    {
      head = head.next;
      return;
    }
    for(int i=0;i<(target-1)&&current!=null;i++)  
    {
      current=current.next;
    }
    if(current==null)
    {
      System.out.println("Target not found.");
      return;
    }
    else
    {
      current.next = current.next.next; 
    }
  }
  void delete_link_list()
  {
    head=null;
  }
  int list_length()
  {
    Node current = head;
    int counter = 0;
    while(current!=null)
    {
      current = current.next;
      counter++;
    }
    return counter;
  }
  int list_length_r(Node current)
  {
    if(current!=null)
      return (1+list_length_r(current.next));
    else
      return 0;
  }
  int find(int val)
  {
    Node current = head;
    int position = 0;
    while(current!=null)
    {
      if(current.data==val)
        break;
      else
      {
         current=current.next;
         position++;
      }
    }
    if(current!=null)
      return position;
    else
    {
      System.out.println("Node not found");
      return -1;
    }
  }
  int find_r(Node current, int val)
  {
    if(current==null)
    {
      System.out.println("Node not found.");
      return (-1*list_length());
    }
    if(current.data==val)
      return 0;
    else
      return (1 + find_r(current.next, val));
  }
  boolean isPresent(int val)
  {
    Node current = head;
    while(current!=null)
    {
      if(current.data==val)
        break;
      current=current.next;  
    }
    if(current==null)
      return false;
    else
      return true;
  }
  boolean isPresent_r(Node current, int val)
  {
    if(current==null)
      return false;
    if(current.data==val)
      return true;
    else
      return isPresent_r(current.next, val);
  }
  Node getNth(int position)
  {
    Node current = head;
    for(int i=0;i < position && current != null;i++)
    {
      current=current.next;
    }
    if(current==null)
    {
      System.out.println("Node not found");
    }
    return current;
  }
  Node getNth_r(Node current,int position)
  {
    if(current==null)
    {
      System.out.println("Node not found");
    }
    if(position==0)
      return current;
    else 
      return getNth_r(current.next, position-1);

  }
  Node getNthFromEnd(int position)
  {
    Node current = head;
    int len = list_length();
    int positionFromBegining=len-position;
    if(positionFromBegining<0)
      System.out.println("Invalid position.");
    for(int i=0;i<positionFromBegining;i++)
      current = current.next;
    return current;
  }
  Node getNthFromEndUsingTwoPointers(int position)
  {
    Node current,previous;
    int counter = 0;
    current=head;
    previous=head;
    while(current!=null)
    {
       counter++;
       current=current.next;
       if(counter >  position)
         previous=previous.next;         
    }
    return previous;
  }
}
class Node
{
  int data;
  Node next;
  Node(int val)
  {
      data = val;
  }
}