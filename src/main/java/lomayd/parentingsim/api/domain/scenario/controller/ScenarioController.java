package lomayd.parentingsim.api.domain.scenario.controller;

import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.scenario.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simulation")
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioService scenarioService;

    @GetMapping("/start")
    public ResponseEntity<ScenarioResponseDto.Script> startEpisode(@RequestParam int episode) {
        return ResponseEntity.ok(scenarioService.startEpisode(episode));
    }

    @GetMapping
    public ResponseEntity<ScenarioResponseDto.Script> playEpisode(@RequestParam int scenario, @RequestParam String user) {
        return ResponseEntity.ok(scenarioService.playEpisode(scenario, user));
    }

    @GetMapping("/result")
    public ResponseEntity<ScenarioResponseDto.Result> getResult(@RequestParam String user) {
        return ResponseEntity.ok(scenarioService.getResult(user));
    }

}
