package Sort_2;

public class Sort {
	
	// 퀵정렬
	public void QuickSort(int array[], int p, int r) {
		if(p<r) {
			int q = Partition(array, p, r);
			//int q = Partition_Random(array, p, r); 
			QuickSort(array, p, q-1);
			QuickSort(array, q+1, r);
		}
	}
	
	// 배열의 마지막 원소를 피봇으로
	public int Partition(int A[], int p, int r) {
		int pivot = A[r];
		int i=p-1;
		int j;
		
		for(j=p; j<r; j++) {
			if(A[j]<=pivot) {
				i++;
				swap(i, j, A);
			}
		}
		swap(i+1, r, A);

		return i+1;
	}
	
	// 랜덤하게 피봇 설정
	public int Partition_Random(int A[], int p, int r) {
		int randomIndex = (int)(Math.random()*(r-p+1)) + p;
		int pivot = A[randomIndex];
		int i=p;
		int j=r;
		
		do {
			   while(A[i] < pivot)
				   i++;
			   while(A[j] > pivot)
				   j--;
			   
			   if(i <= j) {
				   swap(i, j, A);
				   
				   if(A[i]==pivot)
					   j--;
				   else if(A[j]==pivot)
					   i++;
				   else {
					   i++;
					   j--;
				   }
			   } 
		   } while(i <= j);

		return i;
	}
	
	// 병합 정렬
	public void MergeSort(int[] array, int p, int r) {
		if(p<r) {
			int mid = (p+r)/2;
			MergeSort(array, p, mid); // 왼쪽 정렬
			MergeSort(array, mid+1, r); // 오른쪽 정렬
			Merge(array, p, mid, r); // 합쳐서 정렬
		}
	}
	
	public void Merge(int[] A, int p, int mid, int r) {
		int i = p;
		int j = mid + 1;
		int k=p;
		int B[] = new int[A.length]; // 정렬된 배열을 저장할 임의의 배열
		
		while(i<=mid && j<=r) {
			if(A[i]<A[j])
				B[k++] = A[i++];
			else
				B[k++] = A[j++];
		}
		while(i<=mid) // j가 r보다 큰 경우
			B[k++] = A[i++];
		while(j<=r) // i가 mid보다 큰 경우
			B[k++] = A[j++];
		
		
		System.arraycopy(B, p, A, p, k-p);
	}
	
	public void swap(int index1, int index2, int[] A) {
		int tmp = A[index1];
		A[index1] = A[index2];
		A[index2] = tmp;
	}
}
