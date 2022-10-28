package org.example.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.repository.enums.Roles;
import org.example.repository.enums.Status;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    Roles role = Roles.USER;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    Status status = Status.PENDING;


}
