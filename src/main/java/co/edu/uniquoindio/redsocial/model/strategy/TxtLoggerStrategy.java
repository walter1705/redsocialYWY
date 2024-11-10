package co.edu.uniquoindio.redsocial.model.strategy;

import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.service.ILoggerStrategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class TxtLoggerStrategy implements ILoggerStrategy {
    private static String extension = ".txt";

    @Override
    public void write(String data, String fecha, String path, String titulo, Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path+"txt"))) {
            writer.write(titulo + "\n");
            writer.write(fecha);
            writer.write("Reporte realizado por:" + usuario.getUsername() + "\n");
            writer.write("Información del reporte: \n");
            writer.write(data);
            System.out.println("Archivo TXT generado en: " + path);
        } catch (IOException e) {
            e.printStackTrace();
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
