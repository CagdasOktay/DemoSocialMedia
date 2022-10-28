package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.NewCreateUserDto;
import org.example.repository.entity.UserProfile;
import org.example.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody NewCreateUserDto dto) {
        try {
            userProfileService.create(dto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }


    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserProfile>> findall() {
        return ResponseEntity.ok(userProfileService.findAll());

    }


}
