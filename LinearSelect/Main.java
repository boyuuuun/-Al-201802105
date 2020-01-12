package LinearSelect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int maxsize = 10000;
		int[] array = new int[maxsize];
		int size=0;
		
		AverageLinearSelect als = new AverageLinearSelect();
		
		// ���Ͽ��� ���� �о� �迭�� ����
		File file = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\2-2\\�˰���\\[Al]�ǽ�5����\\test_5000.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = "";
		
		while((line = br.readLine())!=null) {
			array[size] = (Integer.parseInt(line));
			size++;
		}
		
		System.out.print("rank: ");
		Scanner sc = new Scanner(System.in);
		int rank = sc.nextInt();
		//int als_test = als.select(array, 0, size-1, rank-1);
		int als_test = als.linearSelect(array, 0, size, rank);
		System.out.println("result: " + als_test);
	}

}
