package org.example.languageservice.usecases.service;

import org.example.languageservice.usecases.dto.LanguageResponseDto;

import java.util.List;

public interface LanguageService {

    List<LanguageResponseDto> getLanguageListByIdList(List<Long> idList);
}