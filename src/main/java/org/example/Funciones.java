import java.util.Arrays;

public class Funciones {
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) return 'A';
        else if (promedio >= 80) return 'B';
        else if (promedio >= 70) return 'C';
        else if (promedio >= 60) return 'D';
        else return 'F';
    }

    public static boolean estaAprobado(char literal) {
        return (literal == 'A' || literal == 'B' || literal == 'C');
    }

    public static void mostrarResultado(String nombre, double[] notas) {
        double promedio = calcularPromedio(notas);
        char literal = obtenerLiteral(promedio);
        boolean aprobado = estaAprobado(literal);

        System.out.println("Estudiante: " + nombre);
        System.out.println("Notas: " + Arrays.toString(notas));
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Literal: " + literal);
        System.out.println("Resultado: " + (aprobado ? "Aprobado" : "Reprobado"));
        System.out.println(" ");
    }

    public static void main(String[] args) {
        String nombre = "Byron Mijangos";
        double[] notas = {90.7, 82.5, 91.4};
        mostrarResultado(nombre, notas);

        String[] nombres = {"Mario Aguirre", "Ana Castillo", "Juan Zepeda"};
        double[][] notasGrupo = {
                {80, 75, 90},
                {55, 60, 58},
                {100, 95, 98}
        };
        System.out.println("Evaluacion de varios estudiantes: ");
        for (int i = 0; i < nombres.length; i++) {
            mostrarResultado(nombres[i], notasGrupo[i]);
        }
    }
}