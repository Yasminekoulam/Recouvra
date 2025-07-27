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
public class BandeReception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateReception;

    @OneToOne
    @JoinColumn(name = "bande_livraison_id", unique = true)
    private BandeLivraison bandeLivraison;

    @OneToMany(mappedBy = "bandeReception")
    private Set<Facture> factures;
}

