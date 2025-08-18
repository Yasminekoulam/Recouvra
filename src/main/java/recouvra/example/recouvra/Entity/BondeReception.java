package recouvra.example.recouvra.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bande_reception")
public class BondeReception {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateReception;

    @OneToOne
    @JoinColumn(name = "bonde_livraison_id", unique = true)
    private BondeLivraison bondeLivraison;

    @OneToMany(mappedBy = "bondeReception")
    private Set<Facture> factures;
}

