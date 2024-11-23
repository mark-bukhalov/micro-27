package org.example.skillservice.usecases.service_impl;

import lombok.RequiredArgsConstructor;
import org.example.skillservice.data.entity.Skill;
import org.example.skillservice.repository.SkillRepository;
import org.example.skillservice.usecases.dto.SkillResponseDto;
import org.example.skillservice.usecases.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public List<SkillResponseDto> getSkillsByIdList(List<Long> idList) {
        List<Skill> skillList = skillRepository.findAllById(idList);
        if (skillList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Not found skills with ID: %s", idList));
        }
        return skillList.stream()
                .map(skill -> new SkillResponseDto(skill.getId(), skill.getName()))
                .toList();
    }
}