package co.edu.javeriana.sistemas.fundamentos.registro.validations;

import co.edu.javeriana.sistemas.fundamentos.user_record.core.validations.RecordValidations;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class RecordValidationsTest {

    private final RecordValidations validations = new RecordValidations();
    @Test
    void isValidAgeUnder15() {
        //Arranger
        LocalDate birthDateUnder15 = LocalDate.now();
        //Act
        boolean isValid = validations.isValidAge(birthDateUnder15);
        //Assert
        assertFalse(isValid);
    }

    @Test
    void isValidAgeOver15() {
        //Arranger
        LocalDate birthDateOver15 = LocalDate.now().minusYears(RecordValidations.MIN_AGE+1);
        //Act
        boolean isValid = validations.isValidAge(birthDateOver15);
        //Assert
        assertTrue(isValid);
    }

    @Test
    void validateNullBirthDate() {
        assertThrows(IllegalArgumentException.class, ()-> validations.isValidAge(null) );
    }

    @Test
    void validateOver100() {
        //Arranger
        LocalDate birthDateOver100 = LocalDate.now().minusYears(RecordValidations.MAX_AGE + 1);
        //Act Assert
        assertThrows(IllegalArgumentException.class, ()-> validations.isValidAge(birthDateOver100) );
    }
}