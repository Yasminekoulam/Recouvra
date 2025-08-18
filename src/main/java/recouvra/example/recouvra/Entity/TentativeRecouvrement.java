package recouvra.example.recouvra.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import recouvra.example.recouvra.Enum.MethodeRecouvrement;
import recouvra.example.recouvra.Enum.StatutRecouvrement;
import java.time.LocalDateTime;
import java.util.Date;

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

    private Date date;

    @Enumerated(EnumType.STRING)
    private MethodeRecouvrement methode;

    @Enumerated(EnumType.STRING)
    private StatutRecouvrement statut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
}
