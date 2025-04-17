package ejercicio1;

import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {

		Archivo filePersonas = new Archivo("src/ejercicio1/Personas.txt");

		Archivo archivoDestino = new Archivo("src/ejercicio1/Resultado.txt");

		TreeSet<Persona> personas = new TreeSet<Persona>();

		if (!filePersonas.existe()) {
			// Si no nos dieran el archivo personas ya creado y quisieramos armarla:
			System.out.println("Creando archivo Personas...");
			filePersonas.creaArchivo();

			if (filePersonas.creaArchivo()) {
				System.out.println("Se creó correctamente el archivo Personas");

				//cargo personas
				  Persona p1 = new Persona(); 
				  Persona p2 = new Persona("Pedro", "Ramirez",30444222); 
				  Persona p3 = new Persona("P3dr0", "Ramire3",30444222); 
				  Persona p4 = new Persona("Juan", "Perez",55003426); 
				//intento cargar peronsa repetida y persona con error en nombre/apellido
				  filePersonas.escribePersonas(p1);
				  filePersonas.escribePersonas(p2);
				  filePersonas.escribePersonas(p2); 
				  filePersonas.escribePersonas(p3); 
				  filePersonas.escribePersonas(p4); 

				personas = filePersonas.leer();
			} else {
				System.out.println("Error al crear el archivo Personas");
			}

		} else {
			personas = filePersonas.leer();
		}

		if (!archivoDestino.existe()) {
			System.out.println("Creando archivo Resultado...");
			if (archivoDestino.creaArchivo()) {
				System.out.println("Se creó correctamente el archivo Resultado");
			} else {
				System.out.println("Error al crear el archivo Resultado");
			}
		}

		if (!personas.isEmpty() && archivoDestino.existe()) {

			if (archivoDestino.escribeLineas(personas)) {
				System.out.println(
						"Se ha copiado la informacion de la lista Personas al archivo Resultado.txt de forma exitosa.");
				archivoDestino.lee_lineas();
			} else {
				System.out.println("Eror, no se ha podido copiar la informacion al archivo Resultado.txt");
			}

		} else if (personas.isEmpty()) {
			System.out.println("No hay personas para informar en resultado");
		}

	}
}
