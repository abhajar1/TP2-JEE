package ma.emsi.tp2patient.repositories;

import ma.emsi.tp2patient.entities.Patient;
import ma.emsi.tp2patient.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String>{
}
