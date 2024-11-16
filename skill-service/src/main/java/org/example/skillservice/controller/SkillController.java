package org.example.skillservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.skillservice.usecases.dto.SkillResponseDto;
import org.example.skillservice.usecases.service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    List<SkillResponseDto> getSkillListByIdList(@RequestParam(name = "ids") List<Long> idList) {
        return skillService.getSkillsByIdList(idList);
    }
}