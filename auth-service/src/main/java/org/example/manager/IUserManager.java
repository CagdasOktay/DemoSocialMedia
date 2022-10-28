package org.example.manager;


import org.example.dto.request.NewCreateUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", decode404 = true, url = "http://localhost:8081/user")
public interface IUserManager {

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody NewCreateUserDto dto);


}
