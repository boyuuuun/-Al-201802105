package Sort_3;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int size = array.length;

		Sort sort = new Sort();

		sort.setSize(size);
		sort.setHeapSize(size);
		
		// ���� �迭 ���
		System.out.println("ORIGINAL-------------------------");
		sort.PrintArray(array, size);

		// ���� ����
		sort.MaxHeapSort(array);;

		// ���ĵ� �迭 ���
		System.out.println("SORTED------------------------------");
		sort.PrintArray(array, size);
	}

}
