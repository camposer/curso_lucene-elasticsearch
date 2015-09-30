package repository;

import java.util.List;

import model.elasticsearch.Libro;

public interface LibroRepositoryCustom {
	List<Libro> findAlgo();
}
