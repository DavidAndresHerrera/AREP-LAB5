package edu.escuelaing.arep.server;



import static spark.Spark.*;

import edu.escuelaing.arep.server.bdd.Connection;
import org.json.JSONObject;

public class SparkWeb {


    /**
     * Metodo encargado de obtener los servicios que pide el usuario al servicio
     * @param args
     */
    public static void main(String[] args) {
        port(getPort());
        get("/", (req,res) -> "hello");
        get("/data", (req,res) -> getData());
        post("/insert", (req,res) -> setData(req.body()));
    }


    /**
     * Metodo encargado de insertar datos a la base de datos
     * @param object
     * @return temp, Json con respuesta de insercion
     */
    private static JSONObject setData(String object) {
        Connection conct = new Connection();
        String dato = object.split(":")[1];
        System.out.println(dato.length());
        JSONObject temp = conct.insert(dato.substring(1,dato.length()-4));
        return  temp;
    }

    /**
     * Metodo encargado de obtener los datos de la base de datos
     * @return data, Json con los datos
     */
    private static JSONObject getData(){
        Connection conct = new Connection();
        JSONObject data = conct.getData();
        return data;
    }

    /**
     * Metodo se encarga de retornar el puerto por el cual se va a correr el servidor
     * @return
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    
    
}
