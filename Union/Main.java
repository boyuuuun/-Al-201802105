package Union;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private static int maxsize = 10000;

	public static void main(String[] args) throws IOException {

		// 파일에서 숫자 읽어 배열에 삽입
		File file1 = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\" + "2-2\\알고리즘\\[Al]실습9주차\\data1.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
		String line="";
		
		String data1[];
		String linetmp = "";
		int data1_size;
		String union1[][] = new String[maxsize][2];
		int union1_size=0;
		String find1[] = new String[maxsize];
		int find1_size=0;
		
		while ((line = bufferReader1.readLine()) != null) {
			int l = line.length();
			if(l==1) {
				find1[find1_size++] = line;
			} else if(l==3) {
				union1[union1_size++] = line.split(" ");
			} else {
				linetmp = line;
			}
		}
		
		data1 = linetmp.split(" ");
		data1_size = data1.length;
		
//		for(int i=0; i<data1_size; i++) {
//			System.out.print(data1[i]+ " ");
//		}System.out.println();
//		for(int i=0; i<union1_size; i++) {
//			System.out.println(union1[i][0] + " " + union1[i][1]);
//		}
//		System.out.println("--------------------");
//		for(int i=0; i<find1_size; i++) {
//			System.out.print(find1[i]+ " ");
//		}
		
		// 파일에서 숫자 읽어 배열에 삽입 //////////////////////////////////////////
		File file2 = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\" + "2-2\\알고리즘\\[Al]실습9주차\\data2.txt");
		FileReader fileReader2 = new FileReader(file2);
		BufferedReader bufferReader2 = new BufferedReader(fileReader2);

		String data2[];
		String linetmp2 = "";
		int data2_size;
		String union2[][] = new String[maxsize][2];
		int union2_size=0;
		String find2[] = new String[maxsize];
		int find2_size=0;
		
		while ((line = bufferReader2.readLine()) != null) {
			int l = line.length();
			if(l==1) {
				find2[find2_size++] = line;
			} else if(l==3) {
				union2[union2_size++] = line.split(" ");
			} else {
				linetmp = line;
			}
		}
		
		data2 = linetmp.split(" ");
		data2_size = data2.length;

		///////////////////////////////////////////////////////////////////////////////////
		
		Union u = new Union();

		/*
		 * for(int i=0; i<data1_size; i++) { u.MakeSet(data1[i]); }
		 * 
		 * for(int i=0; i<data1_size; i++) { System.out.print(u.sets[i].data + " ");
		 * }System.out.println("\n-----------------------"); for(int i=0; i<union1_size;
		 * i++) { System.out.println(union1[i][0] + " " + union1[i][1]);
		 * }System.out.println("-----------------------");
		 * 
		 * for(int i=0; i<union1_size; i++) { u.union(union1[i][0], union1[i][1]); }
		 * //////////////////////////////////////////////////////////////////
		 * BufferedWriter bw = new BufferedWriter(new FileWriter("data1_res.txt"));
		 * for(int i=0; i<data1_size; i++) { String w = u.print(data1[i]); bw.write(w +
		 * "\n"); } bw.close();
		 */	
		////////////////////////////////////////////////////////////////////////////////////


		for(int i=0; i<data2_size; i++) {
			u.MakeSet(data2[i]);
		}
		
		for(int i=0; i<data2_size; i++) {
			System.out.print(u.sets[i].data + " ");
		}System.out.println("\n-----------------------");
		for(int i=0; i<union2_size; i++) {
			System.out.println(union2[i][0] + " " + union2[i][1]);
		}System.out.println("-----------------------");
		
		for(int i=0; i<union2_size; i++) {
			u.union(union2[i][0], union2[i][1]);
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("data2_res.txt"));
		for(int i=0; i<data2_size; i++) {
			String w = u.print(data2[i]);
			bw.write(w + "\n");
		}
		bw.close();
	}

}
