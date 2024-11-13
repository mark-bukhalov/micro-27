package org.example.competenceservice.repository;

import org.example.competenceservice.data.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {

    Cv findByUuid(String uuid);
}