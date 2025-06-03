package com.indra;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class Organizador {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private ArrayList<Evento> eventosOrganizados;
    
    public Organizador(String nombre,  String dni, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.eventosOrganizados = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ArrayList<Evento> getEventosOrganizados() {
        return eventosOrganizados;
    }

    public void setEventosOrganizados(ArrayList<Evento> eventosOrganizados) {
        this.eventosOrganizados = eventosOrganizados;
    }
    public void organizarEvento(Evento evento) {
        evento.activarEvento();
        evento.setOrganizador(this);
        
        this.eventosOrganizados.add(evento);
    }

  
    public void cancelarEvento(Evento evento) {
        this.eventosOrganizados.remove(evento);
        evento.setOrganizador(null);
        evento.cancelarEvento();
    }
    public void modificarEventoOnline(int idEvento, String nuevoNombre, String nuevaFecha, String nuevaDuracion, String nuevaUrl, String nuevaPlataforma) {
        for (Evento elem : eventosOrganizados) {
            if (elem.getId() == idEvento && elem instanceof EventoOnline) {
                elem.setNombre(nuevoNombre);
                elem.setFecha(LocalDate.parse(nuevaFecha));
                elem.setDuracion(Time.valueOf(nuevaDuracion));
                EventoOnline eventoOnline = (EventoOnline) elem;
                eventoOnline.setIdEO(idEvento); 
                eventoOnline.setUrl(nuevaUrl);
                eventoOnline.setPlataforma(nuevaPlataforma);
                break;
            }
            
        }
    }
    public void modificarEventoPresencial(int idEvento, String nuevoNombre, String nuevaFecha, String nuevaDuracion, String nuevaCiudad, String nuevaProvincia, String nuevoPais) {
        for (Evento elem : eventosOrganizados) {
            if (elem.getId() == idEvento && elem instanceof EventoPresencial) {
                elem.setNombre(nuevoNombre);
                elem.setFecha(LocalDate.parse(nuevaFecha));
                elem.setDuracion(Time.valueOf(nuevaDuracion));
                EventoPresencial eventoPresencial = (EventoPresencial) elem;
                eventoPresencial.setCiudad(nuevaCiudad);
                eventoPresencial.setProvincia(nuevaProvincia);
                eventoPresencial.setPais(nuevoPais);
                break;
            }
        }
    }
}

