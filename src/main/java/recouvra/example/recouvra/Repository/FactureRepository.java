package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import recouvra.example.recouvra.DTOs.FactureDTO;
import recouvra.example.recouvra.Entity.Facture;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query("""
    SELECT new recouvra.example.recouvra.DTOs.FactureDTO(
        f.id,
        c.nom,
        f.montant,
        f.dateEcheance,
        'En retard',
        MAX(t.date)
    )
    FROM Facture f
    JOIN f.client c
    LEFT JOIN f.tentatives t
    WHERE f.dateEcheance < CURRENT_DATE AND f.payee = false
    GROUP BY f.id, c.nom, f.montant, f.dateEcheance
""")
    List<FactureDTO> getFacturesEnRetard();
    @Query("SELECT COUNT(f) FROM Facture f WHERE f.dateEcheance < CURRENT_DATE AND f.payee = false")
    long countFacturesEnRetard();
    @Query("SELECT COALESCE(SUM(f.montant), 0) FROM Facture f WHERE f.dateEcheance < CURRENT_DATE AND f.payee = false")
    double sumMontantFacturesEnRetard();
}