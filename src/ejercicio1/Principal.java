package ejercicio1;


public class Principal {

	public static void main(String[] args) {

		Archivo archivo = new Archivo("src/Personas.txt");

		if(archivo.existe())
		{
			System.out.println("Trabajamos con archivo ya existente");
		}
		else
		{
			System.out.println("Se crea el archivo...");
			archivo.creaArchivo();
		}
		
		Persona p = new Persona();
		archivo.escribeLineas(p);
		
	}

}
