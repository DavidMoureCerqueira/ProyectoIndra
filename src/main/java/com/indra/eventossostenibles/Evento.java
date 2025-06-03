package com.indra;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Evento {
    private int id;
    private String nombre;
    private LocalDate fecha;
    private Time duracion;
    private Categoria categoria;
    private Organizador organizador;
    private boolean cancelado;
    private ArrayList<Usuario> asistentes;

    public Evento(int id, Categoria categoria, Time duracion, LocalDate fecha, String nombre) {
        this.id = id;
        this.categoria = categoria;
        this.duracion = duracion;
        this.fecha = fecha;
        this.nombre = nombre;
        this.asistentes = new ArrayList<>();
        this.cancelado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }


    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public ArrayList<Usuario> getAsistentes() {
        return asistentes;
    }


    public void setAsistentes(ArrayList<Usuario> asistentes) {
        this.asistentes = asistentes;
    }
    public void realizarInscripcion(Usuario asistente) {
        if (!asistentes.contains(asistente)) {
            asistente.inscribirEvento(this);
            this.asistentes.add(asistente);
        }
        else {
            System.out.println("Ese usuario ya esta inscrito en este evento.");
        }
    }

    public void cancelarInscripcion(Usuario asistente) {
        if (asistentes.contains(asistente)) {
            asistente.cancelarInscripcion(this);
            this.asistentes.remove(asistente);
        }else {
            System.out.println("Ese usuario no esta inscrito en este evento.");
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isCancelado() {
        return cancelado;
    }   

    public void cancelarEvento() {
        this.cancelado = true;
        for (Usuario asistente : asistentes) {
            asistente.cancelarInscripcion(this);
        }
        asistentes.clear();
    }
    public void activarEvento() {
        this.cancelado = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nombre=").append(nombre);
        sb.append(", fecha=").append(fecha);
        sb.append(", duracion=").append(duracion);
        sb.append(", categoria=").append(categoria);
        sb.append(", organizador=").append(organizador);
        sb.append(", asistentes=").append(asistentes);
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

   



    public enum Categoria {
        CONFERENCIA,
        TALLER,
        ACTIVIDAD  
    }
}
