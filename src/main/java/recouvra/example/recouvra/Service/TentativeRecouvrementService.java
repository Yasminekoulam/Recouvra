package recouvra.example.recouvra.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recouvra.example.recouvra.DTOs.TentativeRecouvrementDTO;
import recouvra.example.recouvra.Entity.Facture;
import recouvra.example.recouvra.Entity.TentativeRecouvrement;
import recouvra.example.recouvra.Entity.User;
import recouvra.example.recouvra.Repository.FactureRepository;
import recouvra.example.recouvra.Repository.TentativeRecouvrementRepository;
import recouvra.example.recouvra.Repository.UserRepository;

import java.util.Date;

@Service
@Transactional
public class TentativeRecouvrementService {

    private final TentativeRecouvrementRepository tentativeRepository;
    private final FactureRepository factureRepository;
    private final UserRepository userRepository;

    public TentativeRecouvrementService(TentativeRecouvrementRepository tentativeRepository,
                                        FactureRepository factureRepository,
                                        UserRepository userRepository) {
        this.tentativeRepository = tentativeRepository;
        this.factureRepository = factureRepository;
        this.userRepository = userRepository;
    }

    public TentativeRecouvrement createTentative(TentativeRecouvrementDTO tentativeDTO) {
        Facture facture = factureRepository.findById(tentativeDTO.getFactureId())
                .orElseThrow(() -> new RuntimeException("Facture non trouvée"));

        User user = userRepository.findById(tentativeDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        TentativeRecouvrement tentative = new TentativeRecouvrement();
        tentative.setDate(new Date());
        tentative.setMethode(tentativeDTO.getMethode());
        tentative.setStatut(tentativeDTO.getStatut());
        tentative.setFacture(facture);
        tentative.setUser(user);

        return tentativeRepository.save(tentative);
    }
}