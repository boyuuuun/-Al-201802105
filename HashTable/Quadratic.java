package HashTable;

public class Quadratic {
	public Object[] hash;
	private int length=97;
	private int size;
	private int del = -1;
	public int coll = 0;
	
	public Quadratic() {
		this.hash = new Object[this.length];
		this.size = 0;
	}
	
	public void Insert(int x) {
		int key = x%59;
		int i=0;
		while(hash[key]!=null) {
			i++;
			key = (key + i*i)%59;
			coll++;
		}
		hash[key] = x;
		this.size++;
	}
	
	public int Search(int x) {
		int key = x%59;
		int i=0;
		int key_tmp = key;
		while(hash[key]!=null) {
			if((int)hash[key]==x) 
				return key;
			else {
				i++;
				key = (key + i*i)%59;
				if(key == key_tmp) {
					break;
				}
			}
		}
		return -1;
	}
	
	public boolean Delete(int x) {
		int key = x%59;
		int i=0;
		int key_tmp = key;
		while(hash[key]!=null) {
			if((int)hash[key]==x) {
				hash[key] = del;
				this.size--;
				return true;
			} else {
				i++;
				key = (key + i*i)%59;
				if(key == key_tmp) {
					break;
				}
			}
		}
		
		return false;
	}
}
