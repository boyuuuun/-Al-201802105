package Graph;

public class Graph2 {
	private int infinity = 999;

	public void prim(int[][] c, int n, int[][] t, int vertex) { // c배열은 그래프의 인접행렬, n은 정점의 개수, t배열은 연결된 간선배열, vertex는 시작
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
//		for(int i = 0; i 
//
// 0) {
//				best = i;
//				break;
//			}
//		}

	for(int j = 0;j<dist.length;j++)
	{ // dist에서 0이아닌 값 중 값이 가장 작은 인덱스를 찾는다.
		if (dist[j] != 0 && dist[j] < dist[best]) {
			best = j;
		}
	}

	return best;
}


//
////	public void Prim(Vertex[] g, int n, int r) {
////		int[] start = new int[n];
////		int[] end = new int[n];
////		
////		for(int i=0; i<n; i++) {
////			start[i] = r;
////			end[i] = g[]
////		}
////		
////	}
//	
//	public static int prim(int[][] graphs, int[] connected, int value, int count) { 
//		// 모든 노드를 방문하면 종료 
//		if (count == connected.length)
//			return value; 
//		int to = -1; 
//		int min = Integer.MAX_VALUE; 
//		for (int i = 0; i < connected.length; i++) {
//			if (connected[i] == 1) { 
//				// 현재 간선이 연결되어 있으면 처리 
//				for (int j = 0; j < graphs.length; j++) { 
//					// 현재 연결된 간선들과 연결된 노드중 최소값을 가지는 간선 
//					if (connected[j] == 0 && graphs[i][j] != 0 && min > graphs[i][j]) { 
//						to = j;
//						min = graphs[i][j]; 
//						} 
//					} 
//				} 
//			} 
//		connected[to] = 1;
//			// 최소값 간선을 선택 
//			value += min; 
//			// 최소값 추가
//			count++; 
//			// 연결된 간선 개수 추가 
//			return prim(graphs, connected, value, count); 
//			} 
}
