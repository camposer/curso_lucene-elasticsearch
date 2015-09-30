package repository;

import java.util.ArrayList;
import java.util.List;

import model.elasticsearch.Libro;

@SuppressWarnings({ "serial" })
public class LibroRepositoryImpl implements LibroRepositoryCustom {
    
	public List<Libro> findAlgo() {
		// TODO Utilizar template!!
		
		return new ArrayList<Libro>() {{
			add(new Libro());
		}};
	}

}
