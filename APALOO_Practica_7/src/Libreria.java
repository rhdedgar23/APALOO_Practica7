/* *********************DOCUMENTACION********************************
* Programa o tarea: Practica 7. 
* version: Martes 11 de enero 2022
* autor:  Legaspi Díaz Yael Janai
* descripción: 
* datos de entrada: ---
* datos de salida:          
***************************************************************************** */
import java.util.ArrayList;
import java.util.Scanner;
//import javax.sound.sampled.SourceDataLine;

public class Libreria {
	
	ArrayList <Libro> elemLib= new ArrayList<Libro>();
	ArrayList <Integer> aux= new ArrayList<Integer>();
	
	Scanner teclado= new Scanner(System.in);
	
	
	public void insertaLibro() {//inserta un nuevo objeto "lib" al ArrayList "elemLib"; el usuario ingresa el titulo y el autor; el tipo y el costo se generan aleatoriamente. 
		
		Libro lib= new Libro();
		elemLib.add(lib);
		
		System.out.println("Por favor ingresa el titulo del libro:");
		String titulo= teclado.nextLine();
		
		System.out.println("Por favor ingresa el autor del libro:");
		String autor= teclado.nextLine();
		
		lib.setName(titulo);
		lib.setAutor(autor);
		lib.setTipoR();
		lib.setCostoRandom();
	}
	
	public void eliminaLibro() {//invoca metodo "buscaLibTitulo" para eliminar algun objeto "lib" del ArrayList "elemLib".
		System.out.println("Ingresa el titulo del libro que deseas eliminar: ");
		String titulo= teclado.nextLine();
		
		int pos= buscaLibTitulo(titulo);
		
		elemLib.remove(pos);
	}
	
	public void despliegaLibros(int i) {//despliega la informacion de los libros guardados en ArrayList "elemLib" en forma de tabla.
		
		if(i==0) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.format("|%-35s |%-20s|%-20s|%-20s|%-20s|\n", "Titulo", "Autor", "Numero de paginas", "Tipo", "Costo (MXN)");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		}
		
		if(i<elemLib.size()) {
		System.out.format("|%-35s |%-20s|%-20d|%-20s|%-20d|\n", elemLib.get(i).getTitulo(), elemLib.get(i).getAutor() ,elemLib.get(i).getNoPag(), elemLib.get(i).getTipo(), elemLib.get(i).getCosto());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");	
		i++;
		despliegaLibros(i);
		}
	}
	
	public void ordenaLibCosto() {//ordena los obejetos del ArrayList "elemLib" por costo usando MergeSort.
		
		int ini=0;
		int fin= elemLib.size()-1;
		MergeSort(ini, fin);
	}
	
	public void ordenaLibAutor() {//ordena libros por autor usando QuickSort.
		int ini=0;
		int fin= elemLib.size()-1;
		quickSortAutor(ini, fin);

	}
	
	public void ordenaLibTitulo() {//ordena libros por titulo usando QuickSort.
		int ini=0;
		int fin= elemLib.size()-1;
		quickSortTitulo(ini, fin);
	}

	public int buscaLibTitulo(String titulo) {//ordena libros por titulo usando QuickSort y despues busca el titulo usando busqueda recursiva binaria comparando strings
		int ini=0, pos;
		int fin= elemLib.size()-1;
		String tituloDos= titulo;
		
		quickSortTitulo(ini, fin);
		
		pos= busBinRecLibTitulo(ini, fin, tituloDos);
		
		despliegaLibro(pos);
		
		return pos;
	}
	
	public int busBinRecLibTitulo(int ini, int fin, String titulo) {//busqueda recursiva binaria comparando strings
		int mitad;
		
		if(ini>fin) {
			return elemLib.size();
		}
		else {
			mitad= (ini+fin)/2;
			//System.out.println(mitad);
			
			if(elemLib.get(mitad).getName().compareTo(titulo)==0) {
				return(mitad);
			}
			else {
				if((elemLib.get(mitad).getName().compareTo(titulo))<0) {
					return busBinRecLibTitulo(mitad+1, fin, titulo);
				}
				else {
					return busBinRecLibTitulo(ini, mitad-1, titulo);
				}
			}	
		}
	}
	
	public void despliegaLibro(int i) {//despliega la informacion del libro con indice "i" pasado como parametro
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.format("|%-35s |%-20s|%-20s|%-20s|%-20s|\n", "Titulo", "Autor", "Numero de paginas", "Tipo", "Costo");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.format("|%-35s |%-20s|%-20d|%-20s|%-20d|\n", elemLib.get(i).getTitulo(), elemLib.get(i).getAutor() ,elemLib.get(i).getNoPag(), elemLib.get(i).getTipo(), elemLib.get(i).getCosto());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");		
	}
	
	public void MergeSort(int ini, int fin) {//ordena recursivamente por el metodo MergeSort
		int mitad;
		
		if(ini<fin) {
			mitad= (ini+fin)/2;
			MergeSort(ini, mitad);
			MergeSort(mitad+1, fin);
			IntercalaCosto(ini, mitad, fin);
		}
	}

	public void inicializAux(){
		int b=0;
		for(int i=0; i<elemLib.size();i++){
			aux.add(b);
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
				aux.set(k, elemLib.get(j).getCosto());
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
	
	public void quickSortAutor(int ini, int fin) {
		int  i, j;
		Libro pivote=new Libro();
		Libro aux= new Libro();
		
		if(ini<fin) {
			pivote=elemLib.get(ini);
			i= ini+1;
			j=fin;
			
			while(i<=j) {
				while(i<=fin && elemLib.get(i).getAutor().compareTo(pivote.getAutor())<=0) {
					i++;
				}
				
				while(elemLib.get(j).getAutor().compareTo(pivote.getAutor())>0) {
					j--;
				}
				
				if(i<j) {
					aux=elemLib.get(i);
					elemLib.set(i, elemLib.get(j));
					elemLib.set(j, aux);
				}
			}
			
			aux=elemLib.get(j);
			elemLib.set(j, pivote);
			elemLib.set(ini, aux);
			quickSortAutor(ini, j-1);
			quickSortAutor(j+1, fin);
		}
	}
	
	public void quickSortTitulo(int ini, int fin) {
		int  i, j;
		Libro pivote=new Libro();
		Libro aux= new Libro();
		
		if(ini<fin) {
			pivote=elemLib.get(ini);
			i= ini+1;
			j=fin;
			
			while(i<=j) {
				while((i<=fin) && (elemLib.get(i).getName().compareTo(pivote.getName())<=0)) {
					i++;
				}
				
				while((elemLib.get(j).getName().compareTo(pivote.getName()))>0) {
					j--;
				}
				
				if(i<j) {
					aux= elemLib.get(i);
					elemLib.set(i, elemLib.get(j));
					elemLib.set(j, aux);
				}
			}
			
			aux=elemLib.get(j);
			elemLib.set(j, pivote);
			elemLib.set(ini, aux);
			quickSortTitulo(ini, j-1);
			quickSortTitulo(j+1, fin);
		}
	}

	public void ordenaTipo(){
		System.out.println("Ingresa el numero de la opcion de tipo de libros que quieres ver:");
		System.out.println("1. Cultura");
		System.out.println("2. Cientifico");
		System.out.println("3. Terror");
		System.out.println("4. Novela");
		
		int tip;
		
		tip= teclado.nextInt();
		
		switch(tip){
		case 1:	despliegaTipo(1,0); break;
		case 2: despliegaTipo(2,0); break;
		case 3: despliegaTipo(3,0); break;
		case 4: despliegaTipo(4,0); break;
		default: System.out.println("No es una opcion valida.");
		}
	}

	public void despliegaTipo(int tip, int i){
		if(i==0) {
			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			System.out.format("|%-35s |%-20s|%-20s|%-20s|%-20s|\n", "Titulo", "Autor", "Numero de paginas", "Tipo", "Costo");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		}
		
		if(tip==1){
			if(i<elemLib.size() && elemLib.get(i).getTipo().compareTo("Cultura")==0) {
				System.out.format("|%-35s |%-20s|%-20d|%-20s|%-20d|\n", elemLib.get(i).getTitulo(), elemLib.get(i).getAutor() ,elemLib.get(i).getNoPag(), elemLib.get(i).getTipo(), elemLib.get(i).getCosto());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");	
				i++;
				despliegaTipo(tip,i);
			}
		}
		else if(tip==2){
			if(i<elemLib.size() && elemLib.get(i).getTipo().compareTo("Cientifico")==0) {
				System.out.format("|%-35s |%-20s|%-20d|%-20s|%-20d|\n", elemLib.get(i).getTitulo(), elemLib.get(i).getAutor() ,elemLib.get(i).getNoPag(), elemLib.get(i).getTipo(), elemLib.get(i).getCosto());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");	
				i++;
				despliegaTipo(tip,i);
			}
		}
		else if(tip==3){
			if(i<elemLib.size() && elemLib.get(i).getTipo().compareTo("Terror")==0) {
				System.out.format("|%-35s |%-20s|%-20d|%-20s|%-20d|\n", elemLib.get(i).getTitulo(), elemLib.get(i).getAutor() ,elemLib.get(i).getNoPag(), elemLib.get(i).getTipo(), elemLib.get(i).getCosto());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");	
				i++;
				despliegaTipo(tip,i);
			}
		}
		else if(tip==4){
			if(i<elemLib.size() && elemLib.get(i).getTipo().compareTo("Novela")==0) {
				System.out.format("|%-35s |%-20s|%-20d|%-20s|%-20d|\n", elemLib.get(i).getTitulo(), elemLib.get(i).getAutor() ,elemLib.get(i).getNoPag(), elemLib.get(i).getTipo(), elemLib.get(i).getCosto());
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");		
				i++;
				despliegaTipo(tip, i);
				}
		}
		else{
			System.out.println("No es una opcion valida");
		}
	}
}



	

