package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recouvra.example.recouvra.Entity.BandeLivraison;

public interface BandeLivraisonRepository extends JpaRepository<BandeLivraison, Long> {
}
