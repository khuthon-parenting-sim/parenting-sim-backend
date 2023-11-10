package lomayd.parentingsim.api.domain.scenario.controller;

import lomayd.parentingsim.api.domain.scenario.dto.ScenarioRequestDto;
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
    public ResponseEntity<ScenarioResponseDto.Script> startEpisode(ScenarioRequestDto.EpisodeStart data) {
        return ResponseEntity.ok(scenarioService.startEpisode(data));
    }

    @GetMapping
    public ResponseEntity<ScenarioResponseDto.Script> playEpisode(ScenarioRequestDto.EpisodePlay data) {
        return ResponseEntity.ok(scenarioService.playEpisode(data));
    }

    @GetMapping("/result")
    public ResponseEntity<ScenarioResponseDto.Result> getResult(@RequestParam String user) {
        return ResponseEntity.ok(scenarioService.getResult(user));
    }

}
