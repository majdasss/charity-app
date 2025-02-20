package com.example.userms;

import com.example.userms.Entity.Users;
import com.example.userms.Repositoris.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@SpringBootApplication
public class UsermsApplication implements CommandLineRunner {
  private final UserRepo userRepo;

 /* @Value("${spring.datasource.url}")
  private String database;

  @Value("${test.var}")
  private int num;*/

  public static void main(String[] args) {
    SpringApplication.run(UsermsApplication.class, args);
  }

  public UsermsApplication(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void run(String... args) throws Exception {
    // Initialisation de données utilisateurs
    userRepo.save(new Users(1, "nom1", "PRENOM1", "Email1@gmail.com"));
    userRepo.save(new Users(2, "nom2", "PRENOM22", "EMAIL2@gmail.com"));
    userRepo.save(new Users(3, "nom3", "PRENOM3", "EMAIL3@gmail.com"));
    userRepo.save(new Users(4, "nom4", "PRENOM4", "EMAIL4@gmail.com"));
    userRepo.save(new Users(5, "nom5", "PRENOM5", "EMAIL5@gmail.com"));
  }

 /* @GetMapping("/conf")
  public Map<String, Object> getConfig() {
    // Retourne les valeurs de configuration dans un format clé-valeur
    return Map.of(
      "db", this.database,
      "val", this.num
    );
  }*/
}
