package lomayd.parentingsim.api.domain.scenario.service;

import lomayd.parentingsim.api.domain.scenario.ScenarioResult;
import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResultResponseDto;
import lomayd.parentingsim.api.domain.scenario.repository.ScenarioResultRepository;
import lomayd.parentingsim.api.domain.user.User;
import lomayd.parentingsim.api.domain.user.UserLog;
import lomayd.parentingsim.api.domain.user.repository.UserLogRepository;
import lomayd.parentingsim.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScenarioResultService {

    private final ScenarioResultRepository scenarioResultRepository;
    private final UserRepository userRepository;
    private final UserLogRepository userLogRepository;
    private int userLogId = 1;

    public ScenarioResultResponseDto.ChoiceResult chooseScenario(int choice, String user) {

        ScenarioResult scenarioResult = scenarioResultRepository.findById(choice).get();

        User user1 = userRepository.findById(user).get();

        UserLog userLog = UserLog.builder()
                .id(userLogId++)
                .scenario(scenarioResult.getScenario())
                .user(user1)
                .timestamp(System.currentTimeMillis())
                .build();

        userLogRepository.save(userLog);

        return ScenarioResultResponseDto.ChoiceResult.of(scenarioResult);
    }

}
