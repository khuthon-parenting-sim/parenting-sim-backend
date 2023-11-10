package lomayd.parentingsim.api.domain.scenario.service;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lomayd.parentingsim.api.domain.scenario.dto.ScenarioRequestDto;
import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.scenario.repository.ScenarioRepository;
import lomayd.parentingsim.api.domain.user.User;
import lomayd.parentingsim.api.domain.user.UserLog;
import lomayd.parentingsim.api.domain.user.repository.UserLogRepository;
import lomayd.parentingsim.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;
    private final UserLogRepository userLogRepository;
    private final UserRepository userRepository;

    public ScenarioResponseDto.Script startEpisode(ScenarioRequestDto.EpisodeStart data) {
        Scenario scenario = scenarioRepository.findFirstByEpisodeOrderByIdAsc(Integer.parseInt(data.getEpisode()));

        Scenario choice_1_scenario = scenarioRepository.findById(scenario.getChoice_1()).get();
        Scenario choice_2_scenario = scenarioRepository.findById(scenario.getChoice_2()).get();

        double choice_1_rate = userLogRepository.countByScenario(choice_1_scenario) * 1.0 / userLogRepository.countBy();
        double choice_2_rate = userLogRepository.countByScenario(choice_2_scenario) * 1.0 / userLogRepository.countBy();

        return ScenarioResponseDto.Script.of(scenario, choice_1_scenario, choice_2_scenario, choice_1_rate, choice_2_rate);
    }

    public ScenarioResponseDto.Script playEpisode(ScenarioRequestDto.EpisodePlay data) {
        Scenario scenario = scenarioRepository.findById(data.getScenario()).get();
        User user = userRepository.findById(data.getUser()).get();

        Scenario choice_1_scenario = scenarioRepository.findById(scenario.getChoice_1()).get();
        Scenario choice_2_scenario = scenarioRepository.findById(scenario.getChoice_2()).get();

        double choice_1_rate = userLogRepository.countByScenario(choice_1_scenario) * 1.0 / userLogRepository.countBy();
        double choice_2_rate = userLogRepository.countByScenario(choice_2_scenario) * 1.0 / userLogRepository.countBy();

        UserLog userLog = UserLog.builder()
                .scenario(scenario)
                .user(user)
                .timestamp(System.currentTimeMillis())
                .build();

        userLogRepository.save(userLog);

        return ScenarioResponseDto.Script.of(scenario, choice_1_scenario, choice_2_scenario, choice_1_rate, choice_2_rate);
    }
}
