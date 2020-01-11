package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private Vertex[] vertex;
	
	public Graph() {
		this.vertex = null;
	}
	
	public void BFS(int[][] graph, char s) {
		this.vertex = new Vertex[graph.length];
		for(int i=0; i<vertex.length; i++) {
			vertex[i] = new Vertex((char)('r'+i));
			
			if(vertex[i].name == s) {
				vertex[i].color = "gray";
				vertex[i].d = 0;
			}
		}
		
		Queue<Character> q = new LinkedList<Character>();
		
		q.add(s);
		
		while(!q.isEmpty()) {
			char u_name = q.remove();
			Vertex u = vertex[u_name-'r'];
			int[] g = graph[u_name -'r'];
			
			for(int i=0; i<g.length; i++) {
				if(g[i] == 1) {
					Vertex v = vertex[i];
					if(v.color.equals("white")) {
						v.color = "gray";
						v.d = u.d+1;
						v.pi = u;
						q.add(v.name);
					}
				}
				u.color = "black";
			}
		}
	}
	
	public void DFS(int[][] graph) {
		this.vertex = new Vertex[graph.length];
		for(int i=0; i<vertex.length; i++) {
			vertex[i] = new Vertex((char)('r'+i));
		}
		
		int time = 0;
		
		for(int i=0; i<vertex.length; i++) {
			if(vertex[i].color.equals("white")) {
				DFS_visit(graph, vertex[i], time);
			}
		}
 	}
	
	private int DFS_visit(int[][] graph, Vertex u, int t) {
		int time = t+1;
		u.d = time;
		u.color = "gray";
		int[] g = graph[u.name -'r'];
		
		for(int i=0; i<g.length; i++) {
			if(g[i]==1) {
				Vertex v = vertex[i];
				if(v.color.equals("white")) {
					v.pi = u;
					time = DFS_visit(graph, v, time);
				}
			}
		}
		
		u.color = "black";
		time = time+1;
		u.f = time;
		return time;
	}
	
	
	public void print(char g) {
		for(int i=0; i<vertex.length; i++) {
			if(g=='b')  //bfs 출력
				System.out.println(vertex[i].name + " : " + vertex[i].d);				
			else if(g=='d')  //dfs 출력
				System.out.println(vertex[i].name + " : " + vertex[i].d + " , " + vertex[i].f);
		}
	}
	
	public void reset() {
		this.vertex = null;
	}
	
}
