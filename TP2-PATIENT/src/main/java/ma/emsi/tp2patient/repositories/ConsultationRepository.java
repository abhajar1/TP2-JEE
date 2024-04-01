package ma.emsi.tp2patient.repositories;

import ma.emsi.tp2patient.entities.Consultation;
import ma.emsi.tp2patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long>{
}
