package recouvra.example.recouvra.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recouvra.example.recouvra.Entity.Client;
import recouvra.example.recouvra.Service.ClientService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clients")
public class clientController {

    private final ClientService clientService;

    public clientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<String> ajouterClient(@RequestBody Client client) {
        clientService.saveClient(client);
        System.out.println("Client reçu : " + client.getNom());
        return ResponseEntity.ok("Client ajouté");
    }
}

