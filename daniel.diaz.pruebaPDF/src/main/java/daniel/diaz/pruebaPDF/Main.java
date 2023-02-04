package daniel.diaz.pruebaPDF;

import java.io.File;
import java.io.FileFilter;

public class Main {

	public static String pathCarpeta = System.getenv().get("VIAFIRMA_PATH");
	
	public static void main(String[] args) {

		Utils utils = new Utils();
		utils.logInfo("Comienza la aplicacion");

		File carpeta = new File(pathCarpeta);
		
		File[] archivos = carpeta.listFiles(filtro);
		
		if (archivos == null || archivos.length == 0) {
			utils.logInfo("No hay elementos dentro de la carpeta actual");
		}else {
			
			for (int i = 0; i < archivos.length; i++) {
				if(archivos[i].getName().endsWith(".pdf")) {
					utils.tratarDocumento(pathCarpeta + "/" + archivos[i].getName());
				}
			}
			
		}
		
	}
	
	/* Filtro para sacar solo los archivos de la carpeta */
	static FileFilter filtro = new FileFilter() {
	    public boolean accept(File arch) {
	        return arch.isFile();
	    }
	};
}
