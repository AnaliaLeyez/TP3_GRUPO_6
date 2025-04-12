package ejercicio1;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

	private String nombre;
	private String apellido;
	private int dni;

	public Persona() {
		this.nombre = "";
		this.apellido = "";
		this.dni = 99999999;
	}
	
	public Persona(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	//Entiendo que con el dni debería ser suficiente, ya que no puede haber dos personas con el mismo dni. 
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	//Contiúo con la misma lógica, que con hashcode. 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);

	}

	//Compara el apellido y ordena. 
	@Override
	public int compareTo(Persona o) {
		return this.apellido.compareTo(o.apellido);
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni;
	}

	
	public static void verificarDniInvalido(String dni) throws DniInvalido {
	       
        for (int i = 0; i < dni.length(); i++) {
           
            if (!Character.isDigit(dni.charAt(i))) {
            	DniInvalido dni1 = new DniInvalido();
                throw dni1;
            }
        }
    }

	
}
