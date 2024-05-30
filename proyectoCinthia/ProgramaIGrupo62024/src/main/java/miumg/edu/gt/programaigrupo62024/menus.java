/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miumg.edu.gt.programaigrupo62024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javaJPA.CarroJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HP INTEL
 */
public class menus {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miumg.edu.gt_Proyecto_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    Scanner scanner = new Scanner(System.in); // Cerrar el scanner al finalizar
    int contGlobal = 0;
    static int con1 = 0;
    int con2 = 0;
    int con3 = 0;
    private List<Carro> carros = new ArrayList<>();
    private List<Avion> aviones = new ArrayList<>();
    private List<Balsa> balsas = new ArrayList<>();
    private Vehiculo[] vehiculos = new Vehiculo[10];
    

    public static String ejemplo(){
        return "saludo";
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void inicializarVehiculos() {
        for (int i = 0; i < vehiculos.length; i++) {
            vehiculos[i] = new Vehiculo(); // O inicializa como un objeto de la clase base Vehiculo
        }
    }

    public void mostrarMenu(){
        int opcion;
        do {
            System.out.println("\n    Menú Principal");
            System.out.println("1: Fase 1 – Objetos y recursividad\n2: Fase 2 - Arreglos\n3: Fase 3\n4: Salir del programa");
            System.out.print("\n----Ingrese su opción: ");
            opcion = Integer.parseInt(scanner.next());
            switch (opcion) {
                case 1:
                    mostrarSubMenu1();
                    break;
                case 2:
                    mostrarSubMenu2();
                    break;
                case 3:
                    //  Fase 3
                    break;
                case 4:
                    System.out.println("\nGracias por utilizar nuestro programa :D\n       ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n\n      Opción no válida. Intente de nuevo");
            }
        } while (opcion != 4);
    }

    public void mostrarSubMenu1() {
        char opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n    Submenú: Fase 1");
            System.out.println("a: Ingresar datos de vehículos\nb: Mostrar datos del vehículo\n"
                    + "c: Crear una torre de Hanoi\nd: Regresar al menú principal");
            System.out.print("\n-----Ingrese su opción: ");
            opcion = scanner.next().charAt(0);
            switch (opcion) {
                case 'a':
                    ingresarDatosVehiculo();
                    break;
                case 'b':
                    MostrarDatos();
                    break;
                case 'c':
                    TorreHanoi();
                    break;
                case 'd':
                    System.out.println("Regresando al menú principal...");
                    return; // Regresar al menú principal
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
    }

    public void mostrarSubMenu2() {
        char opcion;
        do {
            System.out.println("\n    Sub Menú: Fase 2");
            System.out.println("a: Agregar Carro\nb: Agregar Balsa\nc: Agregar Avión\nd: Ordenar Arreglo\ne: Mostrar Arreglo\n");
            System.out.print("\n----Ingrese su opción: ");
            opcion = scanner.next().charAt(0);
            switch (opcion) {
                case 'a':
                    Carro();
                    break;
                case 'b':
                    Balsa();
                    break;
                case 'c':
                    Avion();
                    break;
                case 'd':
                    ordenarArreglo();
                    break;
                case 'e':
                    imprimirArreglo();
                    break;
                default:
                    System.out.println("\n\n      Opción no válida. Intente de nuevo");
            }
        } while (opcion != 4);
    }

    public void ingresarDatosVehiculo() {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n    Seleccione el tipo de vehículo:\n1. Carro\n2. Balsa\n3. Avión");
        System.out.println("\n-----Ingrese su opción: ");
        opcion = scanner.next().charAt(0);
        switch (opcion) {
            case '1':
                Carro();
                break;
            case '2':
                Balsa();
                break;
            case '3':
                Avion();
                break;
            default:
                System.out.println("\nOpción no válida. INTENTELO NUEVAMENTE.\n");
        }
    } //Codigo de Darío

    public void Carro() {
        if (contGlobal <= 9) {
            int opcion;
            Carro carro = new Carro();
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n    Vahículo: CARRO");
            System.out.println("-ID:");
            int identificador = scanner.nextInt();
            scanner.nextLine();
            if (buscarId(identificador) == false) {
                carro.setIdentificador(identificador);
                System.out.println("-Tipo de Gasolina: ");
                carro.setGas(scanner.nextLine());
                System.out.println("-Marca:");
                carro.setMarca(scanner.nextLine());
                System.out.println("-Modelo:");
                carro.setModelo(scanner.nextLine());
                System.out.println("-Color:");
                carro.setColor(scanner.nextLine());
                try {
                    em = getEntityManager();
                    em.getTransaction().begin();
                    em.persist(carro);
                    em.getTransaction().commit();
                } finally {
                    if (em != null) {
                        em.close();
                    }
                }
                System.out.println("\n¿Que desea hacer a continuación?:\n 1. Ir al Menú Principal\n2. Agregar otro vehículo");
                opcion = scanner.next().charAt(0);
                switch (opcion) {
                    case '1':
                        System.out.println("\nVolviendo a Menú Principal\n");
                        mostrarMenu();
                        break;
                    default:
                        System.out.println("\nVolviendo a Sub-Menu\n");
                }
            } else {
                System.out.println("\nEl ID Ingresado se encuentra regristrado \n       INTENTELO NUEVAMENTE \n");
                Carro();
            }
        } else {
            System.out.println("\nAlmacenamiento de Vehiculos lleno\n");
            mostrarSubMenu2();
        }
    }

    private void Balsa() {
        int opcion;
        if (contGlobal <= 9) {
            Balsa balsa = new Balsa();
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n    Vahículo: BALSA");
            System.out.println("-ID:\n ");
            int identificador = scanner.nextInt();
            scanner.nextLine();
            if (buscarId(identificador) == false) {
                balsa.setIdentificador(identificador);
                System.out.println("\n-Motor o remo: ");
                balsa.setMotor(scanner.nextLine());
                System.out.println("\n-Marca:");
                balsa.setMarca(scanner.nextLine());
                System.out.println("\n-Modelo:");
                balsa.setModelo(scanner.nextLine());
                System.out.println("\n-Color:");
                balsa.setColor(scanner.nextLine());
                vehiculos[contGlobal] = balsa;
                contGlobal++;
                System.out.println("\n¿Que desea hacer a continuación?:\n\n1. Ir al Menú Principal\n2. Agregar otro vehículo");
                opcion = scanner.next().charAt(0);
                switch (opcion) {
                    case '1':
                        System.out.println("\nVolviendo a Menú Principal\n");
                        mostrarMenu();
                        break;
                    default:
                        System.out.println("\nVolviendo a Sub-Menu\n");
                }
            } else {
                System.out.println("\nEl ID Ingresado se encuentra regristrado \n       INTENTELO NUEVAMENTE \n");
                Balsa();
            }
        } else {
            System.out.println("\nAlmacenamiento de Vehiculos lleno\n");
            mostrarSubMenu2();
        }
    }

    private void Avion() {
        int opcion;
        if (contGlobal <= 9) {
            Avion avion = new Avion();
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n    Vahículo: AVION");
            System.out.println("-ID:\n ");
            int identificador = scanner.nextInt();
            scanner.nextLine();
            if (buscarId(identificador) == false) {
                avion.setIdentificador(identificador);
                System.out.println("-Pasajeros(cantidad): ");
                avion.setPasajeros(scanner.nextInt());
                System.out.println("-Modelo:");
                avion.setModelo(scanner.nextLine());
                scanner.nextLine();
                System.out.println("-Color:");
                avion.setColor(scanner.nextLine());
                System.out.println("-Marca:");
                avion.setMarca(scanner.nextLine());
                vehiculos[contGlobal] = avion;
                contGlobal++;
                System.out.println("\n¿Que desea hacer a continuación?:\n\n1. Ir al Menú Principal\n2. Agregar otro vehículo");
                opcion = scanner.next().charAt(0);
                switch (opcion) {
                    case '1':
                        System.out.println("\nVolviendo a Menú Principal\n");
                        mostrarMenu();
                        break;
                    default:
                        System.out.println("\nVolviendo a Sub-Menu\n");
                }
            } else {
                System.out.println("\nEl ID Ingresado se encuentra regristrado \n       INTENTELO NUEVAMENTE \n");
                Avion();
            }
        } else {
            System.out.println("\nAlmacenamiento de Vehiculos lleno\n");
            mostrarSubMenu2();
        }
    }

    private void MostrarDatos() {
        int opcion;
        Carro carrito = new Carro();
        Balsa balsita = new Balsa();
        Avion avioncito = new Avion();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Que vehículo desea consultar?\n\n1. Carro\n2. Balsa\n3. Avion\n\n----Ingrese su opción:");
        opcion = scanner.next().charAt(0);
        switch (opcion) {
            case '1':////////////Carro   

                if (carros.isEmpty() == false) {
                    for (int i = 0; i < carros.size(); i++) {
                        System.out.println("\n---------Datos Ingresados (CARRO):\nTipo de Gasolina: " + carros.get(i).getGas()
                                + "\nColor: " + carros.get(i).getColor() + "\nMarca: " + carros.get(i).getMarca() + "\nModelo: " + carros.get(i).getModelo());
                    }
                } else {
                    System.out.println("\nNo se han registrado datos previamente\n");
                }
                break;
            case '2'://///////////balsa 
                if (balsas.isEmpty() == false) {
                    for (int i = 0; i < balsas.size(); i++) {
                        System.out.println("\n---------Datos Ingresados (BALSA):\nMotor o remo: " + balsas.get(i).getMotor()
                                + "\nColor: " + balsas.get(i).getColor() + "\nMarca: " + balsas.get(i).getMarca() + "\nModelo: " + balsas.get(i).getModelo());
                    }
                } else {
                    System.out.println("\nNo se han registrado datos previamente\n");
                }
                break;
            case '3'://///////////avion
                if (aviones.isEmpty() == false) {
                    for (int i = 0; i < aviones.size(); i++) {
                        System.out.println("\n---------Datos Ingresados (AVION):\nTipo de Gasolina: " + aviones.get(i).getPasajeros()
                                + "\nColor: " + aviones.get(i).getColor() + "\nMarca: " + aviones.get(i).getMarca() + "\nModelo: " + aviones.get(i).getModelo());
                    }
                } else {
                    System.out.println("\nNo se han registrado datos previamente\n");
                }
                break;
        }
    }

    public void TorreHanoi() {
        int numDiscos;
        do {
            System.out.print("Ingrese la cantidad de discos (mínimo 3): ");
            numDiscos = scanner.nextInt();
            if (numDiscos < 3) {
                System.out.println("Debe ingresar al menos 3 discos.");
            }
        } while (numDiscos < 3);

        System.out.println("\nMovimientos de la Torre de Hanoi:");
        torreHanoi(numDiscos, 1, 3, 2);

        System.out.print("\n¿Desea regresar al submenú? (s/n): ");
        char regresar = scanner.next().charAt(0);
        if (regresar != 's') {
            System.out.println("Regresando al menú principal...");
        }
    }

    public void torreHanoi(int numDiscos, int torreOrigen, int torreDestino, int torreAuxiliar) {
        if (numDiscos == 1) {
            System.out.println(torreOrigen + " --> " + torreDestino);
        } else {
            torreHanoi(numDiscos - 1, torreOrigen, torreAuxiliar, torreDestino);
            System.out.println(torreOrigen + " --> " + torreDestino);
            torreHanoi(numDiscos - 1, torreAuxiliar, torreDestino, torreOrigen);
        }
    }

    public boolean buscarId(int id) {
        int d = id;
        if (vehiculos != null) {
            for (int i = 0; i < vehiculos.length; i++) {
                if (vehiculos[i].getIdentificador() == d) {
                    return true;
                }
            }
        }
        return false;
    }

    private void ordenarArreglo() {
        if (contGlobal == 0) {
            System.out.println("    \nEl array está vacío. No se puede ordenar.\n           INGRESE VEHICULOS\n");
            return;
        }

        System.out.print("     ¿En que orden desea imprimir el Array? \na. Ascendente \nb. Descendente\n ");
        char orden = scanner.next().charAt(0);

        Arrays.sort(vehiculos, 0, contGlobal, (v1, v2) -> {
            if (orden == 'b') {
                return Integer.compare(v2.getIdentificador(), v1.getIdentificador()); // Orden descendente
            } else {
                return Integer.compare(v1.getIdentificador(), v2.getIdentificador()); // Orden ascendente
            }
        });

        System.out.println("\n  El array se ha ordenado.\n");
        mostrarArreglo(); // Llamar a mostrarArreglo después de ordenar
    }

    private void mostrarArreglo() {
        if (contGlobal == 0) {
            System.out.println("\nEl array está vacío. No hay elementos para mostrar.\n           INGRESE VEHICULOS\n");
            return;
        }

        System.out.println("\nElementos del array:");
        for (int i = 0; i < contGlobal; i++) {
            Vehiculo vehiculo = vehiculos[i];
            System.out.println("Identificador: " + vehiculo.getIdentificador());
            if (vehiculo instanceof Carro) {
                Carro carro = (Carro) vehiculo;
                System.out.println("Tipo de Gasolina: " + carro.getGas());
                System.out.println("Marca: " + carro.getMarca());
                System.out.println("Modelo: " + carro.getModelo());
                System.out.println("Color: " + carro.getColor());
            } else if (vehiculo instanceof Balsa) {
                Balsa balsa = (Balsa) vehiculo;
                System.out.println("Motor o remo: " + balsa.getMotor());
                System.out.println("Marca: " + balsa.getMarca());
                System.out.println("Modelo: " + balsa.getModelo());
                System.out.println("Color: " + balsa.getColor());
            } else if (vehiculo instanceof Avion) {
                Avion avion = (Avion) vehiculo;
                System.out.println("Pasajeros: " + avion.getPasajeros());
                System.out.println("Marca: " + avion.getMarca());
                System.out.println("Modelo: " + avion.getModelo());
                System.out.println("Color: " + avion.getColor());
            }
            System.out.println();
        }
    }

    private void imprimirArreglo() {
        if (contGlobal == 0) {
            System.out.println("\nEl array está vacío. No hay elementos para mostrar.\n           INGRESE VEHICULOS\n");
            return;
        }
        System.out.println("\nElementos del array:");
        for (int i = 0; i < contGlobal; i++) {
            Vehiculo vehiculo = vehiculos[i];
            System.out.println("Identificador: " + vehiculo.getIdentificador());
            System.out.println(); // Salto de línea para separar los registros     
        }
    }

}
