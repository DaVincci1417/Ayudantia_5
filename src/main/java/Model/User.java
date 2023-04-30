package Model;

public class User {
    private String nombre;
    private String contraseña;

    //Constructor
    public User(String nombre, String contraseña){
        setNombre(nombre);
        setContraseña(contraseña);
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    private void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return nombre + "," + contraseña;
    }
}
