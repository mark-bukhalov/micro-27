package org.example.languageservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.languageservice.usecases.dto.LanguageResponseDto;
import org.example.languageservice.usecases.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public List<LanguageResponseDto> getLanguageListByIdList(@RequestParam(name = "ids") List<Long> idList) {
        return languageService.getLanguageListByIdList(idList);
    }
}