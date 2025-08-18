package recouvra.example.recouvra.Entity;

import jakarta.persistence.*;

@Entity
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;
}