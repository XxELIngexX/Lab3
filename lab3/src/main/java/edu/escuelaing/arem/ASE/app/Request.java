package edu.escuelaing.arem.ASE.app;

import java.util.*;


public class Request {
    private Map<String, String> parameters;

    public Request() {
        parameters = new HashMap<>();
    }

    public Request(String requestBody) {
        parameters = new HashMap<>();
        parseRequestBody(requestBody);
    }

    private void parseRequestBody(String requestBody) {
        String[] params = requestBody.split("&");
        for (String param : params) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 2) {
                parameters.put(keyValue[0], keyValue[1]);
            }
        }
    }

    public String getParameter(String parameterName) {
        return parameters.get(parameterName);
    }
}

