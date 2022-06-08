package com.medicalclinc.medicalclinc.service;

import com.medicalclinc.medicalclinc.model.entities.Appointment;
import com.medicalclinc.medicalclinc.model.entities.Patient;
import com.medicalclinc.medicalclinc.model.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Appointment> findPatientHistory(Long patientId) {
        Optional<Patient> patient= patientRepository.findById(patientId);
        if(patient.isPresent()){
            return patient.get().getAppointmentList();
        }
      return null;
    }
}
