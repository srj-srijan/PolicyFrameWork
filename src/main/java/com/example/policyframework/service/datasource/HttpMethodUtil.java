package com.example.policyframework.service.datasource;

import org.springframework.http.HttpMethod;

public class HttpMethodUtil {

    public static HttpMethod resolve(String method) {
        switch (method.toUpperCase()) {
            case "GET":
                return HttpMethod.GET;
            case "POST":
                return HttpMethod.POST;
            case "PUT":
                return HttpMethod.PUT;
            case "DELETE":
                return HttpMethod.DELETE;
            case "PATCH":
                return HttpMethod.PATCH;
            case "OPTIONS":
                return HttpMethod.OPTIONS;
            case "HEAD":
                return HttpMethod.HEAD;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }
}
