package co.edu.javeriana.sistemas.fundamentos.user_record.core.domain;

import java.time.LocalDate;

public class User {
    //nombres.getText() + SEPARADOR + apellidos.getText() + SEPARADOR + tipoDocumento.getValue() + SEPARADOR + numeroDocumento.getText() + SEPARADOR + email.getText() + SEPARADOR+ telefono.getText() + SEPARADOR + genero.getValue());
    private final String names;
    private final String lastNames;
    private final String documentType;
    private final String documentNumber;
    private final String email;
    private final String phone;
    private final String gender;
    private final LocalDate birthDate;
    private Credential credential;

    public User(String names, String lastNames, String documentType, String documentNumber, String email, String phone, String gender, LocalDate birthDate) {
        this.names = names;
        this.lastNames = lastNames;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        credential = new Credential(email, "123456");
    }
}
