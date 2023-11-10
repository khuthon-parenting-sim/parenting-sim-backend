package lomayd.parentingsim.api.domain.scenario.service;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lomayd.parentingsim.api.domain.scenario.dto.ScenarioRequestDto;
import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.scenario.repository.ScenarioRepository;
import lomayd.parentingsim.api.domain.user.repository.UserLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;
    private final UserLogRepository userLogRepository;

    public ScenarioResponseDto.Script startEpisode(ScenarioRequestDto.Episode data) {
        Scenario scenario = scenarioRepository.findFirstByEpisodeOrderByIdAsc(Integer.parseInt(data.getEpisode()));

        Scenario choice_1_scenario = scenarioRepository.findById(scenario.getChoice_1()).get();
        Scenario choice_2_scenario = scenarioRepository.findById(scenario.getChoice_2()).get();

        double choice_1_rate = userLogRepository.countByScenario(choice_1_scenario) * 1.0 / userLogRepository.countBy();
        double choice_2_rate = userLogRepository.countByScenario(choice_2_scenario) * 1.0 / userLogRepository.countBy();

        return ScenarioResponseDto.Script.of(scenario, choice_1_scenario, choice_2_scenario, choice_1_rate, choice_2_rate);
    }
}
