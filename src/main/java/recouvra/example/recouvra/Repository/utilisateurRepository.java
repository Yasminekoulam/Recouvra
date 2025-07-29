package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recouvra.example.recouvra.Entity.utilisateur;

public interface utilisateurRepository extends JpaRepository<utilisateur, Long> {
}
