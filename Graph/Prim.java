package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;




public class Prim {
	int cost;
	int[] key;
	int[] included;
	int v;// no of vertices
	Vertex[] vertex;

	public Prim(int v) {
		this.v = v;
		vertex = new Vertex[v];
		for (int i = 0; i < v; i++) {
			vertex[i] = new Vertex(i);
		}
		cost = 0;
		key = new int[v];
		for (int i = 0; i < v; i++)
			key[i] = Integer.MAX_VALUE;
		included = new int[v];
	}

	int extractMin() {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < v; i++) {
			if (included[i] == 0 && key[i] < min) {
				min = key[i];
				index = i;
			}
		}
		return index;
	}

	void Prim(int[][] weight, int start) {
		key[start] = 0;
		vertex[start].parent = null;
		int u = extractMin();
		while (u != -1) {
			cost += key[u];
			for (Vertex ver : vertex[u].adj) {
				if (included[ver.data] == 0 && weight[u][ver.data] < key[ver.data]) {
					ver.parent = vertex[u];
					key[ver.data] = weight[u][ver.data];
				}
			}
			included[u] = 1;
			u = extractMin();
		}
		System.out.println("Cost: " + cost);
	}

	
	public static void main(String[] args) throws IOException {
		int infinity = 999;
		// 파일에서 graph 읽어 배열에 삽입
		File file1 = new File(
				"C:\\Users\\user\\Desktop\\보윤\\충남대\\" + "2-2\\알고리즘\\[Al]실습12주차\\graph_sample_prim_kruskal_tmp.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
//				String line="";
//				while ((line = bufferReader1.readLine()) != null) {
//					System.out.println(line);
//				}

		int N = Integer.parseInt(bufferReader1.readLine()); // 정점의 개수
		int[][] graph = new int[N][N];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				graph[i][j] = infinity;
			}
		}
		for (int i = 0; i < N; i++) {
			String line = bufferReader1.readLine();
			String[] linetmp = line.split(" ");
			int s = Integer.parseInt(linetmp[0]);
			int e = Integer.parseInt(linetmp[1]);
			int eg = Integer.parseInt(linetmp[2]);
			graph[s][e] = eg;
		}

		
		Prim g = new Prim(N);
//		for (int i = 0; i < e; i++) {
//			int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
//			weight[a][b] = w;
//			weight[b][a] = w;
//			g.addEdge(a, b);
//		}
		int start = 0;
		g.Prim(graph, start);
//		sc.close();
	}

}
