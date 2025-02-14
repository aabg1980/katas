package co.edu.javeriana.sistemas.fundamentos.user_record.features.managers;

import co.edu.javeriana.sistemas.fundamentos.user_record.core.domain.User;
import co.edu.javeriana.sistemas.fundamentos.user_record.core.validations.RecordValidations;

/**
 * Registrar un nuevo usuario
 * */
public class RecordUser {

    private final RecordValidations validations = new RecordValidations();

    public void recordNewUser(User userInfo) {
        //Validar informacion del usuario
        if(!validations.isValidAge(userInfo.getBirthDate())) {
            throw new IllegalArgumentException("El usuario debe ser mayor de 15 años");
        }



    }
}
