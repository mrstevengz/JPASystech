package repository.dao;

import entities.Estudiante;
import jakarta.persistence.EntityManager;
import repository.IEstudiante;

import java.util.List;

public class EstudianteDAO implements IEstudiante {
    private final EntityManager em;

    public EstudianteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
            return estudiante;
        }
        return em.merge(estudiante);
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = em.createQuery("from Estudiante", Estudiante.class).getResultList();
        return lista;
    }
}
