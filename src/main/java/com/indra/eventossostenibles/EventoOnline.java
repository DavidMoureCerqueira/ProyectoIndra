package com.indra;

import java.sql.Time;
import java.time.LocalDate;

public class EventoOnline extends Evento {
    private int idEO;
    private String url;
    private String plataforma;

    public EventoOnline(int id, int idEO, Categoria categoria, Time duracion, LocalDate fecha, String nombre, String url, String plataforma) {
        super(id,categoria, duracion, fecha, nombre);
        this.idEO = idEO;
        this.url = url;
        this.plataforma = plataforma;
    }

    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventoOnline{");
        sb.append(super.toString());
        sb.append(", url=").append(url);
        sb.append(", plataforma=").append(plataforma);
        sb.append('}');
        return sb.toString();
    }

    public int getIdEO() {
        return idEO;
    }

    public void setIdEO(int idEO) {
        this.idEO = idEO;
    }

}
