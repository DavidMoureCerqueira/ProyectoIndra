package com.indra;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Usuario usuario;
    private EventoOnline eventoOnline;
    private EventoPresencial eventoPresencial;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Ana", "García", "ana@email.com", "987654321");
        eventoOnline = new EventoOnline(1, 10, Evento.Categoria.CONFERENCIA, java.sql.Time.valueOf("01:00:00"), java.time.LocalDate.now(), "Evento Online", "https://evento.com", "Zoom");
        eventoPresencial = new EventoPresencial(2, 20, Evento.Categoria.TALLER, java.sql.Time.valueOf("02:00:00"), java.time.LocalDate.now(), "Evento Presencial", "Madrid", "Madrid", "España");
    }

    @Test
    public void testInscribirEvento() {
        usuario.inscribirEvento(eventoOnline);
        assertEquals(1, usuario.getEventosInscrito().size());
        assertTrue(usuario.getEventosInscrito().contains(eventoOnline));
    }

    @Test
    public void testNoInscribirEventoDuplicado() {
        usuario.inscribirEvento(eventoOnline);
        usuario.inscribirEvento(eventoOnline); // Intento duplicado
        assertEquals(1, usuario.getEventosInscrito().size());
    }

    @Test
    public void testCancelarInscripcion() {
        usuario.inscribirEvento(eventoPresencial);
        usuario.cancelarInscripcion(eventoPresencial);
        assertEquals(0, usuario.getEventosInscrito().size());
    }

    @Test
    public void testCancelarInscripcionNoExistente() {
        usuario.cancelarInscripcion(eventoOnline); // No estaba inscrito
        assertEquals(0, usuario.getEventosInscrito().size());
    }

    @Test
    public void testSettersAndGetters() {
        usuario.setNombre("Pedro");
        usuario.setApellidos("López");
        usuario.setEmail("pedro@email.com");
        usuario.setTelefono("111222333");
        usuario.setId(99);
        assertEquals("Pedro", usuario.getNombre());
        assertEquals("López", usuario.getApellidos());
        assertEquals("pedro@email.com", usuario.getEmail());
        assertEquals("111222333", usuario.getTelefono());
        assertEquals(99, usuario.getId());
    }

    @Test
    public void testSetEventosInscrito() {
        ArrayList<Evento> lista = new ArrayList<>();
        lista.add(eventoOnline);
        usuario.setEventosInscrito(lista);
        assertEquals(1, usuario.getEventosInscrito().size());
        assertTrue(usuario.getEventosInscrito().contains(eventoOnline));
    }
}
