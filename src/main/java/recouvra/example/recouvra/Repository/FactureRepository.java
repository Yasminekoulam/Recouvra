package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recouvra.example.recouvra.Entity.Facture;
import java.util.Set;

public interface FactureRepository extends JpaRepository<Facture, Long> {
   // Set<Facture> findByPayeeFalseAndDateEcheanceBefore(java.time.LocalDate date);
    //Cette méthode permet de récupérer les factures impayées dont la date d’échéance est dépassée.
}
