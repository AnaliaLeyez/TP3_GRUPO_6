package ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
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
}
