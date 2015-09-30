package config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("repository")
public class ElasticsearchConfig {
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchTemplate(client());
     }

    @Bean
    public Client client(){
        TransportClient client= new TransportClient();
        TransportAddress address = new InetSocketTransportAddress("localhost", 9300); 
        client.addTransportAddress(address);
        return client;
    }
}
