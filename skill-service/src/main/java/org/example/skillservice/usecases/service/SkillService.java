package org.example.skillservice.usecases.service;

import org.example.skillservice.usecases.dto.SkillResponseDto;

import java.util.List;

public interface SkillService {
    List<SkillResponseDto> getSkillsByIdList(List<Long> idList);
}