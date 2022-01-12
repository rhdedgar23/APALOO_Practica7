
public class Libro extends Articulo {
	
	String autor;
	int noPag;
	
	public Libro(){
		super();
		this.autor= "";
		this.noPag= 0;
	}
	
	public void setTitulo(String tipo) {
		this.tipo= tipo;
	}
	
	public String getTitulo() {
		return nombre;
	}
	
	public void setAutor(String name) {
		this.autor= name;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setNoPag(int noPag) {
		this.noPag= noPag;
	}
	
	public int getNoPag() {
		return noPag;
	}
}
