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
		
		// 파일에서 숫자 읽어 배열에 삽입
		File file = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\2-2\\알고리즘\\[Al]실습3주차\\QuickSort_5000.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		String line = "";
		
		while((line = bufferReader.readLine())!=null) {
			array[size] = (Integer.parseInt(line));
			size++;
		}
	
		// 정렬 실행
		startTime = System.currentTimeMillis();
		//sort.MergeSort(array, 0, size-1);
		sort.QuickSort(array, 0, size-1);
		endTime = System.currentTimeMillis();
		
		System.out.println("Time: " + (endTime-startTime));
		
		// 정렬 완료된 배열을 파일로 저장
		BufferedWriter bw = new BufferedWriter(new FileWriter("SortedArray_QuickSort_5000.txt"));
		for(int i=0; i<size; i++) {
			bw.write(array[i] + "\n");
		}
	      bw.close();
	}

}
