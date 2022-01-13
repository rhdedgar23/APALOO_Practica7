import java.util.Random;

public class Libro extends Articulo {
	
	Random ran= new Random();
	String autor;
	int noPag;
	
	public Libro(){
		super();
		this.autor= "";
		setNoPagRandom();
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
	
	public void setNoPagRandom() {
		int pags= ran.nextInt(1001)+50;
		this.noPag= pags;
	}
	
	public void setNoPag(int noPag) {
		this.noPag= noPag;
	}
	
	public int getNoPag() {
		return noPag;
	}
}
