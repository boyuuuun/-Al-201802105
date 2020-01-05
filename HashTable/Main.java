package HashTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private static int maxsize = 10000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] insert = new int[maxsize];
		int insertSize = 0;
		int[] delete = new int[maxsize];
		int deleteSize = 0;
		int[] search = new int[maxsize];
		int searchSize = 0;

		// ���Ͽ��� ���� �о� �迭�� ����
		File file1 = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\" 
				+ "2-2\\�˰���\\[Al]�ǽ�8����\\Data1.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
		String line = "";

		while ((line = bufferReader1.readLine()) != null) {
			insert[insertSize] = (Integer.parseInt(line));
			insertSize++;
		}

		// ���Ͽ��� ���� �о� �迭�� ����
		File file2 = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\" 
				+ "2-2\\�˰���\\[Al]�ǽ�8����\\Data2.txt");
		FileReader fileReader2 = new FileReader(file2);
		BufferedReader bufferReader2 = new BufferedReader(fileReader2);

		while ((line = bufferReader2.readLine()) != null) {
			delete[deleteSize] = (Integer.parseInt(line));
			deleteSize++;
		}

		// ���Ͽ��� ���� �о� �迭�� ����
		File file3 = new File("C:\\Users\\user\\Desktop\\����\\�泲��\\" 
				+ "2-2\\�˰���\\[Al]�ǽ�8����\\Data3.txt");
		FileReader fileReader3 = new FileReader(file3);
		BufferedReader bufferReader3 = new BufferedReader(fileReader3);

		while ((line = bufferReader3.readLine()) != null) {
			search[searchSize] = (Integer.parseInt(line));
			searchSize++;
		}
		
/////////////////////////////////////////////////////////////////////////////
		//Linear ht = new Linear();
		Quadratic ht = new Quadratic();
		//Double ht = new Double();
		
		for(int j=0; j<insertSize; j++) {
			int data = insert[j];
			ht.Insert(data);
		}
		System.out.println("�浹Ƚ��: "+ht.coll);
		System.out.println("--------------------------------------");
		for(int j=0; j<97; j++) {
			Object data = ht.hash[j];
			if(data==null)
				continue;
			System.out.println("H["+j+"]: "+data);
		}
		System.out.println("--------------------------------------");
		
		
		for(int j=0; j<deleteSize; j++) {
			int data = delete[j];
			boolean res = ht.Delete(data);
			if(res) {
				System.out.println(data+": ���� ����");
			} else {
				System.out.println(data+": ���� ����");
			}
		}
		
		System.out.println("--------------------------------------");
		
		for(int j=0; j<searchSize; j++) {
			int data = search[j];
			int res = ht.Search(data);
			if(res>=0) {
				System.out.println(data+": �˻� ����");
			} else {
				System.out.println(data+": �˻� ����");
			}
		}
		
/////////////////////////////////////////////////////////////////////////////
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("Search_test.txt"));
		for(int j=0; j<searchSize; j++) {
			int data = search[j];
			int key = ht.Search(data);
			if(key == (-1))
				continue;
			bw.write(data + " " + key + "\n");
		}
		bw.close();
	
		
	}
}
