package Sort_3;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int size = array.length;

		Sort sort = new Sort();

		sort.setSize(size);
		sort.setHeapSize(size);
		
		// 원래 배열 출력
		System.out.println("ORIGINAL-------------------------");
		sort.PrintArray(array, size);

		// 정렬 실행
		sort.MaxHeapSort(array);;

		// 정렬된 배열 출력
		System.out.println("SORTED------------------------------");
		sort.PrintArray(array, size);
	}

}
