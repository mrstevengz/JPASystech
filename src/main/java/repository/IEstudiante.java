package repository;

import entities.Estudiante;

import java.util.List;

public interface IEstudiante {
    Estudiante guardar(Estudiante estudiante);
    List<Estudiante> listar();
}
