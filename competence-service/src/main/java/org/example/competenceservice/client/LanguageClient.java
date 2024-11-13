package org.example.competenceservice.client;

import lombok.RequiredArgsConstructor;
import org.example.competenceservice.usecases.dto.LanguageResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LanguageClient {
    private final RestTemplate restTemplate;

    public List<LanguageResponseDto> getLanguageInfo(List<Long> languageIdList) {
        String ids = languageIdList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        String url = "http://LANGUAGE_SERVICE/language?ids=" + ids;

        ResponseEntity<List<LanguageResponseDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LanguageResponseDto>>() {
                }
        );

        return response.getBody();
    }
}