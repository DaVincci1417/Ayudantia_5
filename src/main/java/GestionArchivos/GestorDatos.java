package GestionArchivos;

import Model.Database;
import Model.User;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GestorDatos {

    public LinkedList<User> obtenerUsuarios(){
        LinkedList<User> usuarios = null;
        Archivo archivo = new Archivo("usuarios.txt");
        LinkedList<String> lineas = archivo.obtenerTextoDelArchivo();
        if(lineas != null){
            usuarios = new LinkedList<>();
            for(int i = 0; i < lineas.size(); i++){
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String nombre = tokens.nextToken();
                String contraseña = tokens.nextToken();
                usuarios.add(new User(nombre, contraseña));
            }
        }
        return usuarios;
    }

    public boolean registrarUsuario(User usuario) {
        boolean lineaVacia = false;
        try {
            File file = new File("C:\\Users\\ecani\\Desktop\\DaVincci\\Proyectos\\Ayudantia5\\src\\main\\resources\\archivos\\usuarios.txt");
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(usuario.toString());
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al intentar registrar al usuario, favor contactar con administrador");
            return false;
        }
    }
}
