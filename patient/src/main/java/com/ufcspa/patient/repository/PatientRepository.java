package com.ufcspa.patient.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ufcspa.patient.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

}
