package recouvra.example.recouvra.Service;

import recouvra.example.recouvra.Entity.Facture;
import recouvra.example.recouvra.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    //Enregistrer une nouvelle facture
    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    //Trouver une facture par ID
    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    //Lister toutes les factures
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    //Supprimer une facture
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    //Mettre à jour une facture
    public Facture updateFacture(Long id, Facture updatedFacture) {
        return factureRepository.findById(id).map(facture -> {
            facture.setMontant(updatedFacture.getMontant());
            facture.setDateEmission(updatedFacture.getDateEmission());
            facture.setDateEcheance(updatedFacture.getDateEcheance());
            facture.setPayee(updatedFacture.isPayee());
            return factureRepository.save(facture);
        }).orElseThrow(() -> new RuntimeException("Facture non trouvée"));
    }

}
