package lomayd.parentingsim.api.domain.scenario.service;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.scenario.repository.ScenarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;

    public ScenarioResponseDto.ScenarioScript startEpisode(int episode) {
        Scenario scenario = scenarioRepository.findFirstByEpisodeOrderByIdAsc(episode);

        return ScenarioResponseDto.ScenarioScript.of(scenario);
    }

    public ScenarioResponseDto.ScenarioScript nextScenario(int scenario) {
        Scenario scenario1 = scenarioRepository.findById(scenario+1).get();

        return ScenarioResponseDto.ScenarioScript.of(scenario1);
    }
}
