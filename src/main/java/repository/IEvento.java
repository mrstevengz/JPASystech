package repository;

import entities.Evento;

import java.util.List;

public interface IEvento {
    Evento guardar (Evento evento);
    List<Evento> listarEventos();
}
