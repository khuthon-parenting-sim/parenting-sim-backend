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

        user1.setScore_total(user1.getScore_total() + scenarioResult.getScore_society() + scenarioResult.getScore_control() + scenarioResult.getScore_recognition() + scenarioResult.getScore_concentration());

        user1.setScore_society(user1.getScore_society() + scenarioResult.getScore_society());
        user1.setScore_control(user1.getScore_control() + scenarioResult.getScore_control());
        user1.setScore_recognition(user1.getScore_recognition() + scenarioResult.getScore_recognition());
        user1.setScore_concentration(user1.getScore_concentration() + scenarioResult.getScore_concentration());

        userRepository.save(user1);

        UserLog userLog = UserLog.builder()
                .id(userLogId++)
                .scenario(scenarioResult.getScenario())
                .scenarioResult(scenarioResult)
                .user(user1)
                .timestamp(System.currentTimeMillis())
                .build();

        userLogRepository.save(userLog);

        return ScenarioResultResponseDto.ChoiceResult.of(scenarioResult);
    }

}
