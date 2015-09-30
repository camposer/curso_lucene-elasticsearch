

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.BeanConfig;
import config.ElasticsearchConfig;
import model.elasticsearch.Libro;
import service.IndexadorService;

public class Buscador {
	private AnnotationConfigApplicationContext context;
	private IndexadorService indexadorService;
	private Scanner scanner;
	
	public Buscador() {
		context = 
				new AnnotationConfigApplicationContext(
						ElasticsearchConfig.class, BeanConfig.class);

		scanner = new Scanner(System.in);
		indexadorService = context.getBean(IndexadorService.class);
		
		iniciar();
	}
	
	@Override
	protected void finalize() throws Throwable {
		context.close();
	}
	
	public static void main(String[] args) {
		new Buscador();
	}
	
	private void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("1. Buscar");
			System.out.println("2. Salir");
			System.out.print("? ");
			String opcion = scanner.nextLine();

			if (opcion.equals("2")) {
				break;
			} else if (opcion.equals("1")) {
				System.out.print("Texto: ");
				String text = scanner.nextLine();
				buscar(text);
			}
		}
	}

	private void buscar(String text) {
		List<Libro> libros = indexadorService.buscarLibros(text);
		if (libros != null) for (Libro l : libros)
			System.out.println(l);
	}
}
