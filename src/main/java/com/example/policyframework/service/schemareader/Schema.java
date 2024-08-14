package com.example.policyframework.service.schemareader;


import java.util.List;
import java.util.Map;
public class Schema {
    private List<DataSource> dataSources;
    private ProcessingRules processingRules;
    private ErrorHandling errorHandling;

    // Getters and Setters
    public List<DataSource> getDataSources() {
        return dataSources;
    }

    public void setDataSources(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public ProcessingRules getProcessingRules() {
        return processingRules;
    }

    public void setProcessingRules(ProcessingRules processingRules) {
        this.processingRules = processingRules;
    }

    public ErrorHandling getErrorHandling() {
        return errorHandling;
    }

    public void setErrorHandling(ErrorHandling errorHandling) {
        this.errorHandling = errorHandling;
    }

    public static class DataSource {
        private String id;
        private String type;
        private DataSourceDetails details;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataSourceDetails getDetails() {
            return details;
        }

        public void setDetails(DataSourceDetails details) {
            this.details = details;
        }

        public static class DataSourceDetails {
            private ApiDetails apiDetails;
            private KafkaDetails kafkaDetails;

            // Getters and Setters
            public ApiDetails getApiDetails() {
                return apiDetails;
            }

            public void setApiDetails(ApiDetails apiDetails) {
                this.apiDetails = apiDetails;
            }

            public KafkaDetails getKafkaDetails() {
                return kafkaDetails;
            }

            public void setKafkaDetails(KafkaDetails kafkaDetails) {
                this.kafkaDetails = kafkaDetails;
            }
        }

        public static class ApiDetails {
            private String method;
            private String url;
            private Map<String, String> headers;
            private Map<String, String> params;
            private String redisKey;

            // Getters and Setters
            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Map<String, String> getHeaders() {
                return headers;
            }

            public void setHeaders(Map<String, String> headers) {
                this.headers = headers;
            }

            public Map<String, String> getParams() {
                return params;
            }

            public void setParams(Map<String, String> params) {
                this.params = params;
            }

            public String getRedisKey() {
                return redisKey;
            }

            public void setRedisKey(String redisKey) {
                this.redisKey = redisKey;
            }
        }

        public static class KafkaDetails {
            private String topic;
            private String broker;
            private String redisKey;

            // Getters and Setters
            public String getTopic() {
                return topic;
            }

            public void setTopic(String topic) {
                this.topic = topic;
            }

            public String getBroker() {
                return broker;
            }

            public void setBroker(String broker) {
                this.broker = broker;
            }

            public String getRedisKey() {
                return redisKey;
            }

            public void setRedisKey(String redisKey) {
                this.redisKey = redisKey;
            }
        }
    }

    public static class ProcessingRules {
        private List<Normalization> normalization;
        private Aggregation aggregation;

        // Getters and Setters
        public List<Normalization> getNormalization() {
            return normalization;
        }

        public void setNormalization(List<Normalization> normalization) {
            this.normalization = normalization;
        }

        public Aggregation getAggregation() {
            return aggregation;
        }

        public void setAggregation(Aggregation aggregation) {
            this.aggregation = aggregation;
        }

        public static class Normalization {
            private String sourceId;
            private List<NormalizationRule> rules;

            // Getters and Setters
            public String getSourceId() {
                return sourceId;
            }

            public void setSourceId(String sourceId) {
                this.sourceId = sourceId;
            }

            public List<NormalizationRule> getRules() {
                return rules;
            }

            public void setRules(List<NormalizationRule> rules) {
                this.rules = rules;
            }

            public static class NormalizationRule {
                private String fieldName;
                private String transformation;
                private String format;

                // Getters and Setters
                public String getFieldName() {
                    return fieldName;
                }

                public void setFieldName(String fieldName) {
                    this.fieldName = fieldName;
                }

                public String getTransformation() {
                    return transformation;
                }

                public void setTransformation(String transformation) {
                    this.transformation = transformation;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }
            }
        }

        public static class Aggregation {
            private String aggregateInto;
            private List<AggregationRule> rules;

            // Getters and Setters
            public String getAggregateInto() {
                return aggregateInto;
            }

            public void setAggregateInto(String aggregateInto) {
                this.aggregateInto = aggregateInto;
            }

            public List<AggregationRule> getRules() {
                return rules;
            }

            public void setRules(List<AggregationRule> rules) {
                this.rules = rules;
            }

            public static class AggregationRule {
                private String fieldName;
                private String aggregationMethod;
                private String separator;
                private String customLogic;

                // Getters and Setters
                public String getFieldName() {
                    return fieldName;
                }

                public void setFieldName(String fieldName) {
                    this.fieldName = fieldName;
                }

                public String getAggregationMethod() {
                    return aggregationMethod;
                }

                public void setAggregationMethod(String aggregationMethod) {
                    this.aggregationMethod = aggregationMethod;
                }

                public String getSeparator() {
                    return separator;
                }

                public void setSeparator(String separator) {
                    this.separator = separator;
                }

                public String getCustomLogic() {
                    return customLogic;
                }

                public void setCustomLogic(String customLogic) {
                    this.customLogic = customLogic;
                }
            }
        }
    }

    public static class ErrorHandling {
        private int retryCount;
        private String fallbackService;
        private boolean logErrors;

        // Getters and Setters
        public int getRetryCount() {
            return retryCount;
        }

        public void setRetryCount(int retryCount) {
            this.retryCount = retryCount;
        }

        public String getFallbackService() {
            return fallbackService;
        }

        public void setFallbackService(String fallbackService) {
            this.fallbackService = fallbackService;
        }

        public boolean isLogErrors() {
            return logErrors;
        }

        public void setLogErrors(boolean logErrors) {
            this.logErrors = logErrors;
        }
    }
}
