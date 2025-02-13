package co.edu.javeriana.sistemas.fundamentos.registro.pruebas;

import co.edu.javeriana.sistemas.fundamentos.registro.validaciones.ValidacionesRegistro;

import java.time.LocalDate;

public class PruebasMain {

    public static void main(String args[]) {
        System.out.println("Pruebas");

        ValidacionesRegistro validacionesRegistro = new ValidacionesRegistro();
        System.out.println(validacionesRegistro.validarEdad(LocalDate.now()));

    }
}
