package Sort_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		int maxsize = 10000;
		int[] array = new int[maxsize];
		int size=0;
		
		Sort sort = new Sort();
		
		// ���Ͽ��� ���� �о� �迭�� ����
		File file = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\2-2\\�˰���\\[Al]�ǽ�4����\\test_5000.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = "";
		
		while((line = br.readLine())!=null) {
			array[size] = (Integer.parseInt(line));
			size++;
		}
	
		sort.setSize(size);
		sort.setHeapSize(size);
		
		// ���� ����
		//sort.CountingSort(array);
		sort.MaxHeapSort(array);
		
		System.out.println("count: " + sort.count);
		System.out.println("count2: " + sort.count2);
		System.out.println("time1: "+ (sort.end-sort.start));
		System.out.println("time2: "+ (sort.end2-sort.start2));
		
		// ���� �Ϸ�� �迭�� ���Ϸ� ����
		BufferedWriter bw = new BufferedWriter(new FileWriter("MaxHeapSort_100.txt"));
		for(int i=0; i<size; i++) {
			bw.write(array[i] + "\n");
		}
	      bw.close();
	}

}
