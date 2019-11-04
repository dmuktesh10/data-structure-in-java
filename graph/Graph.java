import java.io.*;
import java.util.*;
public class Graph
{
  int V;
  LinkedList<Integer>[] adjList;
  Graph(int vertex_count)
  {
    V = vertex_count;
    adjList = new LinkedList[vertex_count];
    for(int i=0;i<V;i++)
    {
      adjList[i] = new LinkedList();
    }
  }

  void addEdge(int source, int dest)
  {
    adjList[source].add(dest);   
  }

  void BFS(int source) // BFS from given source
  {
    boolean [] visited = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    visited[source] = true;
    queue.add(source);
    while(!queue.isEmpty())
    {
      source = queue.poll();
      System.out.print(source+ " ");
      Iterator<Integer> itr = adjList[source].listIterator();
      while(itr.hasNext())
      {
        int n = itr.next();
        if(!visited[n])
        {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public static void main(String[] args)
  {
    Graph g = new Graph(4);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.addEdge(2,0);
    g.addEdge(2,3);
    g.addEdge(3,3);
    g.BFS(2);
  }
}