package com.medicalclinc.medicalclinc.model.repository;

import com.medicalclinc.medicalclinc.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository  extends JpaRepository<Patient, Long> {
}
