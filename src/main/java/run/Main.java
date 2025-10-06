package run;

import config.JPAUtil;
import entities.Estudiante;
import entities.Evento;
import jakarta.persistence.EntityManager;
import repository.dao.EstudianteDAO;
import repository.dao.EventoDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        EstudianteDAO dao = new EstudianteDAO(em);
        EventoDAO eventodao = new EventoDAO(em);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int opcion;
        do {
            System.out.println("---- Menú CRUD ----");
            System.out.println("1. Crear Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Crear Evento");
            System.out.println("4. Listar Eventos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Estudiante estudiante = new Estudiante();
                    System.out.print("Nombre: ");
                    estudiante.setNombre(scanner.nextLine());
                    System.out.print("Apellido: ");
                    estudiante.setApellido(scanner.nextLine());
                    System.out.print("CIF: ");
                    estudiante.setCIF(scanner.nextLine());
                    System.out.println(dao.guardar(estudiante));
                    break;
                case 2:
                    List<Estudiante> estudiantes = dao.listar();
                    for (Estudiante e : estudiantes) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    Evento evento = new Evento();
                    System.out.print("Nombre del evento: ");
                    evento.setNombre(scanner.nextLine());
                    System.out.print("Fecha: ");
                    evento.setFecha(scanner.nextLine());
                    System.out.print("Lugar: ");
                    evento.setLugar(scanner.nextLine());
                    System.out.println(eventodao.guardar(evento));
                    break;
                case 4:
                    List<Evento> eventos = eventodao.listarEventos();
                    for (Evento ev : eventos) {
                        System.out.println(ev);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        em.close();
        scanner.close();
    }
}
