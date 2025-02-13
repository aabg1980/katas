package co.edu.javeriana.sistemas.fundamentos.registro.validaciones;

import java.time.LocalDate;

public class ValidacionesRegistro {

    public boolean validarEdad(LocalDate fechaNacimiento) {
        //validar mayor de 15
        return (LocalDate.now().getYear() - fechaNacimiento.getYear()) >= 15;
    }
}
