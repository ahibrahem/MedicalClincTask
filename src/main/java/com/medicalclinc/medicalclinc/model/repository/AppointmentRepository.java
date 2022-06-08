package com.medicalclinc.medicalclinc.model.repository;

import com.medicalclinc.medicalclinc.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    @Query(value = "SELECT * FROM appointments WHERE DATE = ?1", nativeQuery = true)
    List<Appointment> findAppointmentByDate(Date date);

    @Query(value = "SELECT * FROM appointments WHERE PATIENT_ID = ?1", nativeQuery = true)
    List<Appointment> findAppointmentByPatient(long patientId);
}
