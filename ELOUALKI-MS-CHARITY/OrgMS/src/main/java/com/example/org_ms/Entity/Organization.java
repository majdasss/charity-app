package com.example.org_ms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
 /* @OneToMany(mappedBy = "Donation")
  private Collection<Donation> Donations;
  @ManyToMany(mappedBy = "User")
  private Collection<Users> Users;*/
}
