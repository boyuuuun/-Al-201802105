package LinearSelect;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a = new int[100];
		
		for(int i=0; i<a.length; i++) {
			boolean e = false;
			int x = (int)(Math.random()*a.length)+1;
			for(int j=0; j<i; j++) {
				if(x==a[j]) {
					e=true;
					break;
				}
			}
			if(e==true) {
				i--;
				continue;
			} else {
				a[i] = x;
				System.out.print(a[i]+" ,");
			}
			
		}
		System.out.println("------------------------------------");
		
		
		AverageLinearSelect s = new AverageLinearSelect();
		
//		int rr = s.linearSelect(a, 0, a.length-1, 24-1);
//		System.out.println(rr);
		
		for(int i=1; i<a.length+1; i++) {
			int[] b = new int[a.length];
			System.arraycopy(a, 0, b, 0, b.length);
			int r = s.select(b, 0, b.length-1, i-1);
			System.out.println(r);

		}
		
		
	}

}
