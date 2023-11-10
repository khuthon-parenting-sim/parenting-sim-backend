package lomayd.parentingsim.api.domain.scenario.controller;

import lomayd.parentingsim.api.domain.scenario.dto.ScenarioResultResponseDto;
import lomayd.parentingsim.api.domain.scenario.service.ScenarioResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulation")
@RequiredArgsConstructor
public class ScenarioResultController {

    private final ScenarioResultService scenarioResultService;

    @GetMapping("/choice")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ScenarioResultResponseDto.ChoiceResult> chooseScenario(@RequestParam int choice, @RequestParam String user) {
        return ResponseEntity.ok(scenarioResultService.chooseScenario(choice, user));
    }
}
