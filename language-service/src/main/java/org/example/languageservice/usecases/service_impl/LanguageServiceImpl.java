package org.example.languageservice.usecases.service_impl;

import org.example.languageservice.data.entity.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.example.languageservice.repository.LanguageRepository;
import org.example.languageservice.usecases.dto.LanguageResponseDto;
import org.example.languageservice.usecases.service.LanguageService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public List<LanguageResponseDto> getLanguageListByIdList(List<Long> idList) {
        List<Language> languageList = languageRepository.findAllById(idList);
        if (languageList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Not found languages with ID: %s", idList));
        }
        return languageList.stream()
                .map(language -> new LanguageResponseDto(language.getId(), language.getName()))
                .toList();
    }
}