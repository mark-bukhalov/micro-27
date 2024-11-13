package org.example.competenceservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.competenceservice.usecases.dto.CompetenceResponseDto;
import org.example.competenceservice.usecases.service.CompetenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/competence/{uuid}")
@RequiredArgsConstructor
public class CompetenceController {

    private final CompetenceService competenceService;

    @GetMapping()
    CompetenceResponseDto getCompetenceByUuid(@PathVariable String uuid) {
        return competenceService.get(uuid);
    }
}