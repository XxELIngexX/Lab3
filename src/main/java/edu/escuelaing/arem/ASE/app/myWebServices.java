package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.net.URISyntaxException;

public class myWebServices {
    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpServer.get("/arep",(p) -> {

            String response = "HTTP/1.1 404 NOT FOUND\r\n" // Necesario para los nuevos navegadores
                    + "Content-Type:text/html\r\n"
                    + "\r\n" // Necesario para los nuevos navegadores
                    + "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<style> body {background-color: rgb (255, 122 89)} </style>"
                    + "<body>"
                    + "<h1> arep </h1>"
                    + "</body>"
                    + "</html>";
            return response;
        });
        HttpServer.get("/arsw",(p) -> {

            String response = "HTTP/1.1 404 NOT FOUND\r\n" // Necesario para los nuevos navegadores
                    + "Content-Type:text/html\r\n"
                    + "\r\n" // Necesario para los nuevos navegadores
                    + "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<style> body {background-color: rgb (255, 122 89)} </style>"
                    + "<body>"
                    + "<h1> arsw </h1>"
                    + "</body>"
                    + "</html>";
            return response;
        });
        HttpServer.get("/name", (request) -> {
            String response = "HTTP/1.1 200 OK\r\n" // Estado 200 OK
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<head><title>Ingrese su nombre</title></head>"
                    + "<body>"
                    + "<h1>Ingrese su nombre:</h1>"
                    + "<form action=\"/action/submit\" method=\"post\">"
                    + "<input type=\"submit\" value=\"Enviar\">"
                    + "</form>"
                    + "</body>"
                    + "</html>";
            return response;
        });
        HttpServer.post("/submit", (requestBody) -> {
            Request request = new Request(requestBody);
            String nombre = request.getParameter("nombre");

            String response = "HTTP/1.1 200 OK\r\n" // Estado 200 OK
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<head><title>Resultado</title></head>"
                    + "<body>"
                    + "<h1>¡Hola " + nombre + "!</h1>"
                    + "</body>"
                    + "</html>";


            // Devolver la respuesta HTML al cliente
            return response;
        });







        HttpServer.getInstance().runServer(args);
    }
}
