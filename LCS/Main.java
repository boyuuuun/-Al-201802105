package LCS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String x="";
		String y="";
		int xl = -1;
		int yl = -1;
		
		File file1 = new File("C:\\Users\\user\\Desktop\\보윤\\충남대\\" 
				+ "2-2\\알고리즘\\[Al]실습10주차\\LCS_Data.txt");
		FileReader fileReader1 = new FileReader(file1);
		BufferedReader bufferReader1 = new BufferedReader(fileReader1);
		String line = "";

		int c = 0;
		while ((line = bufferReader1.readLine()) != null) {
			switch (c) {
			case 0:
				xl=(Integer.parseInt(line));
				c++;
				break;
			case 1:
				x = line;
				c++;
				break;
			case 2:
				yl=(Integer.parseInt(line));
				c++;
				break;
			case 3:
				y=line;
				c++;
				break;
				
			default:
				break;
			}
		}

		LCS l = new LCS();
		
		String[] _x = x.split("");
		String[] _y = y.split("");
		
		l.lengthLCS(_x, _y, xl, yl);
		String[] res = l.result;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("Output.txt"));
		for(int i=0; i<l.res_size; i++) {
			bw.write(res[i]);
		}
		bw.close();
	}

}
