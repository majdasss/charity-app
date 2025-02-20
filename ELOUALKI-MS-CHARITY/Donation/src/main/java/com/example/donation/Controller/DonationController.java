package com.example.donation.Controller;

import com.example.donation.Entity.Donation;
import com.example.donation.MODEL.Organization;
import com.example.donation.MODEL.User;
import com.example.donation.Repositories.DonRepo;
import com.example.donation.Services.MessageProducer;
import com.example.donation.Services.OrganizationRestClient;
import com.example.donation.Services.UserRestClient;
import com.example.userms.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonRepo donationRep;

  @Autowired
  private MessageProducer messageProducer;

  @PostMapping("/send")
  public ResponseEntity<String> sendDonationMessage(@RequestParam String message) {
    messageProducer.sendDonationMessage(message);
    return ResponseEntity.ok("Message envoyé : " + message);
  }

    // Get all donations
    @GetMapping("/listdon")
    public List<Donation> getAllDonations() {
        return donationRep.findAll();
    }

    @PostMapping("/createdon")
    public Donation createDonation(@RequestBody Donation Donation) {
        return donationRep.save(Donation);
    }

    @GetMapping("/donation/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        return donationRep.findById(id).get();
    }

    @PutMapping("/Updatedon/{id}")
    public Donation updateDonation(@PathVariable Long id, @RequestBody Donation DonationDetails) {
        Donation Donation = donationRep.findById(id).get();
        Donation.setDonor(DonationDetails.getDonor());
        Donation.setAmount(DonationDetails.getAmount());
        return donationRep.save(Donation);
    }

  @Autowired
  private UserRestClient userRestClient;

  @GetMapping("/allusers")
  public List<Users> getAllUsers() {
    return userRestClient.getUsers();
  }
  @GetMapping("/user/{id}")
  public Users getUserById(@PathVariable Long id) {
    return userRestClient.getUserById(id);
  }

  private OrganizationRestClient organizationRestClient;

  @GetMapping("/allorg")
  public List<Organization> getAllOrganizations() {
    return organizationRestClient.getAllOrganizations();
  }

  @GetMapping("/org/{id}")
  public Organization getOrganizationById(@PathVariable Long id){
    return organizationRestClient.getOrganizationById(id);
  }
}
