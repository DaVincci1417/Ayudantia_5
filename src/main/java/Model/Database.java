package Model;

import GestionArchivos.GestorDatos;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Database {
    private LinkedList<User> usuarios = new LinkedList<>();

    //Constructor
    public Database(){

    }

    public LinkedList<User> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(LinkedList<User> usuarios) {
        this.usuarios = usuarios;
    }

    public int registrarUsuario(User usuario){
        GestorDatos gd = new GestorDatos();
        if(validarNombreUsuario(usuario) == 1){
            usuarios.add(usuario);
            gd.registrarUsuario(usuario);
            return 1;
        }
        return 0;
    }
    public int validarNombreUsuario(User usuario){
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getNombre().equalsIgnoreCase(usuario.getNombre())){
                return 0;
            }
        }
        return 1;
    }
    public User buscarUsarioPorNomnre(String nombre) {
        if (usuarios == null) {
            return null;
        } else {
            int posicion = -1;
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                    posicion = i;
                }
            }
            if (posicion != -1) {
                return usuarios.get(posicion);
            } else {
                return null;
            }
        }
    }
    public int ingresarDatabase(String nombre, String contraseña){
        if(buscarUsarioPorNomnre(nombre).equals(null)){
            return 0;
        }else{
            if(buscarUsarioPorNomnre(nombre).getContraseña().equalsIgnoreCase(contraseña)){
                return 1;
            }
            return 0;
        }
    }
}
