package com.ufcspa.appointment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ufcspa.appointment.model.Appointment;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String>{

}
