package mx.com.everis.tallerjava.archivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Edwin
 *
 */

/**
 * 
 * Ejercicio:
 * 	1.- Crear un archivo llamado holamundo.txt
 * 	2.- Crear la ruta /develop/projects/tallerjava
 * 	3.- Guardar el archivo holamundo.txt en la ruta anterior
 *  4.- Verificar si el archivo existe y si no existe crearlo.
 *  5.- Imprimir si es un archivo o un directorio
 *  6.- Leer una cadena desde consola y guardarla en el archivo holamundo.txt
 *  7.- Leer el archivo e imprimirlo en consola.
 *
 */

public class Archivo {
	
	public static void main (String [] args){
		BufferedReader entradaConsola = new BufferedReader (new InputStreamReader(System.in)); 
		String ruta = "./archivosTexto/";
		
		File dir = new File (ruta);
		dir.mkdirs(); 
		
		System.out.print("Escriba la cadena a guardar en el archivo de texto: ");
		String cadena;
		try {
			cadena = entradaConsola.readLine();
			File miArchivo = new File(ruta + "holamundo.txt");

			if(!miArchivo.exists()){
				try {
					miArchivo.createNewFile();
				} catch (IOException e) {
					System.out.print("Error al crear el archivo");
				}
			}
			
			if(miArchivo.isFile()){
				System.out.println("'miArchivo' es un archivo");
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(miArchivo, true));
				bw.write(cadena + "\n");		
				bw.close();
				
				FileReader fr = new FileReader(ruta + "holamundo.txt");
				BufferedReader brA = new BufferedReader(fr);
				
				System.out.println("El contendio del archivo es:");
				String contenido;
				while((contenido = brA.readLine())!=null){
					System.out.println(contenido);
				}		
				brA.close();
			}else{
				if(miArchivo.isDirectory()){
					System.out.println("'miArchivo' es un directorio");
				}
			}
			
			
		} catch (IOException e1) {
			System.out.print("Error al leer la cadena");
		} 
		
		

	}
	
	public void leerArchivo(){
		
	}

}
