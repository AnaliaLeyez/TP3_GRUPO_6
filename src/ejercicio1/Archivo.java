package ejercicio1;

public class Archivo {
	
	public static void verificarDniInvalido(String dni) throws DniInvalido {
       
        for (int i = 0; i < dni.length(); i++) {
           
            if (!Character.isDigit(dni.charAt(i))) {
            	DniInvalido dni1 = new DniInvalido();
                throw dni1;
            }
        }
    }

}
