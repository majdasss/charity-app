package com.example.donation.Repositories;

import com.example.donation.Entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonRepo extends JpaRepository<Donation, Long> {
    // You can add custom query methods here if needed, for example:
    // List<Donation> findByDonor(String donor);
  List<Donation> findByUserId(Long userId);
}
