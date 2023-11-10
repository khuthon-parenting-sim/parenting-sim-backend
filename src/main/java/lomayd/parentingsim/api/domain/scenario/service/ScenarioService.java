package lomayd.parentingsim.api.domain.scenario.service;

import lomayd.parentingsim.api.domain.scenario.Scenario;
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

    public ScenarioResponseDto.Script startEpisode(int episode) {
        Scenario scenario = scenarioRepository.findFirstByEpisodeOrderByIdAsc(episode);

        Scenario choice_1_scenario = scenarioRepository.findById(scenario.getChoice_1()).get();
        Scenario choice_2_scenario = scenarioRepository.findById(scenario.getChoice_2()).get();

        double choice_1_rate = userLogRepository.countByScenario(choice_1_scenario) * 1.0 / userLogRepository.countBy();
        double choice_2_rate = userLogRepository.countByScenario(choice_2_scenario) * 1.0 / userLogRepository.countBy();

        return ScenarioResponseDto.Script.of(scenario, choice_1_scenario, choice_2_scenario, choice_1_rate, choice_2_rate);
    }

    public ScenarioResponseDto.Script playEpisode(int scenarioId, String userId) {
        Scenario scenario = scenarioRepository.findById(scenarioId).get();
        User user = userRepository.findById(userId).get();

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

    public ScenarioResponseDto.Result getResult(String id) {
        User user = userRepository.findById(id).get();

        return ScenarioResponseDto.Result.of(user);
    }
}
