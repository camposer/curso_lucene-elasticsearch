package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.elasticsearch.Libro;
import repository.LibroRepository;

@Service
public class IndexadorServiceImpl implements IndexadorService {
	private static final String ARCHIVOS = "../materiales/data2";
	@Autowired
	private LibroRepository libroRepository;

	public void indexar() {
		try {
			Files.walkFileTree(new File(ARCHIVOS).toPath(), new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					try {
						indexDoc(file, attrs.lastModifiedTime().toMillis());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void indexDoc(Path file, long millis) throws Exception {
		Libro libro = new Libro();
		libro.setNombre(file.getFileName().toString());
		libro.setContenido(new String(Files.readAllBytes(file), "UTF-8"));
		libro.setFecha(new Date());
		libro.setTipo(Libro.Tipo.CLASICO);
		
		libroRepository.save(libro);
	}

	public List<Libro> buscarLibros(String text) {
		return libroRepository.findText(text);
	}

}
