package service;

import java.util.List;

import model.elasticsearch.Libro;

public interface IndexadorService {
	void indexar();

	List<Libro> buscarLibros(String text);
}
