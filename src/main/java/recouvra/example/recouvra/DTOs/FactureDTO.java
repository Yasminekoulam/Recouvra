package recouvra.example.recouvra.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FactureDTO {
    @JsonProperty("N° Facture")
    private Long numeroFacture;
    @JsonProperty("Client")
    private String nomClient;
    @JsonProperty("Montant")
    private BigDecimal montant;
    @JsonProperty("Échéance")
    private Date dateEcheance;
    @JsonProperty("Statut")
    private String statut;
    @JsonProperty("Dernière tentative")
    private Date derniereTentative;
}