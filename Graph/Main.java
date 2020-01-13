package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static int infinity = 999;

	public static void prim(int[][] c, int n, int[][] t, int vertex) { // c배열은 그래프의 인접행렬, n은 정점의 개수, t배열은 연결된 간선배열, vertex는 시작
		// 정점
		int[] from = new int[n]; // 현재 부분 배열이 어디로부터 연결된지 표시하는 from배열 생성
		int[] dist = new int[n]; // 현재 부분 배열의 각 정점마다의 가중치를 표시
		for (int i = 0; i < n; i++) { // 최초 시작정점은 첫번째 정점임으로 vertex으로 초기화
			from[i] = vertex;
			dist[i] = c[vertex][i];
		}
		for (int i = 0; i < n - 1; i++) { // n-1은 연결될 간선의 수
			int best = isBest(dist); // dist배열중 0을 제외한 최소값을 가진 원소의 인덱스
			t[0][i] = from[best] + 1; // 가중치가 가장 적은 간선을 선택해서 넣어준다. +1은 정점이 1부터 시작해서 넣음.
			t[1][i] = best + 1;
			dist[best] = 0; // 부분 트리로 선택된 정점까지의 가중치는 0으로 변경
			for (int j = 1; j < n; j++) { // dist배열과 from배열의 최신화
				if (c[best][j] < dist[j]) { // 최근에 선택된 정점에 인접한 정점에 가중치와 기존 dist배열과 비교
					from[j] = best;
					dist[j] = c[best][j];
				}
			}
		}
	}

	public static int isBest(int[] dist) { // dist배열중 0을 제외한 최소값을 가진 원소의 인덱스를 반환하는 메소드
		int best = 0;

		for (int j = 0; j < dist.length; j++) { // dist에서 0이아닌 값 중 값이 가장 작은 인덱스를 찾는다.
			if (dist[j] != 0 && dist[j] < dist[best]) {
				best = j;
			}
		}

		return best;
	}

	public static void main(String[] args) throws IOException {
		// 파일에서 graph 읽어 배열에 삽입
		File file1 = new File(
				"C:\\Users\\user\\Desktop\\보윤\\충남대\\" + "2-2\\알고리즘\\[Al]실습12주차\\graph_sample_prim_kruskal_tmp.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
//		String line="";
//		while ((line = bufferReader1.readLine()) != null) {
//			System.out.println(line);
//		}

		int N = Integer.parseInt(bufferReader1.readLine()); // 정점의 개수
		int[][] graph = new int[N][N];
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph.length; j++) {
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

		int[][] t = new int[2][graph.length - 1];
		prim(graph, graph.length, t, 0);
		for (int i = 0; i < t[0].length; i++) {
			System.out.println(t[0][i] + " " + (t[1][i]));
		}

	}
}
