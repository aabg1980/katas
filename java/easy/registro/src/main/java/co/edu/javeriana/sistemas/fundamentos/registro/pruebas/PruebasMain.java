package co.edu.javeriana.sistemas.fundamentos.registro.pruebas;

import co.edu.javeriana.sistemas.fundamentos.registro.validations.RecordValidations;

import java.time.LocalDate;

public class PruebasMain {

    public static void main(String args[]) {
        System.out.println("Pruebas");

        RecordValidations recordValidations = new RecordValidations();
        System.out.println(recordValidations.isValidAge(LocalDate.now()));

    }
}
