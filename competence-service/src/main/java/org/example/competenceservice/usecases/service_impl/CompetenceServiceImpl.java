package org.example.competenceservice.usecases.service_impl;

import lombok.RequiredArgsConstructor;
import org.example.competenceservice.client.LanguageFeignClient;
import org.example.competenceservice.client.SkillFeignClient;
import org.example.competenceservice.data.entity.Cv;
import org.example.competenceservice.data.entity.Language;
import org.example.competenceservice.data.entity.Skill;
import org.example.competenceservice.repository.CvRepository;
import org.example.competenceservice.usecases.dto.CompetenceResponseDto;
import org.example.competenceservice.usecases.dto.LanguageResponseDto;
import org.example.competenceservice.usecases.dto.SkillResponseDto;
import org.example.competenceservice.usecases.service.CompetenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

    private final CvRepository cvRepository;
    private final SkillFeignClient skillClient;
    private final LanguageFeignClient languageClient;

    @Override
    public CompetenceResponseDto get(String uuid) {
        Cv cv = cvRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Competence not found for UUID:" + uuid));

        List<SkillResponseDto> skillResponseDtoList = getSkillInfo(cv.getSkills());
        List<LanguageResponseDto> languageResponceDtoList = getLanguageInfo(cv.getLanguages());

        return new CompetenceResponseDto(languageResponceDtoList, skillResponseDtoList);
    }

    private List<SkillResponseDto> getSkillInfo(List<Skill> skillList) {
        List<Long> skillsIdList = skillList.stream()
                .map(Skill::getId).toList();

        return skillClient.getSkillListByIdList(skillsIdList);
    }

    private List<LanguageResponseDto> getLanguageInfo(List<Language> languageList) {
        List<Long> languageIdList = languageList.stream()
                .map(Language::getId).toList();

        return languageClient.getLanguageListByIdList(languageIdList);
    }
}