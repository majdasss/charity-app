package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class ConfigClientApplication {
  @Value("${spring.datasource.url}")
  private String database;

  @Value("${test.var}")
  private int num;
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }
  @GetMapping("/conf")
  public Map<String, Object> getConfig() {
    return Map.of(
      "db", this.database,
      "val", this.num
    );
  }
}
