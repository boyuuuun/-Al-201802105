package Sort_3;

public class Sort {
	private int size;
	public int heapSize;
	
	public int count=0;
	public int count2=0;
	public long start=0, end=0;
	public long start2=0, end2=0;
	
	// 힙 정렬
	public void BuildMaxHeap(int[] A) {
		for(int i=size/2-1; i>=0; i--) {
			MaxHeapify(A, i);
		}
	}

	public void MaxHeapify(int[] A, int i) {
		count+=1;
		int l=i*2+1; // 왼쪽 자식
		int r=i*2+2; // 오른쪽 자식
		int largest=i;
		
		if(l<getHeapSize()) {
			if(A[l]>A[i])
				largest = l;
			else 
				largest = i;
		}
		
		if(r<getHeapSize()) {
			if(A[r] > A[largest])
				largest=r;
		}
		
		if(largest!=i) {
			swap(i, largest, A);
			MaxHeapify(A, largest);
		}
	}

	public void MaxHeapSort(int[] A) {
		//start=System.currentTimeMillis();
		BuildMaxHeap(A);
		//end = System.currentTimeMillis();
		
		for(int i=size-1; i>0; i--) {
			swap(0, i, A);
			setHeapSize(getHeapSize()-1);
			//start2=System.currentTimeMillis();
			MaxHeapify(A, 0);
			//end2=System.currentTimeMillis();
			//count2+=1;
		}
	}

	// 계수 정렬
	public void CountingSort(int[] A) {
		int max = 0;
		for (int i = 0; i < size; i++) {// 배열에서 가장 큰 원소 찾기
			if (max < A[i])
				max = A[i];
		}

		int B[] = new int[size];
		int C[] = new int[max + 1];

		for (int i = 0; i < C.length; i++) { // 배열 C 초기화
			C[i] = 0;
		}

		for (int i = 0; i < size; i++) { // 빈도수에 따라 배열 C의 원소 정함
			C[A[i]]++;
		}

		for (int i = 1; i < C.length; i++) {
			C[i] = C[i] + C[i - 1];
		}

		for (int i = size - 1; i >= 0; i--) {
			B[C[A[i]] - 1] = A[i];
			C[A[i]]--;
		}

		System.arraycopy(B, 0, A, 0, size);
	}

	public void swap(int index1, int index2, int[]array) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	public int getHeapSize() {
		return this.heapSize;
	}
	
	public void setHeapSize(int hs) {
		this.heapSize = hs;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	// 배열 출력
	public void PrintArray(int[] A, int size) {
		for (int i = 0; i < size; i++) {
			System.out.println(A[i]);
		}
	}

}
