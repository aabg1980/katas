package co.edu.javeriana.sistemas.fundamentos.registro.validations;

import java.time.LocalDate;
/**
 * Clase que contiene las validaciones de rgistrar un usuario
 */
public class RecordValidations {

    public static final int MIN_AGE = 15;
    public static final int MAX_AGE = 100;

    /**
     * Método que valida la edad de un usuario
     * @param birthDate fecha de nacimiento del usuario
     * @return true si es mayor de 15 años, false en caso contrario
     */
    public boolean isValidAge(LocalDate birthDate) {
        //validar mayor de 15

        if(birthDate == null) {
            throw new IllegalArgumentException("Fecha de nacimiento no puede ser nula");
        }
        if(birthDate.isBefore(LocalDate.now().minusYears(MAX_AGE))) {
            throw new IllegalArgumentException("Fecha de nacimiento no puede ser mayor a 100 años");
        }
        return birthDate.isBefore(LocalDate.now().minusYears(MIN_AGE));

    }
}
