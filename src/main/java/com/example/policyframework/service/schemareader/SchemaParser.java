package com.example.policyframework.service.schemareader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;

@Service
public class SchemaParser {

    private final ObjectMapper objectMapper;

    public SchemaParser() {
        this.objectMapper = new ObjectMapper();
    }

    public Schema parseSchema(String schemaPath) throws IOException {
        return objectMapper.readValue(new File(schemaPath), Schema.class);
    }
}
