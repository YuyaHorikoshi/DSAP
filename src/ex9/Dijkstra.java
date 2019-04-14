package ex9;

import java.util.ArrayList;

public class Dijkstra {
  final static int INFINITY = 999; // これを無限大とする

  private class Node {
    int key;
    int label;
    boolean isFixed;
    ArrayList<Edge> edges = new ArrayList<Edge>();
	public int weight;

    public Node(int key) {
      this.key = key;
      this.label = INFINITY;
      this.isFixed = false;
    }

    public void addEdge(Edge edge) {
      edges.add(edge);
    }
  }

  private class Edge {
    Node to;    // 隣接するノード
    int weight; // エッジの重み

    public Edge(Node to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  Node start;
  ArrayList<Node> nodes = new ArrayList<Node>();

  public Dijkstra() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);

    node1.addEdge(new Edge(node2, 20));
    node1.addEdge(new Edge(node3, 10));
    node1.addEdge(new Edge(node4, 15));
    node2.addEdge(new Edge(node1, 20));
    node2.addEdge(new Edge(node4, 10));
    node3.addEdge(new Edge(node1, 10));
    node3.addEdge(new Edge(node4, 20));
    node3.addEdge(new Edge(node5, 10));
    node4.addEdge(new Edge(node1, 15));
    node4.addEdge(new Edge(node2, 10));
    node4.addEdge(new Edge(node3, 20));
    node5.addEdge(new Edge(node3, 10));
    node5.addEdge(new Edge(node4, 20));

    nodes.add(node1);
    nodes.add(node2);
    nodes.add(node3);
    nodes.add(node4);
    nodes.add(node5);

    start = nodes.get(0);
    start.label = 0;
  }

  public static void main(String[] args) {
    Dijkstra graph = new Dijkstra();
    
      // ここを作る
      // ダイクストラ法のアルゴリズムを実装する
      // 全てのノードを確定ラベルにする
    	while(graph.nodes.isEmpty()){
    		Node num=graph.nodes.remove(0);
    		for(Edge e:num.edges){
    			Node to=e.to;
    			int weight=num.weight+e.weight;
    			if(weight<to.weight){
    				graph.nodes.remove(to);
    				to.label=weight;
    				graph.nodes.add(to);
    			
    			}
    		}
    	} 
    for (Node node : graph.nodes) {
      System.out.println("Node" + node.key + ": " + node.label);
    }
  }
}

