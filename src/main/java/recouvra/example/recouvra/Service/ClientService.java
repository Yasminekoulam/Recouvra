package recouvra.example.recouvra.Service;

import recouvra.example.recouvra.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recouvra.example.recouvra.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //Ajouter un client
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    //Récupérer tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    //Récupérer un client par ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    //Supprimer un client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    //Mettre à jour un client
    public Client updateClient(Long id, Client updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.setNom(updatedClient.getNom());
            client.setEmail(updatedClient.getEmail());
            client.setTel(updatedClient.getTel());
            client.setAdresse(updatedClient.getAdresse());
            return clientRepository.save(client);
        }).orElse(null);
    }

    //Rechercher par nom
    public List<Client> findByNom(String nom) {
        return clientRepository.findByNom(nom);
    }
}

