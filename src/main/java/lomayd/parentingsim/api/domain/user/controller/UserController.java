package lomayd.parentingsim.api.domain.user.controller;

import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.user.dto.UserResponseDto;
import lomayd.parentingsim.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulation")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> joinUser(@RequestParam String user) {
        userService.joinUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/result")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserResponseDto.Result> getResult(@RequestParam String user) {
        return ResponseEntity.ok(userService.getResult(user));
    }
}
