import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
	
	ArrayList <Libro> elemLib= new ArrayList<Libro>();
	ArrayList <Integer> aux= new ArrayList<Integer>();
	
	Scanner teclado= new Scanner(System.in);
	
	
	public void insertaLibro() {//inserta
		
		Libro lib= new Libro();
		elemLib.add(lib);
		
		System.out.println("Por favor ingresa titulo del libro:");
		String titulo= teclado.nextLine();
		
		System.out.println("Por favor ingresa el autor del libro:");
		String autor= teclado.nextLine();
		
		lib.setName(titulo);
		lib.setAutor(autor);
		lib.setTipo();
		lib.setCostoRandom();
	}
	
	public void eliminaLibro(String nomLib) {//
		
		

	}
	
	public void despliegaLibros() {
		
	}
	
	public void ordenaLibCosto() {//ordena los libros por costo usando MergeSort
		int ini=0;
		int fin= elemLib.size();
		MergeSort(ini, fin);
	}
	
	public void ordenaLibAutor() {
		
		
				
	}
	
	public void MergeSort(int ini, int fin) {
		int mitad;
		
		if(ini<fin) {
			mitad= (ini+fin)/2;
			MergeSort(ini, mitad);
			MergeSort(mitad+1, fin);
			IntercalaCosto(ini, mitad, fin);
		}
	}
	
	public void IntercalaCosto(int ini, int mitad, int fin) {
		int k, i, j;
		i= ini;
		j= mitad+1;
		k= ini;
		
		while(i<=mitad && j<=fin) {
			if(elemLib.get(i).getCosto() <= elemLib.get(j).getCosto()) {
				aux.set(k, elemLib.get(i).getCosto());
				k++;
				i++;
			}
			else {
				aux.set(k, elemLib.get(i).getCosto());
				k++;
				j++;
			}
		}
		
		if(i>mitad) {
			for(int h=j; h<=fin; h++) {
				aux.set(k, elemLib.get(h).getCosto());
				k++;
			}
		}
		else {
			for(int h=i; h<=mitad; h++) {
				aux.set(k, elemLib.get(h).getCosto());
				k++;
			}
		}
		
		for(int h=ini; h<=fin; h++) {
			elemLib.get(h).setCosto(aux.get(h));
		}
	}
	
	
	public void quickSort(int ini, int fin) {
		
		int pivote, i, j, aux;
		
		if(ini<fin) {
			
		}
		
	}
}

	
