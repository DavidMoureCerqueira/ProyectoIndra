CREATE TABLE Organizador (
    ID_Organizador INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Telefono VARCHAR(15) NOT NULL,
    Email VARCHAR(50) NOT NULL
);
CREATE TABLE Evento (
    ID_Evento INT NOT NULL,
    ID_Organizador INT NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Tipo VARCHAR(15) NOT NULL,
    Fecha DATE NOT NULL,
    Duracion TIME NOT NULL,
    CONSTRAINT PK_Evento PRIMARY KEY (ID_Evento, ID_Organizador),
    CONSTRAINT FK_Evento_Organizador FOREIGN KEY (ID_Organizador)
        REFERENCES Organizador(ID_Organizador),
    CONSTRAINT CHK_Evento_Tipo CHECK (Tipo IN ('conferencia', 'taller', 'actividad'))
);
CREATE TABLE EventoPresencial (
    ID_EventoPresencial INT NOT NULL,
    ID_Evento INT NOT NULL,
    ID_Organizador INT NOT NULL,
    Lugar VARCHAR(25) NOT NULL,
    Ciudad VARCHAR(25) NOT NULL,
    Provincia VARCHAR(25) NOT NULL,
    Pais VARCHAR(25) NOT NULL,
    CONSTRAINT PK_EventoPresencial PRIMARY KEY (ID_EventoPresencial, ID_Evento, ID_Organizador),
    CONSTRAINT FK_EvPresencial_Evento FOREIGN KEY (ID_Evento, ID_Organizador)
        REFERENCES Evento(ID_Evento, ID_Organizador)
);

CREATE TABLE EventoOnline (
    ID_EventoOnline INT NOT NULL,
    ID_Evento INT NOT NULL,
    ID_Organizador INT NOT NULL,
    URL VARCHAR(100) NOT NULL,
    CONSTRAINT PK_EventoOnline PRIMARY KEY (ID_EventoOnline, ID_Evento, ID_Organizador),
    CONSTRAINT FK_EvOnline_Evento FOREIGN KEY (ID_Evento, ID_Organizador)
        REFERENCES Evento(ID_Evento, ID_Organizador)
);

CREATE TABLE Usuario (
    ID_Usuario INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Contraseña VARCHAR(25) NOT NULL
);

CREATE TABLE Inscribir (
    ID_Usuario INT NOT NULL,
    ID_Evento INT NOT NULL,
    ID_Organizador INT NOT NULL,
    CONSTRAINT PK_Inscribir PRIMARY KEY (ID_Usuario, ID_Evento, ID_Organizador),
    CONSTRAINT FK_Inscribir_Usuario FOREIGN KEY (ID_Usuario)
        REFERENCES Usuario(ID_Usuario),
    CONSTRAINT FK_Inscribir_Evento FOREIGN KEY (ID_Evento, ID_Organizador)
        REFERENCES Evento(ID_Evento, ID_Organizador)
);
