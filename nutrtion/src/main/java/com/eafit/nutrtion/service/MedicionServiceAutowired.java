package com.eafit.nutrtion.service;

import com.eafit.nutrtion.model.Medicion;
import com.eafit.nutrtion.repository.MedicionRepository;
import com.eafit.nutrtion.repository.PacienteRepository;
import com.eafit.nutrtion.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicionServiceAutowired {
    
    // Inyección de dependencias a nivel de campo usando @Autowired
    @Autowired
    private MedicionRepository medicionRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private NutricionistaRepository nutricionistaRepository;
    
    @Transactional(readOnly = true)
    public List<Medicion> findAll() {
        return medicionRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Medicion> findById(Long id) {
        return medicionRepository.findById(id);
    }
    
    // Otros métodos del servicio (omitidos por brevedad)
}