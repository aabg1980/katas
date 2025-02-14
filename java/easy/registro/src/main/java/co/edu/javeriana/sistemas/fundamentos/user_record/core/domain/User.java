package co.edu.javeriana.sistemas.fundamentos.user_record.core.domain;

import java.time.LocalDate;

public class User {

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

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }




}
