package org.example.competenceservice.data.entity;


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
@Table(name = "skill")
public class Skill {

    @Id
    private Long id;

    @ManyToMany(mappedBy = "skills")
    private List<Cv> cvs;
}