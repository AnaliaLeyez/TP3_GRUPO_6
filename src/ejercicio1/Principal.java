package ejercicio1;

import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {

		Archivo filePersonas= new Archivo("src/ejercicio1/Personas.txt");
		
		Archivo archivoDestino = new Archivo("src/ejercicio1/Resultado.txt");

		
		TreeSet<Persona> personas= new TreeSet<Persona>();
		personas = filePersonas.leer();
		
		
		for(Persona p : personas)
		{
			System.out.println(p.toString());
		}
		
		
		if (!archivoDestino.existe()) {
		        archivoDestino.creaArchivo();
		}
		  
		   
	    archivoDestino.escribeLineas(personas);

	    System.out.println("Se ha copiado la informacion de la lista Personas al archivo Resultado.txt de forma exitosa.");				
		
	    archivoDestino.lee_lineas();
	}
}
