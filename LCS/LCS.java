package LCS;

public class LCS {
	private int dia = 0;
	private int top = 1;
	private int side = 2;

	public int maxsize = 100;
	public String[] result;
	public int res_size;
	
	public LCS() {
		result = new String[maxsize];
		res_size = 0;
	}
	
	public int lengthLCS(String[] x, String[] y, int x_length, int y_length) {
		int xl = x_length;
		int yl = y_length;
		int arrow[][] = new int[xl + 1][yl + 1]; 
		int lcs[][] = new int[xl + 1][yl + 1];

		for (int i = 0; i <= xl; i++) {
			lcs[i][0] = 0;
			arrow[i][0] = -1;
		}
		for (int i = 0; i <= yl; i++) {
			lcs[0][i] = 0;
			arrow[0][i] = -1;
		}

		for (int i = 1; i <= xl; i++) {
			for (int j = 1; j <= yl; j++) {
				if (x[i - 1].equals(y[j - 1])) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					arrow[i][j] = dia;
				} 
				else if (lcs[i - 1][j] >= lcs[i][j - 1]) {
					lcs[i][j] = lcs[i - 1][j];
					arrow[i][j] = top;
				} 
				else {
					lcs[i][j] = lcs[i][j - 1];
					arrow[i][j] = side;
				}
			}
		}

		printLCS(arrow, x, xl, yl);

		return lcs[xl][yl];
	}

	public void printLCS(int arrow[][], String[] x, int i, int j) {
		if (i == 0 || j == 0)
			return;

		if (arrow[i][j] == dia) {
			printLCS(arrow, x, i - 1, j - 1);
			this.result[res_size++] = x[i-1];
		} 
		else if (arrow[i][j] == top) {
			printLCS(arrow, x, i - 1, j);
		} 
		else if (arrow[i][j] == side) {
			printLCS(arrow, x, i, j - 1);
		}
	}

}
