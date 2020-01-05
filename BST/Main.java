package BST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int input[] = new int[10000];
		int delete[] = new int[10000];
		int size=0;
		int size_delete=0;
		BST bst = new BST();
		
		long startTime, endTime;
		
		File fileInsert = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\2-2\\알고리즘\\[Al]실습6주차\\Insert.txt");
		FileReader fileReaderInsert = new FileReader(fileInsert);
		BufferedReader brInsert = new BufferedReader(fileReaderInsert);
		String line = "";
		
		while((line = brInsert.readLine())!=null) {
			input[size++]  = Integer.parseInt(line);
		}
		
		// Insert
		startTime = System.currentTimeMillis();
		for(int i=0; i<size; i++) { //insert
			bst.insert(input[i]);
		}
		endTime = System.currentTimeMillis();
		System.out.println("****Insert Time: " + (endTime-startTime));
		int deep = bst.printChildCount(bst.root);
		System.out.println("*****Insert Deep: "+ deep);
		
		bst.reset();

		// Median Insert
		startTime = System.currentTimeMillis();
		int input_sort[] = new int[input.length];
		int s = size;
		System.arraycopy(input, 0, input_sort, 0, size);
		Arrays.sort(input_sort, 0, size);
		while(s>0) {
			int m = s/2;
			bst.insert(input_sort[m]);
			System.arraycopy(input_sort, m+1, input_sort, m, s-m-1);
			input_sort[s-1]=0;
			 s--;
		}
		endTime = System.currentTimeMillis();
		System.out.println("*****Median Time: " + (endTime-startTime));
		int deep2 = bst.printChildCount(bst.root);
		System.out.println("*****Insert Deep: "+ deep2);
		
		
		File fileDelete = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\2-2\\알고리즘\\[Al]실습6주차\\Delete.txt");
		FileReader fileReaderDelete = new FileReader(fileDelete);
		BufferedReader brDelete = new BufferedReader(fileReaderDelete);
		
		while((line = brDelete.readLine())!=null) {
			delete[size_delete++]  = Integer.parseInt(line);
		}
		
		// Delete
		for(int i=0; i<size_delete; i++) {
			bst.delete(delete[i]);
		}
	}
}
