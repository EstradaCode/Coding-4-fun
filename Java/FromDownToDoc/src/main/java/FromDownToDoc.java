import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class FromDownToDoc {
    public static void main(String[] args) {
        File dirObjetivo = new File(System.getProperty("user.home") + "/Descargas");
        File dirDestino = new File(System.getProperty("user.home") + "/Documentos");
        if(!dirDestino.exists()){
            dirDestino.mkdirs();
        }
        File[] archivos = dirObjetivo.listFiles();
        ArrayList<File> pdfs = new ArrayList<File>();
        if (archivos != null) {
            for (File f : archivos) {
                if (f.isFile() && (f.getName().toLowerCase().endsWith(".pdf"))) {
                    pdfs.add(f);
                }
            }
        }
        for (File pdf : pdfs) {
            try {
                FileUtils.moveFileToDirectory(pdf, dirDestino, true);
                System.out.println("se movió un elemento al directorio!");
            } catch (IOException e) {
                System.out.println("no se pudo mover el elemento al directorio");
            }
        }
    }
}