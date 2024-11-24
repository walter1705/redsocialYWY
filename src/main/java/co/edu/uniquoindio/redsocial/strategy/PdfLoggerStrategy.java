package co.edu.uniquoindio.redsocial.strategy;

import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.service.ILoggerStrategy;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.nio.file.Path;

public class PdfLoggerStrategy implements ILoggerStrategy {
    private static final String extension = ".pdf";

    @Override
    public void write(String data, String fecha, String path, String titulo, Usuario usuario) {
        try {
            String filePath = conseguirNombreUnicoPath(path);
            PdfWriter writer = new PdfWriter(filePath+".pdf");
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            document.add(new Paragraph(titulo));
            document.add(new Paragraph(fecha));
            document.add(new Paragraph("Reporte realizado por: " + usuario.getUsername()));
            document.add(new Paragraph("Información del reporte: "));
            document.add(new Paragraph(data));
            document.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String conseguirNombreUnicoPath(String filePath) {
        Path path = Path.of(filePath+extension);
        String withoutExtension = filePath;
        int contador = 1;
        while (path.toFile().exists()) {
            path = Path.of(filePath + "_" + contador+extension);
            withoutExtension = path.toString();
            contador++;
        }

        return withoutExtension.replace(extension, "");
    }
}
