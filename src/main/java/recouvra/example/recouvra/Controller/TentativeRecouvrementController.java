package recouvra.example.recouvra.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recouvra.example.recouvra.DTOs.TentativeRecouvrementDTO;
import recouvra.example.recouvra.Entity.TentativeRecouvrement;
import recouvra.example.recouvra.Enum.MethodeRecouvrement;
import recouvra.example.recouvra.Enum.StatutRecouvrement;
import recouvra.example.recouvra.Service.TentativeRecouvrementService;

@RestController
@RequestMapping("/api/v1/tentatives")
@CrossOrigin("*")
public class TentativeRecouvrementController {

    private final TentativeRecouvrementService tentativeService;

    public TentativeRecouvrementController(TentativeRecouvrementService tentativeService) {
        this.tentativeService = tentativeService;
    }

    @PostMapping
    public ResponseEntity<TentativeRecouvrement> createTentative(@RequestBody TentativeRecouvrementDTO tentativeDTO) {
        TentativeRecouvrement saved = tentativeService.createTentative(tentativeDTO);
        return ResponseEntity.ok(saved);
    }
}
