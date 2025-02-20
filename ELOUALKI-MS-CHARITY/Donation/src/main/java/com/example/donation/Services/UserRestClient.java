package com.example.donation.Services;

import com.example.donation.MODEL.User;
import com.example.userms.Entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="userms")
public interface UserRestClient {
  @GetMapping(path = "/users/getall")
  List<Users> getUsers() ;

  @GetMapping("/{id}")
  Users getUserById(@PathVariable Long id) ;
}
