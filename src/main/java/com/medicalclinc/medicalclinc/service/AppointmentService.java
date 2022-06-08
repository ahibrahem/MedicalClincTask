package com.medicalclinc.medicalclinc.service;


import com.medicalclinc.medicalclinc.model.entities.Appointment;
import com.medicalclinc.medicalclinc.model.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    public String saveAppointment(Appointment appointment) {
       try {
           appointmentRepository.save(appointment);
           return "Appointment Saved";
       }catch (Exception ex){
           ex.printStackTrace();
       }
       return null;
    }

    public boolean cancelAppointment(Long id, long reason) {
        Optional<Appointment> appointmentObj = appointmentRepository.findById(id);
        if(appointmentObj.isPresent()){
            Appointment appointment=appointmentObj.get();
            appointment.setStatus(reason);
            appointmentRepository.save(appointment);

            return  true;
        }else{
            return false;
        }

    }

    public List<Appointment> findAppointmentsByDate(Date date) {
        try {
            List<Appointment> appointmentList = appointmentRepository.findAppointmentByDate(date);
            return appointmentList;
        }catch (Exception ex){
            ex.printStackTrace();
        }
      return null;
    }

    public List<Appointment> findAppointmentsByPatientId(long patientId) {
        try {
            List<Appointment> appointmentList = appointmentRepository.findAppointmentByPatient(patientId);
            return appointmentList;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}
