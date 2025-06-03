package com.indra;
import java.util.ArrayList;
public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private ArrayList <Evento> eventosInscrito;

    public Usuario(String nombre, String apellidos, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.eventosInscrito = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Evento> getEventosInscrito() {
        return eventosInscrito;
    }

    public void setEventosInscrito(ArrayList<Evento> eventosInscrito) {
        this.eventosInscrito = eventosInscrito;
    }
    public void inscribirEvento(Evento evento) {
        if (!this.eventosInscrito.contains(evento)) {
            evento.realizarInscripcion(this);
            this.eventosInscrito.add(evento);
        }
        else {
            System.out.println("Ya estás inscrito en este evento.");
        }
    }
    public void cancelarInscripcion(Evento evento) {
        if(this.eventosInscrito.contains(evento)) {
            evento.cancelarInscripcion(this);
            this.eventosInscrito.remove(evento);
        }else {
            System.out.println("No estás inscrito en este evento.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
