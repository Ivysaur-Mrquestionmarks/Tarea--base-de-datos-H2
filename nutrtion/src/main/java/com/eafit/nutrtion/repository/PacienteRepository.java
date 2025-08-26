package com.eafit.nutrtion.repository;

import com.eafit.nutrtion.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    List<Paciente> findByPacienteIdOrderByFechaDesc(Long pacienteId);
    
    Optional<Paciente> findFirstByPacienteIdOrderByFechaDesc(Long pacienteId);
}