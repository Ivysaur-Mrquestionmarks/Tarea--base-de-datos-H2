package com.eafit.nutrtion.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nutricionista")
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    
    @NotBlank(message = "El número de licencia es obligatorio")
    @Column(name = "numero_licencia", nullable = false, length = 50, unique = true)
    private String numeroLicencia;
    
    @Email(message = "El formato del email no es válido")
    @NotBlank(message = "El email es obligatorio")
    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "especialidad", length = 100)
    private String especialidad;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;
    
    // Relaciones (se definen más adelante)
    // Relación LAZY (carga perezosa) con Pacientes
    @OneToMany(mappedBy = "nutricionista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paciente> pacientes = new ArrayList<>();


    // Relación EAGER (carga inmediata) con Notas
@OneToMany(mappedBy = "nutricionista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<Nota> notas = new ArrayList<>();

// Método helper para añadir notas
public void addNota(Nota nota) {
    notas.add(nota);
    nota.setNutricionista(this);
}

    // Método helper para añadir pacientes
    public void addPaciente(Paciente paciente) {
        pacientes.add(paciente);
        paciente.setNutricionista(this);
    }    
    
    // Constructor vacío requerido por JPA
    public Nutricionista() {
    }
    
    // Constructor con parámetros principales
    public Nutricionista(String nombre, String apellido, String numeroLicencia, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroLicencia = numeroLicencia;
        this.email = email;
    }
    // Getters y setters (omitidos por brevedad)
}

