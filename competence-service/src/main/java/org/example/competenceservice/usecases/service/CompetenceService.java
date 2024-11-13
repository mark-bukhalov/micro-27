package org.example.competenceservice.usecases.service;

import org.example.competenceservice.usecases.dto.CompetenceResponseDto;

public interface CompetenceService {
    CompetenceResponseDto get(String uuid);
}