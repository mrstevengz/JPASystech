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

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Steven Leonel");
        estudiante.setApellido("Sequeira Reyes");
        estudiante.setCIF("24010446");

        Evento evento = new Evento();
        evento.setNombre("Systech 2025");
        evento.setFecha("10 de septiembre de 2025");
        evento.setLugar("Centro de convenciones Olof Palme");

        EstudianteDAO dao = new EstudianteDAO(em);
        EventoDAO eventodao = new EventoDAO(em);

        System.out.println(dao.guardar(estudiante));
        System.out.println(eventodao.guardar(evento));

        List<Estudiante> estudiantes = dao.listar();
        for (Estudiante listEstudiantes : estudiantes) {
            System.out.println(listEstudiantes);
        }

        List<Evento> eventos = eventodao.listarEventos();
        for (Evento listEventos : eventos) {
            System.out.println(listEventos);
        }
    }
}
