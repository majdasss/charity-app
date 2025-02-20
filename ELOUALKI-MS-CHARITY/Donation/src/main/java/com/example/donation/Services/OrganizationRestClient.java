package com.example.donation.Services;

import com.example.donation.MODEL.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="OrgMS")
public interface OrganizationRestClient {
  @GetMapping("/{id}")
  Organization getOrganizationById(@PathVariable Long id);
  @GetMapping("/ListOrganisation")
   List<Organization> getAllOrganizations();

}
