package com.example.policyframework.service.datasource;

import com.example.policyframework.service.schemareader.Schema;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class ServiceDispatcher {
    private final RestApiService restApiService;
    private final KafkaService kafkaService;

    public ServiceDispatcher(RestApiService restApiService, KafkaService kafkaService) {
        this.restApiService = restApiService;
        this.kafkaService = kafkaService;
    }

    public Flux<Map<String, Object>> dispatchService(Schema.DataSource dataSource) {
        if (dataSource.getType().equals("REST_API")) {
             return restApiService.fetchData(dataSource.getDetails().getApiDetails());
        } else if (dataSource.getType().equals("Kafka")) {
            return kafkaService.fetchData(dataSource.getDetails().getKafkaDetails());
        } else {
            return Flux.error(new UnsupportedOperationException("Unsupported data source type: " + dataSource.getType()));
        }

    }
}

