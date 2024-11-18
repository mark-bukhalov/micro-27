package org.example.competenceservice.client;

import org.example.competenceservice.usecases.dto.SkillResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "skill-service")
public interface SkillFeignClient {

    @GetMapping("/api/v1/skills")
    List<SkillResponseDto> getSkillListByIdList(@RequestParam(name = "ids") List<Long> idList);
}
