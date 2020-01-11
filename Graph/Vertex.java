package Graph;

public class Vertex {
	public String color;
	public int d;
	public int f;
	public Vertex pi;
	public char name;
	
	public Vertex(char ver) {
		this.color = "white";
		this.d = -1;
		this.f = -1;
		this.pi = null;
		this.name = ver;
	}
}

