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
public class BandeLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateLivraison;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "bandeLivraison", cascade = CascadeType.ALL)
    private BandeReception reception;
}

