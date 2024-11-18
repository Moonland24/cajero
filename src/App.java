import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Menu();
    }

    public static void Menu() {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Bienvenido al cajero automatico de InmaBank :D ---");

        int opcion = 0;
        int saldo = 0;
        int cantRetiradas = 0;
        int cantDepositos = 0;
        int ingresos = 0;
        int retiradas = 0;

        do {
            System.out.println("┌─────────────────────────────┐");
            System.out.println("│        Cajero Automático    │");
            System.out.println("├─────────────────────────────┤");
            System.out.println("│  1. Consultar saldo         │");
            System.out.println("│  2. Depositar dinero        │");
            System.out.println("│  3. Retirar dinero          │");
            System.out.println("│  4. Salir                   │");
            System.out.println("└─────────────────────────────┘");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Tu saldo actual es: $" + saldo);
                    break;
                case 2:
                    saldo = DepositarDinero(saldo);
                    cantDepositos++;
                    ingresos = ingresos + saldo;
                    break;
                case 3:
                    int saldoAntesRetirada = saldo;
                    saldo = RetirarDinero(saldo);
                    cantRetiradas++;
                    int retirada = saldoAntesRetirada - saldo;
                    retiradas = retiradas + retirada;
                    break;
                case 4:
                    System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
                    System.out.println("------------ESTADÍSTICAS DE USO------------");
                    System.out.println("  Número total de Ingresos:      " + cantDepositos);
                    System.out.println("  Importe total Ingresado:       $" + ingresos);
                    System.out.println("  Número total de Retiros:       " + cantRetiradas);
                    System.out.println("  Importe total Retirado:        $" + retiradas);
                    System.out.println("  Saldo Final en cuenta:         $" + saldo);
                    System.out.println("-------------------------------------------");

                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 4);
    }

    public static int DepositarDinero(int saldo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad a depositar: ");

        int deposito = scanner.nextInt();
        saldo = saldo + deposito;
        
        System.out.println("-- El dinero depositado es: $" + deposito);
        return saldo;
    };

    public static int RetirarDinero(int saldo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantiidad a retirar: ");
        int retirada = scanner.nextInt();
        if (retirada <0 ) {
            System.out.println("No se puede retirar una cantidad negativa");}
            
            
        else if (retirada <= saldo) {
            
            saldo = saldo - retirada;
            System.out.println("-- El dinero retirado es: $" + retirada);
            System.out.println("Tu saldo actual es: $" + saldo);
            return saldo;
        } else { 
            System.out.println("Saldo insuficiente");
       
            System.out.println("Tu saldo actual es: $" + saldo);
        }
        return saldo;
    }

 }

