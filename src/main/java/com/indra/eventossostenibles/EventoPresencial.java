package com.indra;

import java.sql.Time;
import java.time.LocalDate;

public class EventoPresencial extends Evento {
    private int idEP;
    private String lugar;
    private String ciudad;
    private String provincia;
    private String pais;

    public EventoPresencial(int id, int idEP, Categoria categoria, Time duracion, LocalDate fecha, String nombre, String ciudad, String provincia, String pais) {
        super(id, categoria, duracion, fecha, nombre);
        this.idEP = idEP;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }
    

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String direccion) {
        this.lugar = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventoPresencial{");
        sb.append(super.toString());
        sb.append(", lugar=").append(lugar);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", provincia=").append(provincia);
        sb.append(", pais=").append(pais);
        sb.append('}');
        return sb.toString();
    }

    public int getIdEP() {
        return idEP;
    }

    public void setIdEP(int idEP) {
        this.idEP = idEP;
    }

}
