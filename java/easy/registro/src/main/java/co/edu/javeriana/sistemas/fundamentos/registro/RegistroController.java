package co.edu.javeriana.sistemas.fundamentos.registro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegistroController implements Initializable {

    private final static String SEPARADOR = ",";

    private final ObservableList<String> optionsTipoDoc =
            FXCollections.observableArrayList(
                    "CC",
                    "CE",
                    "TI",
                    "NU",
                    "PP",
                    "PE"
            );

    public ObservableList<String> optionsGenero =
            FXCollections.observableArrayList(
            "Masculino",
            "Femenino",
            "Otro"
        );

    @FXML
    private ComboBox<String> tipoDocumento;

    @FXML
    private ComboBox<String> genero;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField nombres;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField email;

    @FXML
    private TextField telefono;

    @FXML
    private TextField numeroDocumento;

    Alert mensajeAlerta = new Alert(Alert.AlertType.NONE);

    public RegistroController() {



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tipoDocumento.getItems().addAll(optionsTipoDoc);
        genero.getItems().addAll(optionsGenero);
        numericOnly(telefono);
        numericOnly(numeroDocumento);

    }

    @FXML
    protected void onGuardarButtonClick() {

        //validar campos
        if(!validateEmail(email.getText())){
            mensajeAlerta.setAlertType(Alert.AlertType.ERROR);
            mensajeAlerta.setContentText("El email no es valido");
            mensajeAlerta.show();

        } else {
            if(!validarCedulas("registro.txt", numeroDocumento.getText())){
                mensajeAlerta.setAlertType(Alert.AlertType.ERROR);
                mensajeAlerta.setContentText("La cedula ya existe");
                mensajeAlerta.show();

            }
            else {
                saveToFile("registro.txt", nombres.getText() + SEPARADOR + apellidos.getText() + SEPARADOR + tipoDocumento.getValue() + SEPARADOR + numeroDocumento.getText() + SEPARADOR + email.getText() + SEPARADOR+ telefono.getText() + SEPARADOR + genero.getValue());
                welcomeText.setText("Guardando registros del usuario: " + nombres.getText() );
                mensajeAlerta.setAlertType(Alert.AlertType.CONFIRMATION);
                mensajeAlerta.setContentText("Registro guardado correctamente");
                mensajeAlerta.show();
            }
        }
    }

    public boolean validateEmail(String email) {
        return email.matches("^(.+)@(.+)$");
    }



    public boolean validarCedulas(String fileName, String cedula) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SEPARADOR);
                if (parts[3].equals(cedula)) {
                    System.out.println("La cedula ya existe");
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine(); // Add a new line after the content
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void numericOnly(final TextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}