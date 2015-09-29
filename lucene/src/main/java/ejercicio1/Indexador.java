package ejercicio1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexador {
	private static final String INDICES = "indexes";
	private static final String ARCHIVOS = "../materiales/data2";

	public static void main(String[] args) throws Exception {
		new Indexador().iniciar();
	}

	public void iniciar() throws Exception {
		Analyzer analyzer = new SpanishAnalyzer();

		Directory directory = FSDirectory.open(new File(INDICES).toPath());

		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		final IndexWriter iwriter = new IndexWriter(directory, config);

		Files.walkFileTree(new File(ARCHIVOS).toPath(), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				try {
					indexDoc(iwriter, file, attrs.lastModifiedTime().toMillis());
				} catch (Exception e) {
					e.printStackTrace();
				}
				return FileVisitResult.CONTINUE;
			}

			private void indexDoc(IndexWriter iwriter, Path file, long millis) throws Exception {
				Document doc = new Document();
				String text = new String(Files.readAllBytes(file), "UTF-8");
				doc.add(new Field("contenido", text, TextField.TYPE_NOT_STORED));
				iwriter.addDocument(doc);
			}
		});


		iwriter.close();
	}
}
