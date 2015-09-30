import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.BeanConfig;
import config.ElasticsearchConfig;
import service.IndexadorService;

public class Indexador {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(
						ElasticsearchConfig.class, BeanConfig.class);
		
		System.out.println("Indexando...");

		Long inicio = new Date().getTime();
		context.getBean(IndexadorService.class).indexar();;
		Long fin = new Date().getTime();
		
		System.out.println("Finalizado... " + (fin - inicio) + " mseg");
		
		context.close();
	}
}
