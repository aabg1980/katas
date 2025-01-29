package co.edu.javeriana.ejercicios.fibonacci;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

    private static long[] cache = new long[51];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de términos: ");
        int n = scanner.nextInt();
        scanner.close();


        System.out.println("Serie de Fibonacci:");
        inicializarCache();
        long duracion = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < n; i++) {

            System.out.print(fibonacci2(i) + " ");
        }
        System.out.println("La operacion tardo: " + (System.currentTimeMillis()-duracion));
    }

    public static long fibonacci(int n) {


        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static BigInteger fibonacci3(int n) {
        if(n < 0 || n > 50) {
            throw new IllegalArgumentException("Número fuera del rango permitido (0-40)");
        }

        BigDecimal sqrt5 = BigDecimal.valueOf(Math.sqrt(5));
        BigDecimal phi = BigDecimal.valueOf(1).add(sqrt5).divide(BigDecimal.valueOf(2));
        BigDecimal psi = BigDecimal.valueOf(1).subtract(sqrt5).divide(BigDecimal.valueOf(2));


        return  phi.pow(n).subtract(psi.pow(n)).divide(sqrt5).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger();
        //return result;
    }

    private static void inicializarCache() {
        for(int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        // Casos base
        cache[0] = 0;
        cache[1] = 1;
    }

    public static long fibonacci2(int n) {
        if(n < 0 || n > 100) {
            throw new IllegalArgumentException("Número fuera del rango permitido (0-40)");
        }

        if(cache[n] != -1) {
            return cache[n]; // Retornar valor en caché
        }

        // Calcular recursivamente y almacenar en caché
        cache[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
        return cache[n];
    }

}
