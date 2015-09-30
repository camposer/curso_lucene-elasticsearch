package repository;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ElasticsearchConfig;
import model.elasticsearch.Libro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ElasticsearchConfig.class })
public class LibroRepositoryTest {
	@Autowired
	private LibroRepository libroRepository;
	
	
	@Test
	public void save() {
		Libro libro = new Libro();
		libro.setNombre("nombre");
		libro.setContenido("contenido");
		libro.setFecha(new Date());
		libro.setTipo(Libro.Tipo.CLASICO);
		
		libro = libroRepository.save(libro); // Indexando el libro
		
		Assert.assertNotNull(libro.getId());
	}
	
	@Test
	public void findAll() {
		long count = libroRepository.count(); 
		
		Libro libro = new Libro();
		libro.setNombre("nombre");
		libro.setContenido("contenido");
		libro.setFecha(new Date());
		libro.setTipo(Libro.Tipo.CLASICO);
		
		libro = libroRepository.save(libro); // Indexando el libro
		
		Assert.assertTrue(libroRepository.count() - count == 1);
	}


	@Test
	public void findByNombre() {
		Libro libro = new Libro();
		libro.setNombre("nombre");
		libro.setContenido("contenido");
		libro.setFecha(new Date());
		libro.setTipo(Libro.Tipo.CLASICO);
		
		libro = libroRepository.save(libro); // Indexando el libro
		
		int size = libroRepository.findByNombre("nombre").size();
		Assert.assertTrue(size > 0);
	}

	@Test
	public void findText() {
		Libro libro = new Libro();
		libro.setNombre("nuevonombre");
		libro.setContenido("contenido");
		libro.setFecha(new Date());
		libro.setTipo(Libro.Tipo.CLASICO);
		
		libro = libroRepository.save(libro); // Indexando el libro
		
		List<Libro> libros = libroRepository.findText("+nombre:nombre -contenido:contenido");
		int size = libros.size();
		
		Assert.assertTrue(size > 0);
		System.out.println(libros.get(0).getContenido());
	}

	@Test 
	public void findAlgo() {
		List<Libro> libros = libroRepository.findAlgo();
		Assert.assertTrue(libros.size() == 1);
	}
	
}



