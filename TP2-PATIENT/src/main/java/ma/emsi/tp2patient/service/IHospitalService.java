package ma.emsi.tp2patient.service;

import ma.emsi.tp2patient.entities.Consultation;
import ma.emsi.tp2patient.entities.Medecin;
import ma.emsi.tp2patient.entities.Patient;
import ma.emsi.tp2patient.entities.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
