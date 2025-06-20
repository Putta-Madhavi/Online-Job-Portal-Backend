package com.onlinejobportal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "job_categories")
public class JobCategory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;  

   @Column(unique = true, nullable = false)
   private String name;  
}
