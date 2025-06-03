package com.indra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;

public class OrganizadorTest {
    private Organizador organizador;

    @BeforeEach
    public void setUp() {
        organizador = new Organizador("Juan", "12345678A", "juan@email.com", "123456789");
    }

    @Test
    public void testOrganizarEventoOnline() {
        int id = 1, idEO = 10;
        Evento.Categoria categoria = Evento.Categoria.CONFERENCIA;
        Time duracion = Time.valueOf("01:00:00");
        LocalDate fecha = LocalDate.now();
        String nombre = "Evento Online";
        String url = "https://evento.com";
        String plataforma = "Zoom";

        // Ajuste: el constructor de EventoOnline no recibe el organizador
        EventoOnline eventoOnline = new EventoOnline(id, idEO, categoria, duracion, fecha, nombre, url, plataforma);
        organizador.organizarEvento(eventoOnline);

        assertEquals(1, organizador.getEventosOrganizados().size());
        assertTrue(organizador.getEventosOrganizados().get(0) instanceof EventoOnline);
        assertEquals(nombre, organizador.getEventosOrganizados().get(0).getNombre());
    }

    @Test
    public void testOrganizarEventoPresencial() {
        int id = 2, idEP = 20;
        Evento.Categoria categoria = Evento.Categoria.TALLER;
        Time duracion = Time.valueOf("02:00:00");
        LocalDate fecha = LocalDate.now();
        String nombre = "Evento Presencial";
        String ciudad = "Madrid";
        String provincia = "Madrid";
        String pais = "España";

        // Ajuste: el constructor de EventoPresencial no recibe el organizador
        EventoPresencial eventoPresencial = new EventoPresencial(id, idEP, categoria, duracion, fecha, nombre, ciudad, provincia, pais);
        organizador.organizarEvento(eventoPresencial);

        assertEquals(1, organizador.getEventosOrganizados().size());
        assertTrue(organizador.getEventosOrganizados().get(0) instanceof EventoPresencial);
        assertEquals(nombre, organizador.getEventosOrganizados().get(0).getNombre());
    }

    @Test
    public void testCancelarEvento() {
        int id = 3, idEO = 30;
        Evento.Categoria categoria = Evento.Categoria.CONFERENCIA;
        Time duracion = Time.valueOf("01:00:00");
        LocalDate fecha = LocalDate.now();
        String nombre = "Evento Online";
        String url = "https://evento.com";
        String plataforma = "Zoom";

        // Ajuste: el constructor de EventoOnline no recibe el organizador
        EventoOnline eventoOnline = new EventoOnline(id, idEO, categoria, duracion, fecha, nombre, url, plataforma);
        organizador.organizarEvento(eventoOnline);
        Evento evento = organizador.getEventosOrganizados().get(0);

        organizador.cancelarEvento(evento);

        assertEquals(0, organizador.getEventosOrganizados().size());
    }

    @Test
    public void testModificarEventoOnline() {
        int id = 4, idEO = 40;
        Evento.Categoria categoria = Evento.Categoria.CONFERENCIA;
        Time duracion = Time.valueOf("01:00:00");
        LocalDate fecha = LocalDate.now();
        String nombre = "Evento Online";
        String url = "https://evento.com";
        String plataforma = "Zoom";

        // Crear y organizar el evento online (ajustado: sin organizador en el constructor)
        EventoOnline eventoOnline = new EventoOnline(id, idEO, categoria, duracion, fecha, nombre, url, plataforma);
        organizador.organizarEvento(eventoOnline);

        String nuevoNombre = "Nuevo Evento Online";
        String nuevaFecha = fecha.plusDays(1).toString();
        String nuevaDuracion = "02:00:00";
        String nuevaUrl = "https://nuevoevento.com";
        String nuevaPlataforma = "Teams";

        organizador.modificarEventoOnline(id, nuevoNombre, nuevaFecha, nuevaDuracion, nuevaUrl, nuevaPlataforma);

        EventoOnline eventoOnlineModificado = (EventoOnline) organizador.getEventosOrganizados().get(0);
        assertEquals(nuevoNombre, eventoOnlineModificado.getNombre());
        assertEquals(LocalDate.parse(nuevaFecha), eventoOnlineModificado.getFecha());
        assertEquals(Time.valueOf(nuevaDuracion), eventoOnlineModificado.getDuracion());
        assertEquals(nuevaUrl, eventoOnlineModificado.getUrl());
        assertEquals(nuevaPlataforma, eventoOnlineModificado.getPlataforma());
        assertEquals(id, eventoOnlineModificado.getIdEO());
    }

    @Test
    public void testModificarEventoPresencial() {
        int id = 5, idEP = 50;
        Evento.Categoria categoria = Evento.Categoria.TALLER;
        Time duracion = Time.valueOf("01:00:00");
        LocalDate fecha = LocalDate.now();
        String nombre = "Evento Presencial";
        String ciudad = "Madrid";
        String provincia = "Madrid";
        String pais = "España";

        // Crear y organizar el evento presencial (ajustado: sin organizador en el constructor)
        EventoPresencial eventoPresencial = new EventoPresencial(id, idEP, categoria, duracion, fecha, nombre, ciudad, provincia, pais);
        organizador.organizarEvento(eventoPresencial);

        String nuevoNombre = "Nuevo Evento Presencial";
        String nuevaFecha = fecha.plusDays(2).toString();
        String nuevaDuracion = "03:00:00";
        String nuevaCiudad = "Barcelona";
        String nuevaProvincia = "Barcelona";
        String nuevoPais = "España";

        organizador.modificarEventoPresencial(id, nuevoNombre, nuevaFecha, nuevaDuracion, nuevaCiudad, nuevaProvincia, nuevoPais);

        EventoPresencial eventoPresencialModificado = (EventoPresencial) organizador.getEventosOrganizados().get(0);
        assertEquals(nuevoNombre, eventoPresencialModificado.getNombre());
        assertEquals(LocalDate.parse(nuevaFecha), eventoPresencialModificado.getFecha());
        assertEquals(Time.valueOf(nuevaDuracion), eventoPresencialModificado.getDuracion());
        assertEquals(nuevaCiudad, eventoPresencialModificado.getCiudad());
        assertEquals(nuevaProvincia, eventoPresencialModificado.getProvincia());
        assertEquals(nuevoPais, eventoPresencialModificado.getPais());
    }
}
