import java.util.Random;

public class Articulo {
	
	Random ran= new Random();
	String tipo, nombre;
	int costo;
	
	public Articulo() {
		this.tipo= "";
		this.nombre= "";
		this.costo=0;
	}
	
	public void setTipo() {//cultura, cientifico, terror, novela, generado aleatoriamente
		
		int genero= ran.nextInt(5)+1;
		
		switch(genero) {
		case 1: this.tipo= "cultura"; break;
		case 2: this.tipo= "cientifico"; break;
		case 3: this.tipo= "terror"; break;
		case 4: this.tipo= "novela"; break;
		}
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setName(String nombre) {
		this.nombre= nombre;
	}
	
	public String getName() {
		return nombre;
	}
	
	public void setCosto(int costo) {
		this.costo= costo;
	}
	
public void setCostoRandom() {
		
		int precio= ran.nextInt(1201)+25;
		this.costo= precio;
	}
	
	public int getCosto() {
		return costo;
	}
}
