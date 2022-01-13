import java.util.Random;

public class Articulo {
	
	Random ran= new Random();
	String tipo, nombre;
	int costo;
	
	public Articulo() {
		setTipoR();
		this.nombre= "";
		setCostoRandom();
	}
	
	public void setTipoR() {//cultura, cientifico, terror, novela, generado aleatoriamente
		
		int genero= ran.nextInt(5)+1;
		
		switch(genero) {
		case 1: this.tipo= "Cultura"; break;
		case 2: this.tipo= "Cientifico"; break;
		case 3: this.tipo= "Terror"; break;
		case 4: this.tipo= "Novela"; break;
		//default: System.out.println("La opcion que ingresaste no es valida"); break;
		}
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
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
