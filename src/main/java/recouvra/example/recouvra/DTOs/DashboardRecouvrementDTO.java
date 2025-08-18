package recouvra.example.recouvra.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardRecouvrementDTO {
    private long nombreFacturesEnRetard;
    private double montantTotalEnRetard;
    private List<FactureDTO> facturesEnRetard;
}
