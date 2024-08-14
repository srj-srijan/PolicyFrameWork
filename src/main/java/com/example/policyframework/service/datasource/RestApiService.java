package com.example.policyframework.service.datasource;

import com.example.policyframework.service.schemareader.Schema;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import org.springframework.http.HttpMethod;

import java.util.Map;

@Service
public class RestApiService {
    private final WebClient webClient;

    public RestApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Flux<Map<String, Object>> fetchData(Schema.DataSource.ApiDetails details) {
        HttpMethod method = HttpMethodUtil.resolve(details.getMethod());
        return webClient.method(method)
                .uri(details.getUrl())
                .headers(headers -> headers.setAll(details.getHeaders()))
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {});
    }
}
