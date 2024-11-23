package org.example.competenceservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.competenceservice.usecases.dto.SkillResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "skill-service")
public interface SkillFeignClient {

    @CircuitBreaker(name = "competence-service", fallbackMethod = "fallback")
    @GetMapping("/api/v1/skills")
    List<SkillResponseDto> getSkillListByIdList(@RequestParam(name = "ids") List<Long> idList);

    default List<SkillResponseDto> fallback(Throwable throwable) {
        return List.of(new SkillResponseDto(1L, "NOTFOUND"));
    }
}
