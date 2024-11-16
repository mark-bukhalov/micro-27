package org.example.languageservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}