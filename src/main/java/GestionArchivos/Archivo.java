package GestionArchivos;

import Model.User;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;

public class Archivo{
    private String nombreArchivo;

    //Constructor
    public Archivo(String nombreArchivo) {
        setNombreArchivo(nombreArchivo);
    }

    //Getter and Setter
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    private void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    //Operation
    public LinkedList<String> obtenerTextoDelArchivo(){
        LinkedList<String> texto = null;
        try {
            File archivo = new File("C:\\Users\\ecani\\Desktop\\DaVincci\\Proyectos\\Ayudantia5\\src\\main\\resources\\archivos\\usuarios.txt");
            if(archivo.exists()){
                texto = new LinkedList<>();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null){
                    texto.add(linea);
                }
                br.close();
            }else{
                System.out.println("El archivo no existe.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return texto;
    }
    private File obtenerArchivo(){
        try {
            URL url = getClass().getClassLoader().getResource("usuarios.txt");
            return new File(url.toURI());
        }catch (URISyntaxException e){
            e.printStackTrace();
            return null;
        }
    }
}
