package lomayd.parentingsim.api.domain.scenario.repository;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lomayd.parentingsim.api.domain.scenario.ScenarioResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioResultRepository extends JpaRepository<ScenarioResult, Integer> {

    ScenarioResult findByScenarioIdAndCorrect(int scenarioId, boolean correct);
}
