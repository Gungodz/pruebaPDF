package daniel.diaz.pruebaPDF;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Utils {
	static Logger log = Logger.getLogger(Main.class.getName());
	
	/* Muestra un mensaje de informacion por el log */
	public void logInfo (String mensaje) {
		guardarLog(mensaje, 1);
	}
	
	/* Guarda unn mensaje de log en un archivo txt */
	private void guardarLog (String mensaje, int gravedad) {
		FileHandler fh; 

	    try {    
	    	fh = new FileHandler("src/main/resources/Log/Log.txt", true);
	        log.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        switch (gravedad) {
			case 1:
				log.info(mensaje);
				break;

			case 2:
				log.severe(mensaje);
				break;
			}  
	        
	        fh.flush();
	        fh.close();

	    } catch (SecurityException e) { 
	    	log.severe("Error durante la ejecucion: " + e.toString());
	    } catch (IOException e) {  
	    	log.severe("Error durante la ejecucion: " + e.toString());
	    }  
	}
	
	/* Annade una pagina al documento */
	public void tratarDocumento (String urlDocumento) {
		try {  
			File documento = new File(urlDocumento);
			PDDocument document = PDDocument.load(documento);
			
			guardarLog("Tratando documento", 1);
			
			document.addPage(new PDPage());
			
			document.save(urlDocumento);
			
			document.close();
			
			guardarLog("Pagina annadida", 1);

		} catch (IOException e) {  
	    	guardarLog("Error al tratar el documento: " + urlDocumento, 2);
	    } 
	}
	
}
