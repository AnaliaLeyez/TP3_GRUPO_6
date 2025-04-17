package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Archivo {

	private String ruta;
	
	public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public Archivo() {
    	this.ruta = null;
    }
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public boolean creaArchivo()
	{
		if(ruta == null) {
    		System.out.println("Error, no se asignó ninguna ruta");
    		return false;
    	}
		
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			System.out.println("Error al querer crear el archivo");
			e.printStackTrace();
		}
		return false;	
	}
		
	public void escribeLineas(Persona nuevaPersona) {
		try {
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter buffer = new BufferedWriter(entrada);

			buffer.write(nuevaPersona.toString());
			buffer.newLine();
			buffer.close();
			entrada.close();
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir el archivo");
			e.printStackTrace();
		}
    }
	
	public void escribeLineas(TreeSet<Persona> listaPersonas) {
    	
		try {
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter buffer = new BufferedWriter(entrada);
			
			Iterator<Persona> it = listaPersonas.iterator();
			while(it.hasNext()) {
				Persona p = (Persona) it.next();
				buffer.write(p.toString());
				buffer.newLine();
			}
			
			buffer.close();
			entrada.close();
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir el archivo");
			e.printStackTrace();
		}
    }
		
	
	public TreeSet<Persona> leer()
	{
		BufferedReader buffReader;
		TreeSet<Persona> personas = new TreeSet<Persona>();
		
		try {
			buffReader = new BufferedReader(new FileReader(ruta)) ;
			String registro = buffReader.readLine();
			
			while(registro != null)
			{
				String[] atributos = registro.split("-"); // Me devuelve un array con el siguiente formato: String[3]{"nombre", "apellido", "DNI"}
				if(atributos.length == 3)
				{
					String nombre = atributos[0]; // Nombre
					String apellido = atributos[1]; // Apellido
					String dni = atributos[2]; // DNI
					
					try {
						Persona.verificarDniInvalido(dni);
						Persona.verificarNombreYApellido(nombre, apellido);
						if(!personas.add(new Persona(nombre, apellido, Integer.parseInt(dni))))
							System.out.println(nombre + " " + apellido + " ya se encuentra registrado\n");
					} 
					catch (DniInvalido e) 
					{
						System.out.println(nombre + " " + apellido + " DNI incorrecto");
						e.printStackTrace();
					}
					catch(NombreYApellidoInvalido e)
					{
						System.out.println(nombre + " " + apellido + "El nombre y apellido solo pueden contener letras\n");
						e.printStackTrace();
					}
				}
				
				registro = buffReader.readLine();
			}
			buffReader.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return personas;
		}
	
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
	
//////////////////////////////////////////Corchete clase/////////////////////////////////////////////////////////////////////	
}





