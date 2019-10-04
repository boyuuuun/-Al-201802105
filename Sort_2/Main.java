package Sort_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		int[] array = new int[10000];
		int size=0;
		Sort sort = new Sort();
		
		long startTime, endTime;
		
		// ���Ͽ��� ���� �о� �迭�� ����
		File file = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\2-2\\�˰���\\[Al]�ǽ�3����\\QuickSort_5000.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		String line = "";
		
		while((line = bufferReader.readLine())!=null) {
			array[size] = (Integer.parseInt(line));
			size++;
		}
	
		// ���� ����
		startTime = System.currentTimeMillis();
		//sort.MergeSort(array, 0, size-1);
		sort.QuickSort(array, 0, size-1);
		endTime = System.currentTimeMillis();
		
		System.out.println("Time: " + (endTime-startTime));
		
		// ���� �Ϸ�� �迭�� ���Ϸ� ����
		BufferedWriter bw = new BufferedWriter(new FileWriter("SortedArray_QuickSort_5000.txt"));
		for(int i=0; i<size; i++) {
			bw.write(array[i] + "\n");
		}
	      bw.close();
	}

}
