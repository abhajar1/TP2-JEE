package ma.emsi.tp2patient.repositories;

import ma.emsi.tp2patient.entities.Medecin;
import ma.emsi.tp2patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long>{
    Medecin findByNom(String nom);
}
