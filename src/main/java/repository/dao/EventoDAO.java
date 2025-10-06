package repository.dao;

import entities.Evento;
import jakarta.persistence.EntityManager;
import repository.IEstudiante;
import repository.IEvento;

import java.util.List;

public class EventoDAO implements IEvento {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Evento guardar(Evento evento) {
        if(evento.getIdevento()==null) {
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
            return evento;
        }
        return em.merge(evento);
    }

    @Override
    public List<Evento> listarEventos() {
        List<Evento> eventos = em.createQuery("from Evento", Evento.class).getResultList();
        return eventos;
    }
}
