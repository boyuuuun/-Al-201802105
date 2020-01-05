package RedBlackTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[] insert = new int[1000];
		int size_insert=0;
		int[] search = new int[1000];
		int size_search=0;
		
		long startTime, endTime;
		
		// 파일에서 숫자 읽어 배열에 삽입
		File file = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\2-2\\알고리즘\\[Al]실습7주차\\Insert.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		String line = "";
		
		while((line = bufferReader.readLine())!=null) {
			insert[size_insert] = (Integer.parseInt(line));
			size_insert++;
		}
		
		// 파일에서 숫자 읽어 배열에 삽입
		File file2 = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\2-2\\알고리즘\\[Al]실습7주차\\Search.txt");
		FileReader fileReader2 = new FileReader(file);
		BufferedReader bufferReader2 = new BufferedReader(fileReader2);
		
		while((line = bufferReader2.readLine())!=null) {
			search[size_search] = (Integer.parseInt(line));
			size_search++;
		}
		
		//////////////////////////////////////////////////////////////////////////////
		RBT rbt = new RBT();
		
		for(int i=0; i<size_insert; i++) { //Insert
			rbt.insert(insert[i]);
		}
		
		System.out.println("---------------------------------------------------");
		startTime = System.currentTimeMillis();
		for(int i=0; i<size_search; i++) { //Search
			rbt.Search(search[i]);
		}
		endTime = System.currentTimeMillis();
		System.out.println("****Search Time: " + (endTime-startTime));
	}

}
