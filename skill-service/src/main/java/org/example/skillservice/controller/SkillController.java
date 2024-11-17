package org.example.skillservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.skillservice.usecases.dto.SkillResponseDto;
import org.example.skillservice.usecases.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    ResponseEntity<List<SkillResponseDto>> getSkillListByIdList(@RequestParam(name = "ids") List<Long> idList) {
        log.info("get skills for {}", idList);
        return ResponseEntity.ok(skillService.getSkillsByIdList(idList));
    }
}