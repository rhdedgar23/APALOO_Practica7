/* *********************DOCUMENTACION********************************
* Programa o tarea: Practica 7. 
* version: Martes 11 de enero 2022
* autor:  Legaspi Díaz Yael Janai
* descripción: 
* datos de entrada: ---
* datos de salida:          
***************************************************************************** */
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Libreria lib=new Libreria();
		menu(lib);

	}
	
	public static void menu(Libreria lib) {
		try (Scanner Teclado = new Scanner(System.in)) {
			int opcion;
			
			do {
				System.out.println("        Menu       ");
				System.out.println("1) Dar de alta libro ");
				System.out.println("2) Dar de baja libro ");
				System.out.println("3) Despliega por costo ");
				System.out.println("4) Despliega por autor ");
				System.out.println("5) Depliega por tipo");
				System.out.println("6) Busca por titulo");
				System.out.println("7) Salir\n");
				System.out.println("Por favor ingresa el numero de la opcion deseada del menu: ");
				
				opcion= Teclado.nextInt(); 
				
				switch (opcion){
				case 1: 
					lib.insertaLibro();
					System.out.println("Listo! Has dado de alta tu libro.\n");
					break;
				case 2: 
					lib.eliminaLibro();
					System.out.println("Listo! Se ha eliminado el libro indicado.\n");
					break;
				case 3:
					lib.inicializAux();
					lib.ordenaLibCosto();
					lib.despliegaLibros(0);
					break;	
				case 4: 
					lib.ordenaLibAutor();
					lib.despliegaLibros(0);
					break;
				case 5:
					lib.ordenaTipo();
					break;
				case 6:
					System.out.println("Por favor ingresa el titulo del libro que buscas: ");
					String enter= Teclado.nextLine();
					System.out.println(enter);
					String title= Teclado.nextLine();
					lib.buscaLibTitulo(title);
					break;
				case 7:
					System.out.println("TERMINA PROGRAMA");
					System.exit(0);
					break;
				default:
					System.out.println("La opcion que has seleccionado no es la correcta");
					break;
				}
			}while(opcion!=7);
		}
	}


}
