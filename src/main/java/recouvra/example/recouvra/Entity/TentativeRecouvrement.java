package recouvra.example.recouvra.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import recouvra.example.recouvra.Enum.MethodeRecouvrement;
import recouvra.example.recouvra.Enum.StatutRecouvrement;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tentative_recouvrement")
public class TentativeRecouvrement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private MethodeRecouvrement methode;

    @Enumerated(EnumType.STRING)
    private StatutRecouvrement statut;

    private String reponseClient;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
}
