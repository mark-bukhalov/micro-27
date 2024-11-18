package org.example.competenceservice.client;

import org.example.competenceservice.usecases.dto.LanguageResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "language-service")
public interface LanguageFeignClient {

    @GetMapping("/api/v1/languages")
    List<LanguageResponseDto> getLanguageListByIdList(@RequestParam(name = "ids") List<Long> idList);
}
