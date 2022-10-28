import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		int puntuacion_seguridad = 0;
		System.out.println("Bienvenido al validador de contrasenas");
		String clave=pedirCadena("Introduce la clave que deseas validar");
		String[] division_auxiliar = clave.split(clave); 
		ArrayList <String> clave_dividida = new ArrayList<String>();
		
		for (int i = 0; i < division_auxiliar.length; i++) {
			clave_dividida.add(division_auxiliar[i]);
		}
		
		puntuacion_seguridad +=  longitud_cadena(clave_dividida);
		puntuacion_seguridad +=  identificador_letra(clave_dividida);

	}
	private static int identificador_letra(ArrayList <String> clave) {
		for (String caracter :clave) {
			try {
				Integer.parseInt (caracter);
			} catch (Exception ex) {
				return 1;
			}
		}
		return 0;
	}
	
	
	private static int longitud_cadena(ArrayList <String> clave) {
		int puntuacion = 0;
		if(clave.size()<=6) {
			puntuacion= 0;
		}
		
		if(clave.size()==7 || clave.size()==8) {
			puntuacion= 1;
		}
		
		if(clave.size()>=9 && clave.size()<=12) {
			puntuacion= 2;
		}
		
		if(clave.size()>12) {
			puntuacion= 3;
		}
		return puntuacion;
	}
	
	
	private static String pedirCadena(String mensaje) {

		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);

		return sc.nextLine();
	}

}
