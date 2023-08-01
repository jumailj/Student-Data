package com.studentdata.studentdata.entity;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter // todo learn getter;
@Setter // todo learn setter;
@Entity // todo learn entity;
@Table(name="student")        // todo  what acutally it is going to do table()
@EqualsAndHashCode(of={"id"}) // todo equalsandhascode()
public class Student {

    @Id
    private String id;

    private String name;
    private String email;
    private LocalDate birthday;             //todo learn about localDate Type;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    // address calss hold data: street, number, district, city, state.
    private Address address; // here we using address from : entity/Address.java class


    @Column(name = "created_at")         // todo learn @column()
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist                         // todo learn prepersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate                         // todo learn perupdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }   
}
