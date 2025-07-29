package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recouvra.example.recouvra.Entity.BandeReception;

public interface BandeReceptionRepository extends JpaRepository<BandeReception, Long> {
}
