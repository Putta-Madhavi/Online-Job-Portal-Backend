package com.onlinejobportal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;  

    @Column(name = "company_name", nullable = false)
    private String companyName;  

    @Column(columnDefinition = "TEXT")
    private String description;  
}