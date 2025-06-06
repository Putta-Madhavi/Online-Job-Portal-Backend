package com.onlinejobportal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private User jobSeeker;  

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;  

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;  

    @Column(name = "application_date")
    private LocalDateTime applicationDate = LocalDateTime.now();  

    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }
}