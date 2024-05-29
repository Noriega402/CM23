

package miumg.edu.gt.programacioni;

/**
 *
 * @author Grupo62024
 */
public class ProgramacionI {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) 
            MenuPrincipal menuPrincipal = new MenuPrincipal(scanner);
            menuPrincipal.mostrarMenu();
        
    }
}

class Menu{
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1: Fase 1 – Objetos y recursividad");
            System.out.println("2: Fase 2");
            System.out.println("3: Fase 3");
            System.out.println("4: Salir del Programa");
            System.out.print("Ingrese la opcion que desee: ");
            opcion = Integer.parseInt(scanner.next());
            switch (opcion) {
                case 1 -> {
                    MenuFase1 menuFase1 = new MenuFase1(scanner);
                    menuFase1.mostrarMenu();
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> System.out.println("Gracias por usar este programa,¡Hasta Luego!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
                    } while (opcion != 4);
    }
}
