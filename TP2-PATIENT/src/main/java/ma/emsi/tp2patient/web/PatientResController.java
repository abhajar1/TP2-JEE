package ma.emsi.tp2patient.web;

import ma.emsi.tp2patient.entities.Patient;
import ma.emsi.tp2patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientResController {
    @Autowired
    private PatientRepository patientRepository;
@GetMapping("/patients")
    public List<Patient> patientList()
    {
        return  patientRepository.findAll();
    }
}
