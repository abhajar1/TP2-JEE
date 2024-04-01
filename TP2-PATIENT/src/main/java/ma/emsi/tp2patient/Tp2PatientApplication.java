package ma.emsi.tp2patient;

import ma.emsi.tp2patient.entities.*;
import ma.emsi.tp2patient.repositories.ConsultationRepository;
import ma.emsi.tp2patient.repositories.MedecinRepository;
import ma.emsi.tp2patient.repositories.PatientRepository;
import ma.emsi.tp2patient.repositories.RendezVousRepository;
import ma.emsi.tp2patient.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2PatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp2PatientApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository,MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name-> {
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            Stream.of("Aymen","Hanane","Yassmine")
                    .forEach(name-> {
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Hassan");

            Medecin medecin=medecinRepository.findByNom("Yassmine");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            RendezVous saveDRDV= hospitalService.saveRendezVous(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            //consultation.setDateConsultation(rendezVous1.getDate());
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ... ");
            hospitalService.saveConsultation(consultation);

        };
    }
}
