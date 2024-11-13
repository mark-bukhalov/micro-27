package org.example.competenceservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "languages")
    private List<Cv> cvs;
}