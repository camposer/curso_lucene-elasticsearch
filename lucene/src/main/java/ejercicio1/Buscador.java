package ejercicio1;

import java.io.File;
import java.util.Scanner;

import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Buscador {
	private static final String INDICES = "indexes";
	private Directory directory;
	private DirectoryReader ireader;
	private IndexSearcher isearcher;
	private Scanner scanner;
	
	public Buscador() throws Exception {
		scanner = new Scanner(System.in);

		directory = FSDirectory.open(new File(INDICES).toPath());
		ireader = DirectoryReader.open(directory);
		isearcher = new IndexSearcher(ireader);
		
		iniciar();
	}
	
	public static void main(String[] args) throws Exception {
		new Buscador();
	}
	
	private void iniciar() throws Exception {
		while (true) {
			System.out.println();
			System.out.println("1. Buscar");
			System.out.println("2. Salir");
			System.out.print("? ");
			String opcion = scanner.nextLine();

			if (opcion.equals("2")) {
				salir();
				break;
			} else if (opcion.equals("1")) {
				System.out.print("Texto: ");
				String text = scanner.nextLine();
				buscar(text);
			}
		}
	}

	private void salir() throws Exception {
		ireader.close();
		directory.close();
	}

	private void buscar(String text) throws Exception {
		QueryParser parser = new QueryParser("contenido", new SpanishAnalyzer());
		Query query = parser.parse(text);
		
		ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;

		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = isearcher.doc(hits[i].doc);
			System.out.println("score = " + hits[i].score);
			System.out.println("contenido = " + hitDoc.get("contenido"));
			System.out.println("nombre = " + hitDoc.get("nombre"));
			System.out.println();
		}
	}
}
