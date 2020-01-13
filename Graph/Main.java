package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static int infinity = 999;

	public static void prim(int[][] c, int n, int[][] t, int vertex) { // c�迭�� �׷����� �������, n�� ������ ����, t�迭�� ����� �����迭, vertex�� ����
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

		for (int j = 0; j < dist.length; j++) { // dist���� 0�̾ƴ� �� �� ���� ���� ���� �ε����� ã�´�.
			if (dist[j] != 0 && dist[j] < dist[best]) {
				best = j;
			}
		}

		return best;
	}

	public static void main(String[] args) throws IOException {
		// ���Ͽ��� graph �о� �迭�� ����
		File file1 = new File(
				"C:\\Users\\user\\Desktop\\����\\�泲��\\" + "2-2\\�˰���\\[Al]�ǽ�12����\\graph_sample_prim_kruskal_tmp.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
//		String line="";
//		while ((line = bufferReader1.readLine()) != null) {
//			System.out.println(line);
//		}

		int N = Integer.parseInt(bufferReader1.readLine()); // ������ ����
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
