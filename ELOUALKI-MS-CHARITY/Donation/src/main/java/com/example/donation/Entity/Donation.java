package com.example.donation.Entity;

import com.example.donation.MODEL.Organization;
import com.example.donation.MODEL.User;
import jakarta.persistence.*;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates a unique ID
    private Long id;
  private Long userId;

    private String donor;  // Name of the donor
    private int amount; // Amount donated
  @Transient
  private Organization organisation;
  @Transient
  private User users;



/*  @ManyToOne // Utilisez ManyToOne car plusieurs dons peuvent être faits par le même utilisateur
  @JoinColumn(name = "idUser") // La clé étrangère pour lier Donation à User
  private Users user;

  @ManyToOne // Un don est lié à une organisation
  @JoinColumn(name = "idOrg") // La clé étrangère pour lier Donation à Organization
  private Organization organization;*/
    // Default constructor
    public Donation() {}

    // Constructor with parameters


    public Donation(Long id, String donor, int amount) {
        this.id = id;
        this.donor = donor;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
