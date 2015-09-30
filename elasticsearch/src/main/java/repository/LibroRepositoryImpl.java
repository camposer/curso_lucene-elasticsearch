package repository;

import java.util.ArrayList;
import java.util.List;

import model.elasticsearch.Libro;

public class LibroRepositoryImpl implements LibroRepositoryCustom {

	public List<Libro> findAlgo() {
		return new ArrayList<Libro>() {{
			add(new Libro());
		}};
	}

}
