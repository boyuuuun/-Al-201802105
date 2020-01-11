package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		int graph[][];
		int graph_length = -1;
		String[][] tmp = new String[100][]; 
		int size=0;
		
		// ���Ͽ��� graph �о� �迭�� ����
		File file1 = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\" 
				+ "2-2\\�˰���\\[Al]�ǽ�11����\\graph.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
		String line = "";

		while ((line = bufferReader1.readLine()) != null) {
			if(line.length()==1) {
				graph_length =  Integer.parseInt(line);
			} else {
				tmp[size++] = line.split(" ");
			}
		}
		
		graph = new int[graph_length][graph_length];
		System.out.println("** Graph **");
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				graph[i][j] = Integer.parseInt(tmp[i][j]);
				System.out.print(graph[i][j]+" ");
			}System.out.println();
		}System.out.println();
		
		//////////////////////////////////////////////////////////////
		
		Graph g = new Graph();
		
		//bfs
		System.out.println("** BreadthFirstSearch **");
		g.BFS(graph, 'r');
		g.print('b');
		System.out.println();
		g.reset();
		
		//dfs
		System.out.println("** DepthFirstSearch **");
		g.DFS(graph);
		g.print('d');
		System.out.println();
		
		
	}

}
