package HashTable;

public class Linear {
	public Object[] hash;
	private int length=97;
	private int size;
	private int del = -1;
	public int coll = 0;
	
	public Linear() {
		this.hash = new Object[this.length];
		this.size = 0;
	}
	
	public void Insert(int x) {
		int key = x%59;
		
		while(hash[key]!=null) {
			key = (key+1)%59;
			coll++;
		}
		hash[key] = x;
		size++;
	}
	
	public int Search(int x) {
		int key = x%59;
		int key_tmp = key;
		while(hash[key]!=null) {
			if((int)hash[key]==x) 
				return key;
			else {
				key = (key+1)%59;
				if(key == key_tmp) {
					break;
				}
			}
		}
		return -1;
	}
	
	public boolean Delete(int x) {
		int key = x%59;
		int key_tmp = key;
		while(hash[key]!=null ) {
			if((int)hash[key]==x) {
				hash[key] = del;
				size--;
				return true;
			} else {
				key = (key+1)%59;
				if(key == key_tmp) {
					break;
				}
			}
		}
		
		return false;
	}
	
 }
