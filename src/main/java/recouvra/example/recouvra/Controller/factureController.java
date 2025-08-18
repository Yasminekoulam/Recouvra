package recouvra.example.recouvra.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import recouvra.example.recouvra.DTOs.DashboardRecouvrementDTO;
import recouvra.example.recouvra.DTOs.FactureDTO;
import recouvra.example.recouvra.Repository.FactureRepository;
import recouvra.example.recouvra.Service.FactureService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/factures")
public class factureController {
    private final FactureRepository factureRepository;
    private final FactureService factureService;

    public factureController(FactureRepository factureRepository,FactureService factureService) {
        this.factureRepository = factureRepository;
        this.factureService = factureService;
    }
    @GetMapping("/retard")
    public List<FactureDTO> getFactures() {
        return factureRepository.getFacturesEnRetard();
    }
    @GetMapping("/retard/count")
    public long getNombreFacturesEnRetard() {
        return factureService.getNombreFacturesEnRetard();
    }
    @GetMapping("/retard/montant-total")
    public double getMontantTotalFacturesEnRetard() {
        return factureService.getMontantTotalFacturesEnRetard();
    }
    @GetMapping("/dashboard")
    public DashboardRecouvrementDTO getDashboardData() {
        DashboardRecouvrementDTO dashboard = new DashboardRecouvrementDTO();
        dashboard.setNombreFacturesEnRetard(factureService.getNombreFacturesEnRetard());
        dashboard.setMontantTotalEnRetard(factureService.getMontantTotalFacturesEnRetard());
        dashboard.setFacturesEnRetard(factureRepository.getFacturesEnRetard());
        return dashboard;
    }
}
