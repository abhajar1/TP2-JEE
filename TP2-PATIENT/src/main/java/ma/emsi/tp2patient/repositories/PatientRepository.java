package ma.emsi.tp2patient.repositories;

import ma.emsi.tp2patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long>{
    Patient findByNom(String name);
}
