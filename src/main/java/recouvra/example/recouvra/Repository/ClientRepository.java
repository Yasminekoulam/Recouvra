package recouvra.example.recouvra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recouvra.example.recouvra.Entity.Client;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNom(String nom);
}
