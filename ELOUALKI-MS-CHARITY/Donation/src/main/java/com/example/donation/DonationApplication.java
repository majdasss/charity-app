package com.example.donation;

import com.example.donation.Entity.Donation;
import com.example.donation.MODEL.User;
import com.example.donation.Repositories.DonRepo;
import com.example.donation.Services.MessageProducer;
import com.example.donation.Services.OrganizationRestClient;
import com.example.donation.Services.UserRestClient;
import com.example.userms.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
@EnableFeignClients
public class DonationApplication implements CommandLineRunner {

  @Autowired
  private OrganizationRestClient organizationRestClient;

  @Autowired
  private UserRestClient userRestClient;

  @Autowired
  private DonRepo donRepo;

  @Autowired
  private MessageProducer messageProducer;

  public static void main(String[] args) {
    // Un seul appel à SpringApplication.run
    SpringApplication.run(DonationApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // Ajout de quelques donations pour tester
    donRepo.save(new Donation(1L, "donor1", 123));
    donRepo.save(new Donation(2L, "donor2", 456));
    donRepo.save(new Donation(3L, "donor3", 678));
    donRepo.save(new Donation(4L, "donor4", 890));
    donRepo.save(new Donation(5L, "donor5", 1011));

    // Envoi d'un message avec le producteur
    messageProducer.sendDonationMessage("Test Message");
    messageProducer.sendDonationMessage("Test Message");
    messageProducer.sendDonationMessage("Test Message");
    // Vous pouvez également utiliser l'organizationRestClient ou userRestClient ici
    // Exemple : organizationRestClient.getOrganizations();
  }
}
