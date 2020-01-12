package LinearSelect;

public class AverageLinearSelect {
	public int select(int[] A, int p, int r, int n) {
		if (p == r) // 배열 A에 원소가 하나인 경우
			return A[p];

		int q = partition(A, p, r, r);

		if (n < q)
			return select(A, p, q - 1, n);
		else if (n == q)
			return A[q];
		else
			return select(A, q + 1, r, n);

	}

	public int linearSelect(int[] A, int p, int r, int n) {
		if (r - p + 1 <= 5) {
			sort(A, p, r);
			return A[n];
		}

		int p_tmp = p;
		int m[] = new int[r];
		int m_size = 0;
		for (int i = 0; i < r; i++) {
			if ((r - p_tmp + 1) >= 5) {
				sort(A, p_tmp, p_tmp + 4);
				m[i] = A[p_tmp + 2];
				p_tmp += 5;
				m_size++;
			} else {
				if(p_tmp>r)
					break;
				sort(A, p_tmp, r);
				m[i] = A[p_tmp + (r - p_tmp) / 2];
				m_size++;
				break;
			}
		}

		int median = linearSelect(m, 0, m_size - 1, m_size / 2);

		int medianIndex = 0;
		for (int i = p; i <= r; i++)
			if (A[i] == median) {
				medianIndex = i;
				break;
			}
		int q = partition(A, p, r, medianIndex);

		if (n < q)
			return linearSelect(A, p, q - 1, n);
		else if (n == q)
			return A[q];
		else
			return linearSelect(A, q + 1, r, n);
	}

	public void sort(int[] A, int p, int r) {
		int i, j;
		for (i = p + 1; i < r+1; i++) {
			int key = A[i];
			for (j = i - 1; j >= p && A[j] > key; j--) {
				A[j + 1] = A[j];
			}
			A[j + 1] = key;
		}
	}

	public int partition(int[] A, int p, int r, int pivotIndex) {
		if (pivotIndex != r)
			swap(r, pivotIndex, A);

		int pivot = A[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (A[j] <= pivot) {
				i++;
				swap(i, j, A);
			}
		}
		swap(i + 1, r, A);

		return i + 1;
	}

	public void swap(int index1, int index2, int[] A) {
		int tmp = A[index1];
		A[index1] = A[index2];
		A[index2] = tmp;
	}

}
