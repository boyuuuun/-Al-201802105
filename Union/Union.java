package Union;

public class Union {
	private int maxSize = 10000;
	private int size;
	public Set sets[];
	
	public class Set {
		public String data;
		private String parent;
		private int rank;
		
		public Set(String data) {
			this.data = data;
			this.parent = data;
			this.rank = 0;
		}
	}
	
	public Union() {
		sets = new Set[maxSize];
		size = 0;
	}
	
	public void MakeSet(String data) {
		Set input = new Set(data);
		sets[size++] = input;
	}
	
	public void union(String x, String y) {
		String xr = FindSet(x);
		String yr = FindSet(y);
		
		if(xr==null || yr==null) {
			System.out.println("error!");
			return ;
		}
		
		if(xr.equals(yr)) {
			System.out.println(x+ " & " + y + " : root is equal");
			return ;
		}
		/////////////////////////
		int index_xr=0, index_yr=0;
		for(int i=0; i<this.size; i++) {
			if(sets[i].data.equals(xr))
				index_xr = i;
			if(sets[i].data.equals(yr))
				index_yr = i;
		}
		
		int rank_xr = sets[index_xr].rank;
		int rank_yr = sets[index_yr].rank;
		
		if(rank_xr > rank_yr) {
			sets[index_yr].parent = xr;
		} else {
			sets[index_xr].parent = yr;
			if(rank_xr == rank_yr) {
				sets[index_yr].rank++;
			}
		}
	}
	
	public String FindSet(String data) {
		int i = 0, index = -1;
		for(i=0; i<size; i++) {
			String tmp = sets[i].data;

			if(tmp.equals(data)) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("\n'"+data+ "' 존재하지 않음");
			return null;
		}
		
		String r = sets[index].parent;
		if(r.equals(data)) {
			//System.out.println(data+"_root(equal): "+ data);
			return data;
		} else {
			r = FindSet(r);
			//System.out.println(data+"_newroot: "+ r);
			return r;
		}
	}
	
	public String print(String data) {
		int index = -1;
		for(int i=0; i<this.size; i++) {
			if(sets[i].data.equals(data)) {
				index = i;
				break;
			}
		}

		if(index == -1) {
			System.out.println("error");
			return null;
		}
		
		String parent = sets[index].parent;
		String root = FindSet(data);
		String prt = data + ' ' + parent + ' ' + root;
		System.out.println(prt);
		return prt;
	}

}
