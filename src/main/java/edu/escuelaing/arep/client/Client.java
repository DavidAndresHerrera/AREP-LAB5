package edu.escuelaing.arep.client;

import static spark.Spark.*;

public class Client {

    public void main(String[] args){
        port(getPort());
        get("/", (req,res) -> load());
        get("/add",(req,res) -> getDatos());
        get("/getData",(req,res) -> getDatos());
    }

    /**
     * Metodo encargado de cargar la pagina principal para el usuario
     * @return outputline
     */
    private static String load() {
        String outputLine = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Formulario</title>"
                + "</head>"
                + "<body>"
                + "<h1>Formulario!</h1>"
                + "<form action=\"/insert\" >"
                + "<label for=\"ftext\">Texto a ingresar:</label><br/>"
                + "<input type=\"text\" id=\"ftext\" name=\"ftext\"><br/>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "</form>"
                +"<form action=\"/getData\" >"
                + "<label for=\"ftext\">Buscar los diez ultimos datos</label><br/>"
                +"<input type=\"submit\" value=\"Submit\">"
                +"</body>"
                +"</html>";

        return outputLine;
    }

    /**
     * Metodo encargado de cargar la pagina de los datos, cuando se consultan
     * @return outputline
     */
    private static String getDatos() {
        String outputLine = "<DOCTYPE html"
                + "<html>"
                + "<title> Datos Consultados</title>"
                + "<body>"
                + "<h1>Los ultimos diez datos son</h1>"
                + "</body>"
                + "</html>";
        return outputLine;
    }

    /**
     * Método que especifica el puerto de la clase
     * @return variable de tipo int con el valor del puerto
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4566;
    }}
