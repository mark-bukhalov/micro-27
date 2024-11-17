package org.example.competenceservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.competenceservice.usecases.dto.CompetenceResponseDto;
import org.example.competenceservice.usecases.service.CompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/competence")
@RequiredArgsConstructor
public class CompetenceController {

    private final CompetenceService competenceService;

    @GetMapping("/{uuid}")
    ResponseEntity<CompetenceResponseDto> getCompetenceByUuid(@PathVariable String uuid) {
        log.info("Get competence for UUID: {}", uuid);
        return ResponseEntity.ok(competenceService.get(uuid));
    }
}