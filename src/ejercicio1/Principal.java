package ejercicio1;

import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {

		Archivo filePersonas= new Archivo("src/ejercicio1/Personas.txt");
		TreeSet<Persona> personas= new TreeSet<Persona>();
		personas = filePersonas.leer();
		
		for(Persona p : personas)
		{
			System.out.println(p.toString());
		}
	}
}
