import java.util.ArrayList;
import java.util.Scanner;

public class CajeroAutomatico {

    // Procedimiento: mostrar menú
    public static void mostrarMenu() {
        System.out.println("Menú del Cajero Automático");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
    }

    // Procedimiento: consultar saldo
    public static void consultarSaldo(double[] saldo, ArrayList<String> historial) {
        System.out.printf("Su saldo actual es: Q%.2f\n", saldo[0]);
        historial.add("Consulta de saldo");
    }

    // Procedimiento: depositar dinero
    public static void depositarDinero(double[] saldo, ArrayList<String> historial, Scanner sc) {
        System.out.print("Ingrese el monto a depositar: Q");
        double monto = sc.nextDouble();
        if (monto > 0) {
            saldo[0] += monto;
            System.out.println("Depósito exitoso");
            historial.add("Depósito de Q" + String.format("%.2f", monto));
        } else {
            System.out.println("El monto debe ser mayor a 0");
        }
    }

    // Procedimiento: retirar dinero
    public static void retirarDinero(double[] saldo, ArrayList<String> historial, Scanner sc) {
        System.out.print("Ingrese el monto a retirar: Q");
        double monto = sc.nextDouble();
        if (monto > 0 && monto <= saldo[0]) {
            saldo[0] -= monto;
            System.out.println("Retiro exitoso");
            historial.add("Retiro de Q" + String.format("%.2f", monto));
        } else {
            System.out.println("Fondos insuficientes o monto inválido");
        }
    }

    // Procedimiento principal: iniciar sesión
    public static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        double[] saldo = {1500.00}; // saldo inicial
        ArrayList<String> historial = new ArrayList<>();

        System.out.println("Bienvenido al Cajero Automático");

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> consultarSaldo(saldo, historial);
                case 2 -> depositarDinero(saldo, historial, sc);
                case 3 -> retirarDinero(saldo, historial, sc);
                case 4 -> {
                    System.out.println("Gracias por usar el Cajero Automático.");
                    System.out.println("Historial de Transacciones:");
                    for (String h : historial) {
                        System.out.println(h);
                    }
                }
                default -> System.out.println("Opción inválida, Intente de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }

    // MAIN
    public static void main(String[] args) {
        iniciarSesion();
    }
}
