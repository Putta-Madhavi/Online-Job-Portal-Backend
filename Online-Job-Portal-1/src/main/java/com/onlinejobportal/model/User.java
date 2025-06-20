package com.onlinejobportal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @Column(unique = true, nullable = false)
    private String username;  
    
    @Column(nullable = false)
    private String password;  
    
    @Column(unique = true, nullable = false)
    private String email; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;  
    
    public enum Role {
        ADMIN, JOB_SEEKER, COMPANY
    }
}