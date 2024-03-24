package com.estudiantesapp.presentacion;

import com.estudiantesapp.datos.EstudianteDAO;
import com.estudiantesapp.dominio.Estudiante;

import java.util.Scanner;

public class EstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        var estudianteDAO = new EstudianteDAO();

        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDAO);
            } catch(Exception ex) {
                System.out.println("Ocurrió un error al ejecutar operación: " + ex.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                ***** Sistema de Estudiantes *****
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Actualizar Estudiante
                5. Eliminar Estudiante
                6. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO) {
        System.out.print("Elige una opción: ");
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Listado de Estudiantes...");
                var estudiantes = estudianteDAO.listar();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarPorId(estudiante);
                if (encontrado) {
                    System.out.println("Estudiante encontrado: " + estudiante);
                } else {
                    System.out.println("Estudiante no encontrado: " + estudiante);
                }
            }
            case 3 -> {
                System.out.println("Agregar Estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregar(estudiante);
                if (agregado) {
                    System.out.println("Estudiante agregado:" + estudiante);
                } else {
                    System.out.println("Estudiante no agregado:" + estudiante);
                }
            }
            case 4 -> {
                System.out.println("Actualizar Estudiante: ");
                System.out.print("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var actualizado = estudianteDAO.actualizar(estudiante);
                if (actualizado) {
                    System.out.println("Estudiante actualizado:" + estudiante);
                } else {
                    System.out.println("Estudiante no actualizado:" + estudiante);
                }
            }
            case 5 -> {
                System.out.println("Eliminar Estudiante: ");
                System.out.print("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminar(estudiante);
                if (eliminado) {
                    System.out.println("Estudiante eliminado:" + estudiante);
                } else {
                    System.out.println("Estudiante no eliminado:" + estudiante);
                }
            }
            case 6 -> {
                System.out.println("Hasta Pronto!");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida");
        }
        return salir;
    }
}