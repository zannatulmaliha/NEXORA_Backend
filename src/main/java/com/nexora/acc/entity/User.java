package com.nexora.acc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long user_id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobileNumber;
    private String password;
    private String role;


}
