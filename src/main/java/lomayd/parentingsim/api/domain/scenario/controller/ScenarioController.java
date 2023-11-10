package lomayd.parentingsim.api.domain.scenario.controller;

import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResponseDto;
import lomayd.parentingsim.api.domain.scenario.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulation")
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioService scenarioService;

    @GetMapping("/start")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ScenarioResponseDto.ScenarioScript> startEpisode(@RequestParam int episode) {
        return ResponseEntity.ok(scenarioService.startEpisode(episode));
    }

    @GetMapping("/next")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ScenarioResponseDto.ScenarioScript> nextScenario(@RequestParam int scenario) {
        return ResponseEntity.ok(scenarioService.nextScenario(scenario));
    }
}
