package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionLab1 {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URL = "http://www.omdbapi.com/?apikey=468842bf&t=";

    /**
     * Realiza una solicitud HTTP GET a la API de omdbapi para obtener información de una película.
     *
     * @param title El título de la película que se desea buscar.
     * @return Un objeto StringBuffer que contiene la respuesta de la API en formato JSON.
     * @throws IOException Si ocurre un error al realizar la conexión o procesar la respuesta.
     */
    public StringBuffer getMovie(String title) throws IOException {
        // Construye la URL completa para buscar la película en la API de OMDB
        String toSearch = URL + title;

        // Crea un objeto URL a partir de la cadena de búsqueda
        URL obj = new URL(toSearch);

        // Abre una conexión HTTP con la URL especificada
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Configura la solicitud como un método GET y establece el User-Agent
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // Realiza la conexión implícitamente antes de obtener el código de respuesta
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        // Almacena la respuesta de la API en un objeto StringBuffer
        StringBuffer response = new StringBuffer();

        // Verifica si la solicitud fue exitosa (código de respuesta HTTP 200)
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Lee la respuesta desde el flujo de entrada y la almacena en el StringBuffer
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprime la respuesta por motivos de depuración
            System.out.println(response.toString());
        } else {
            // Imprime un mensaje si la solicitud no fue exitosa
            System.out.println("GET request not worked");
        }

        // Imprime un mensaje indicando que la solicitud GET ha terminado
        System.out.println("GET DONE");

        // Retorna el objeto StringBuffer que contiene la respuesta de la API
        return response;
    }


}
