package edu.escuelaing.arep.server.bdd;


import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import edu.escuelaing.arep.server.model.Informacion;
import org.bson.Document;
import org.json.JSONObject;


public class Connection {

    /**
     * Metodo encargado de obtener la informacion de la base de datos
     * @return data, Json
     */

    public JSONObject getData() {
        JSONObject data = new JSONObject();
        MongoClient mongo = new MongoClient("ec2-54-82-175-210.compute-1.amazonaws.com", 27017);
        MongoIterable<String> mongoIterable = mongo.listDatabaseNames();
        MongoDatabase db = mongo.getDatabase("admin");
        MongoCollection<Document> collection = db.getCollection("lab5");
        FindIterable<Document> datos = collection.find();
        int cont = 1;
        System.out.println(db.getCollection("lab5").count());
        for(Document i: datos){
            data.put(String.valueOf(cont), " texto: "+i.get("texto")+", Fecha: "+i.get("fecha"));
            cont ++;
        }

        return data;
    }

    /**
     * Metodo de insertar los datos a la base de datos
     * @param texto
     * @return respuesta, Json
     */
    public JSONObject insert (String texto){
        JSONObject rsp = new JSONObject();
        MongoClient mongo = new MongoClient("ec2-54-82-175-210.compute-1.amazonaws.com", 27017);
        MongoDatabase db = mongo.getDatabase("admin");
        MongoCollection<Document> collection = db.getCollection("lab5");
        Document newDocument = new Document();
        Informacion newInfo = new Informacion(texto);
        newDocument.append("texto",newInfo.getTexto());
        newDocument.append("fecha",newInfo.getDate());
        collection.insertOne(newDocument);
        rsp.put("Insert exitoso", true);
        return rsp;
    }
}
