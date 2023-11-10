package lomayd.parentingsim.api.domain.user.controller;

import lomayd.parentingsim.api.domain.user.dto.UserRequestDto;
import lomayd.parentingsim.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simulation")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<Void> joinUser(@RequestParam UserRequestDto.UserJoin data) {
        userService.joinUser(data);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
