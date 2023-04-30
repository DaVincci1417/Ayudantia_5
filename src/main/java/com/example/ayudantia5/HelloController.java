package com.example.ayudantia5;

import GestionArchivos.GestorDatos;
import Model.Database;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //Panel Principal
    @FXML
    private AnchorPane panelPrincipal;
    @FXML
    private Button loginPrincipal, registrarPrincipal;

    //Panel Registro
    @FXML
    private AnchorPane panelRegistro;
    @FXML
    private Button buttonRegistrar, limpiarRegistro, volverRegistro;
    @FXML
    private TextField nombreRegistrar, contraseñaRegistrar;

    //Panel Login
    @FXML
    private AnchorPane panelLogin;
    @FXML
    private Button buttonLogin, limpiarLogin, volverLogin;
    @FXML
    private TextField nombreLogin, contraseñaLogin;

    GestorDatos gestorDatos = new GestorDatos();
    Database database = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database.setUsuarios(gestorDatos.obtenerUsuarios());
    }

    //Estos metodos nos permitira cambiar de pestañas
    @FXML public void abrirPanelRegistrar(ActionEvent event) {
        panelPrincipal.setVisible(false);
        panelLogin.setVisible(false);

        panelRegistro.setVisible(true);
    }
    @FXML public void abrirPanelIngresar(ActionEvent event) {
        panelPrincipal.setVisible(false);
        panelRegistro.setVisible(false);

        panelLogin.setVisible(true);
    }
    @FXML public void volverPestañaPrincipal(ActionEvent event){
        panelLogin.setVisible(false);
        panelRegistro.setVisible(false);

        panelPrincipal.setVisible(true);
    }

    //Estos metodos nos permitira limpiar las casillas de textos
    @FXML
    public void limpiarRegistro(ActionEvent event) {
        nombreRegistrar.setText(null);
        contraseñaRegistrar.setText(null);
    }
    @FXML
    public void limpiarLogin(ActionEvent event) {
        nombreLogin.setText(null);
        contraseñaLogin.setText(null);
    }

    //Interaccion Usuario-Interfaz del Panel Registro
    @FXML
    public void registrarUsuario(ActionEvent event){
        if(nombreRegistrar.getText().isEmpty() || contraseñaRegistrar.getText().isEmpty()){
            mensajeErrorRegistro();
        }else{
            if (database.registrarUsuario(new User(nombreRegistrar.getText(), contraseñaRegistrar.getText())) == 1) {
                panelRegistro.setVisible(false);
                panelPrincipal.setVisible(true);
                mensajeConfirmacionRegistro();
            }else{
                mensajeErrorRegistro();
            }
        }
    }
    @FXML
    private void mensajeConfirmacionRegistro() {
        Alert mensaje = new Alert(Alert.AlertType.NONE);
        mensaje.setTitle("Registro");
        mensaje.setHeaderText("Registro exitoso");
        mensaje.setContentText("Usuario registrado correctamente");
        ButtonType botonOk = new ButtonType("Ok");
        mensaje.getButtonTypes().setAll(botonOk);
        mensaje.show();
    }
    @FXML
    private void mensajeErrorRegistro(){
        if(nombreRegistrar.getText().isEmpty() || contraseñaRegistrar.getText().isEmpty()){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Login");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
        if(database.registrarUsuario(new User(nombreRegistrar.getText(), contraseñaRegistrar.getText())) == 0){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Login");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("El nombre de usuario ya existe, intente con uno nuevo.");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }

    //Interaccion Usuario-Interfaz del Panel Login
    @FXML
    public void loginUsuario(ActionEvent event){
        if(nombreLogin.getText().isEmpty() || contraseñaLogin.getText().isEmpty()){
            mensajeErrorRegistro();
        }else{
            if (database.ingresarDatabase(nombreLogin.getText(), contraseñaLogin.getText()) == 1) {
                panelLogin.setVisible(false);
                panelPrincipal.setVisible(true);
                mensajeConfirmacionlogin();
            } else {
                mensajeErrorLogin();
            }
        }
    }
    @FXML
    private void mensajeConfirmacionlogin(){
        Alert mensaje = new Alert(Alert.AlertType.NONE);
        mensaje.setTitle("Login");
        mensaje.setHeaderText("¡Bienvenido!");
        mensaje.setContentText("Hola, " + nombreLogin.getText() + ".");
        ButtonType botonOk = new ButtonType("Ok");
        mensaje.getButtonTypes().setAll(botonOk);
        mensaje.show();
    }
    @FXML private void mensajeErrorLogin(){
        if(nombreLogin.getText().isEmpty() || contraseñaLogin.getText().isEmpty()){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Login");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
        if(database.ingresarDatabase(nombreLogin.getText(), contraseñaLogin.getText()) == 0){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Login");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("Nombre de usuario o contraseña incorrectos.");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }
}