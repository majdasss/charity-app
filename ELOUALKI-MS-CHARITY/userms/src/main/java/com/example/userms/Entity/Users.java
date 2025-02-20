package com.example.userms.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String Email;
/*
    @OneToMany(mappedBy = "Donation")
  private Collection<Donation> Donations;
  private Long idOrg;
  @Transient
  private Organisation organization;
*/

}
