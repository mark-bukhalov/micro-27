package org.example.competenceservice.usecases.dto;

import java.util.List;

public record CompetenceResponseDto(List<LanguageResponseDto> languages,
                                    List<SkillResponseDto> skills) {
}