package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recouvra.example.recouvra.Entity.TentativeRecouvrement;
import java.util.Set;

public interface TentativeRecouvrementRepository extends JpaRepository<TentativeRecouvrement, Long> {
    Set<TentativeRecouvrement> findByFactureId(Long factureId);
}