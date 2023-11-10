package lomayd.parentingsim.api.domain.user.service;

import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.user.User;
import lomayd.parentingsim.api.domain.user.dto.UserResponseDto;
import lomayd.parentingsim.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(String id) {
        User user = User.builder()
                .id(id)
                .score_total(0)
                .score_society(0)
                .score_control(0)
                .score_recognition(0)
                .score_concentration(0)
                .build();

        userRepository.save(user);
    }

    public UserResponseDto.Result getResult(String user) {
        User user1 = userRepository.findById(user).get();

        return UserResponseDto.Result.of(user1);
    }
}
