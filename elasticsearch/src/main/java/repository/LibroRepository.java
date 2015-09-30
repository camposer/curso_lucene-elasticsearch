package repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import model.elasticsearch.Libro;

public interface LibroRepository 
		extends ElasticsearchRepository<Libro, String>, 
		LibroRepositoryCustom {

	List<Libro> findByNombre(String nombre);
	@Query("query_string : { default_field : 'nombre', query : ?1 }}")
	List<Libro> findText(String text);
}
