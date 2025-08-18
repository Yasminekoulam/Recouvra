package recouvra.example.recouvra.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bande_livraison")
public class BondeLivraison {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateLivraison;
    private String transporteur;
    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "bonde_commande_id")
    private BondeCommande bondeCommande; // Même nom que dans mappedBy

    @OneToOne(mappedBy = "bondeLivraison")
    private BondeReception bondeReception;
}