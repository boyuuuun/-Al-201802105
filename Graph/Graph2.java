package Graph;

public class Graph2 {
	private int infinity = 999;

	public void prim(int[][] c, int n, int[][] t, int vertex) { // c�迭�� �׷����� �������, n�� ������ ����, t�迭�� ����� �����迭, vertex�� ����
																// ����
		int[] from = new int[n]; // ���� �κ� �迭�� ���κ��� ������� ǥ���ϴ� from�迭 ����
		int[] dist = new int[n]; // ���� �κ� �迭�� �� ���������� ����ġ�� ǥ��
		for (int i = 0; i < n; i++) { // ���� ���������� ù��° ���������� vertex���� �ʱ�ȭ
			from[i] = vertex;
			dist[i] = c[vertex][i];
		}
		for (int i = 0; i < n - 1; i++) { // n-1�� ����� ������ ��
			int best = isBest(dist); // dist�迭�� 0�� ������ �ּҰ��� ���� ������ �ε���
			t[0][i] = from[best] + 1; // ����ġ�� ���� ���� ������ �����ؼ� �־��ش�. +1�� ������ 1���� �����ؼ� ����.
			t[1][i] = best + 1;
			dist[best] = 0; // �κ� Ʈ���� ���õ� ���������� ����ġ�� 0���� ����
			for (int j = 1; j < n; j++) { // dist�迭�� from�迭�� �ֽ�ȭ
				if (c[best][j] < dist[j]) { // �ֱٿ� ���õ� ������ ������ ������ ����ġ�� ���� dist�迭�� ��
					from[j] = best;
					dist[j] = c[best][j];
				}
			}
		}
	}

	public static int isBest(int[] dist) { // dist�迭�� 0�� ������ �ּҰ��� ���� ������ �ε����� ��ȯ�ϴ� �޼ҵ�
		int best = 0;
//		for(int i = 0; i 
//
// 0) {
//				best = i;
//				break;
//			}
//		}

	for(int j = 0;j<dist.length;j++)
	{ // dist���� 0�̾ƴ� �� �� ���� ���� ���� �ε����� ã�´�.
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
//		// ��� ��带 �湮�ϸ� ���� 
//		if (count == connected.length)
//			return value; 
//		int to = -1; 
//		int min = Integer.MAX_VALUE; 
//		for (int i = 0; i < connected.length; i++) {
//			if (connected[i] == 1) { 
//				// ���� ������ ����Ǿ� ������ ó�� 
//				for (int j = 0; j < graphs.length; j++) { 
//					// ���� ����� ������� ����� ����� �ּҰ��� ������ ���� 
//					if (connected[j] == 0 && graphs[i][j] != 0 && min > graphs[i][j]) { 
//						to = j;
//						min = graphs[i][j]; 
//						} 
//					} 
//				} 
//			} 
//		connected[to] = 1;
//			// �ּҰ� ������ ���� 
//			value += min; 
//			// �ּҰ� �߰�
//			count++; 
//			// ����� ���� ���� �߰� 
//			return prim(graphs, connected, value, count); 
//			} 
}
