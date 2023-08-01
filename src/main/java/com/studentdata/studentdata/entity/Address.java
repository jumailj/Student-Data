package com.studentdata.studentdata.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Getter
@Setter
@Entity
@Table(name="address")
@EqualsAndHashCode(of = {"id"})
public class Address {

    @Id
    private String id;

    @Column(name="address")
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;


    @Column (name= "created_at")
    private LocalDateTime createdAt;

    @Column (name= "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name="fk_student")
    private Student student;

    @PrePersist
    private void prepersiste() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();  // add current time to the createAT.
    }

    @PreUpdate
    private void PreUpdate() {
        this.updatedAt = LocalDateTime.now();  // update current time to the updatedat <-- by now
    } 
}
