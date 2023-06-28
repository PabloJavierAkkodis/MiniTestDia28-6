package minitest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Minitest {
	
	/*
	 * ENUNCIADO DEL MINI-TEST
	 *  
	 *  En base a lo aprendido a lo largo del curso, debe generar un programa que se conecte a la siguiente API mediante el uso de REST. 
	 *  https://www.boredapi.com/api/activity
	 *  Y se deben generar (y almacenar) 10 actividades para realizar, las mismas se deben almacenar en un fichero de salida llamado “recomendación_hoy”
	 *  Agregarle también una prueba unitaría que valide si se conecto bien o no la api.
		
		
		Entregables:
		Codigo del proyecto
		Fichero de salida

	 * */
	
	public static void main(String[] args) {
		init();
	}
	
	
	private static void init() {
		StringBuilder resultado = new StringBuilder();
		
		for(int i = 0; i < 10; i++) {
			resultado.append((i+1) + ". " + ApiConnection.callApi() + "\n");
		}
		
		System.out.println(resultado);
		cargarFichero(resultado.toString());
		
	}

	
	
	
	public static void cargarFichero(String data) {
		try {
			//Declarar la ruta y el nombre de archivo con la extension del mismo
		String ruta = ".\\SALIDA\\recomendación_hoy.txt";
		//Inicializo la clase File que me permite crear el archivo.
		File archivo = new File(ruta);
		if(! archivo.exists())
		{
		archivo.createNewFile(); //utilizo el metodo createNewFile() para crear el archivo.
		System.out.println("Se ha generado el archivo.");	
		}
		FileWriter fw = new FileWriter(archivo); //El FileWriter es el encargado de habilitar la opción de escritura
		BufferedWriter bw = new BufferedWriter(fw); //BufferedWritter es el encargado de realizar la acción de escritura.
		bw.write(data);
		bw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
