package recouvra.example.recouvra.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import recouvra.example.recouvra.Enum.MethodeRecouvrement;
import recouvra.example.recouvra.Enum.StatutRecouvrement;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TentativeRecouvrementDTO {
    private Long factureId;
    private Long userId;
    private MethodeRecouvrement methode;
    private StatutRecouvrement statut;
}