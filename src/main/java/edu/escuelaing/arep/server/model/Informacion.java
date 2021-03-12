package edu.escuelaing.arep.server.model;

import java.util.Date;

public class Informacion {

    private String texto;
    private Date date;

    public Informacion(String texto) {
        this.texto = texto;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
