package com.eafit.nutrtion.repository;

import com.eafit.nutrtion.model.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    
    List<Nutricionista> findByPacienteIdOrderByFechaDesc(Long pacienteId);
    
    Optional<Nutricionista> findFirstByPacienteIdOrderByFechaDesc(Long pacienteId);
}