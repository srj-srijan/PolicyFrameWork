
package com.example.policyframework.service.datasource;

import com.example.policyframework.service.schemareader.Schema;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;

import java.util.Collections;
import java.util.Map;

@Service
public class KafkaService {
    private final ReceiverOptions<String, Map<String, Object>> receiverOptions;

    public KafkaService(Schema.DataSource.KafkaDetails details) {
        Map<String, Object> props = KafkaConfiguration.getConsumerProps(details.getBroker());
        this.receiverOptions = ReceiverOptions.<String, Map<String, Object>>create(props)
                .subscription(Collections.singleton(details.getTopic()));
    }

    public Flux<Map<String, Object>> fetchData(Schema.DataSource.KafkaDetails details) {
        return KafkaReceiver.create(receiverOptions)
                .receive()
                .map(ReceiverRecord::value);
    }
}

