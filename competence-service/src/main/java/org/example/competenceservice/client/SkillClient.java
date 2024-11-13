package org.example.competenceservice.client;

import lombok.RequiredArgsConstructor;
import org.example.competenceservice.usecases.dto.SkillResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkillClient {
    private final RestTemplate restTemplate;

    public List<SkillResponseDto> getSkillsInfo(List<Long> skillsIdList) {
        String ids = skillsIdList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        String url = "http://SKILL_SERVICE/skills?ids=" + ids;

        ResponseEntity<List<SkillResponseDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SkillResponseDto>>() {
                }
        );

        return response.getBody();
    }
}