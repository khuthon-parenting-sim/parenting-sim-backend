package lomayd.parentingsim.api.domain.user.service;

import lomayd.parentingsim.api.domain.user.User;
import lomayd.parentingsim.api.domain.user.dto.UserRequestDto;
import lomayd.parentingsim.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(UserRequestDto.UserJoin data) {
        User user = User.builder()
                .id(data.getId())
                .score_point(0)
                .score_patient(0)
                .score_manner(0)
                .score_concentration(0)
                .build();

        userRepository.save(user);
    }
}
