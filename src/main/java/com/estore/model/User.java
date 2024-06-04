package com.estore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password",length =10)
    private String password;
    @Column(length = 1000)
    private String about;


}
