package com.medicalclinc.medicalclinc.controller;


import com.medicalclinc.medicalclinc.model.entities.Appointment;
import com.medicalclinc.medicalclinc.model.entities.Patient;
import com.medicalclinc.medicalclinc.model.repository.PatientRepository;
import com.medicalclinc.medicalclinc.service.AppointmentService;
import com.medicalclinc.medicalclinc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MedicalClincController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @GetMapping("/appointments")
    public ResponseEntity list() {
        try {
            List<Appointment> result = appointmentService.findAllAppointments();
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addApointment")
    public ResponseEntity add(@RequestBody Appointment appointment) {
      try {
          String result = appointmentService.saveAppointment(appointment);
          return new ResponseEntity(result, HttpStatus.OK);
      }catch (Exception ex){
          return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("/cancelAppointment")
    public ResponseEntity cancelAppointment(@RequestParam Long id,@RequestParam long reason) {
        try {
            boolean result = appointmentService.cancelAppointment(id,reason);
            if(result)
                return new ResponseEntity("Appointment was canceled", HttpStatus.OK);
            else
               return new ResponseEntity("Patient Id not found", HttpStatus.NOT_FOUND );
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findAppointmentByDate")
    public ResponseEntity findAppointmentByDate(@RequestParam
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        try {
            List<Appointment> result = appointmentService.findAppointmentsByDate(date);
                return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findAppointmentByPatient")
    public ResponseEntity findAppointmentByPatient(@RequestParam Long patientId) {
        try {
            List<Appointment> result = appointmentService.findAppointmentsByPatientId(patientId);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findPatientHistory")
    public ResponseEntity findPatientHistory(@RequestParam Long patientId) {
        try {
            List<Appointment> result = patientService.findPatientHistory(patientId);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
