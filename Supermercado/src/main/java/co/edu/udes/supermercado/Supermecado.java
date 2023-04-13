/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udes.supermercado;

import java.util.*;

/**
 *
 * @author molin
 */
public class Supermecado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empleado = new ArrayList<>();
        ArrayList<customer> cliente = new ArrayList<>();
        ArrayList<Section> secciones = new ArrayList<>();
        ArrayList<Producto> producto = new ArrayList<>();
        System.out.println("--Menu--");

        int option = 0;

        do {
            System.out.println("1.Personas(Empleado o cliente) \n2.Seccion \n3.Producto \n4 Listar \n 5. Salir");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    AddPerson(sc, empleado, cliente);
                    break;
                case 2:
                    addSection(sc, secciones);
                    break;
                case 3:
                    if (secciones.isEmpty()) {
                        System.out.println("No puedes agregar un producto sin antes agregar una seccion");
                        break;
                    } else {
                        AddProduct(sc, producto, secciones);
                        break;
                    }

                case 4:
                    listar(sc, empleado, cliente, producto, secciones);
            }
        } while (option < 5);
    }

    public static void AddPerson(Scanner sc, ArrayList<Employee> empleado, ArrayList<customer> cliente) {
        System.out.println("--Sub menu personas--- \n");
        int option = 0;
        do {
            System.out.println("1.Empleado \n2.Cliente \n3.salir");
            option = sc.nextInt();
            try {

            } catch (NumberFormatException e) {
                System.out.println("Ingrese una opción válida");
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.println("Nombre del empleado: ");
                    String nombreEmpleado = sc.next();

                    System.out.println("En que area trabaja el empleado");
                    String AreaEmpleado = sc.next();

                    System.out.println("Salario del empleado");
                    double SalarioEmpleado = sc.nextDouble();

                    System.out.println("Id del empleado");
                    int idEmpleado = sc.nextInt();

                    empleado.add(new Employee(SalarioEmpleado, AreaEmpleado, nombreEmpleado, idEmpleado));
                }
                case 2 -> {
                    System.out.println("Nombre del cliente");
                    String nombreCliente = sc.next();

                    System.out.println("Telefono del cliente");
                    String telefonoCliente = sc.next();

                    System.out.println("Correo cliente");
                    String correoCliente = sc.next();

                    System.out.println("Id del cliente");
                    int IdCliente = sc.nextInt();

                    cliente.add(new customer(telefonoCliente, correoCliente, nombreCliente, IdCliente));

                }
            }
        } while (option <= 2);
    }

    public static void addSection(Scanner sc, ArrayList<Section> secciones) {
        System.out.println("Ingrese el nombre de la sección: ");
        String seccion = sc.next();

        System.out.println("Ingrese el Id de la seccion");
        int idSection = sc.nextInt();

        if (secciones.contains(seccion)) { // Verificar si la sección ya existe
            System.out.println("La sección ya existe.");
        } else {
            secciones.add(new Section(seccion, idSection));
            System.out.println("Sección agregada correctamente.");
        }
    }

    public static void AddProduct(Scanner sc, ArrayList<Producto> producto, ArrayList<Section> secciones) {
        System.out.println("Digite el id del producto:");
        int id = sc.nextInt();

        System.out.println("Digite el nombre del producto: ");
        sc.nextLine();
        String products = sc.nextLine();

        System.out.println("Digite el precio de los productos: ");
        double precio = sc.nextDouble();

        System.out.println("Seleccione la sección: "); // Mostrar las secciones disponibles
        for (int i = 0; i < secciones.size(); i++) {
            System.out.println((i + 1) + ". " + secciones.get(i).getName());
        }
        int selectedSection = sc.nextInt();

        producto.add(new Producto(id, products, precio, secciones.get(selectedSection - 1)));
    }

    public static void listar(Scanner sc, ArrayList<Employee> empleado, ArrayList<customer> cliente, ArrayList<Producto> producto, ArrayList<Section> secciones) {
        int option = 0;
        do {
            System.out.println();
            System.out.println("Que quieres listar\n 1.Persona(empleado o cliente) \n2.Seccion \n3.Producto \n4.Salir");
            option = sc.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    int elecPerson;
                    do {
                        System.out.println();
                        System.out.println("Quiere ver los empleados o los clientes \n1.Empleados \n 2.Clientes \n 3.salir");
                        elecPerson = sc.nextInt();
                        if (elecPerson == 1) {
                            if (empleado.isEmpty()) {
                                System.out.println("No hay Empleados");
                            } else {
                                for (Employee objeto : empleado) {
                                    String name = objeto.getName();
                                    String area = objeto.getSection_area();
                                    double salario = objeto.getSalary();
                                    int id = objeto.getId();
                                    System.out.println("Nombre del empleado: " + name + "\nArea donde trabaja: " + area + "\nSalario: " + salario + "\n id: " + id);
                                }
                            }
                        } else if (elecPerson == 2) {
                            if (cliente.isEmpty()) {
                                System.out.println("No hay clientes");
                            } else {
                                for (customer objeto : cliente) {
                                    String name = objeto.getName();
                                    String correo = objeto.getMail();
                                    String telefono = objeto.getCell_number();
                                    int id = objeto.getId();
                                    System.out.println("Nombre del cliente: " + name + "\nTelefono: " + telefono + "\nCorreo: " + correo + "\n id: " + id);
                                }
                            }
                        }

                        break;

                    }while (elecPerson != 3);
            
            
            break;
          case 2 :
            System.out.println();
            System.out.println("Secciones: ");
            for(Section objeto: secciones){
                String name = objeto.getName();
                int id = objeto.getId();
                System.out.println("Nombre de la seccion: "+name+"\nId de la seccion: "+id); 
            }
            break;
        case 3: 
            System.out.println();
            System.out.println("Productos: ");
            for(Producto objeto : producto){
                String name = objeto.getName();
                int id = objeto.getId();
              System.out.printf("ID: %d, Nombre: %s, Sección: %s, Precio: %.2f\n", id, name, objeto.getSection().getName(), objeto.getPrice());
            }
            break;
        case 4:
            System.out.println("Saliendo del listar...");
            break;
        default:
            System.out.println("Opción inválida.");
    }

    }
    while (option != 4);
    
}  
}
