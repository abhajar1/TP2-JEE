package ma.emsi.tp2patient.service;

import jakarta.transaction.Transactional;
import ma.emsi.tp2patient.entities.Consultation;
import ma.emsi.tp2patient.entities.Medecin;
import ma.emsi.tp2patient.entities.Patient;
import ma.emsi.tp2patient.entities.RendezVous;
import ma.emsi.tp2patient.repositories.ConsultationRepository;
import ma.emsi.tp2patient.repositories.MedecinRepository;
import ma.emsi.tp2patient.repositories.PatientRepository;
import ma.emsi.tp2patient.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,
    ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository=medecinRepository;
        this.rendezVousRepository=rendezVousRepository;
        this.consultationRepository=consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
