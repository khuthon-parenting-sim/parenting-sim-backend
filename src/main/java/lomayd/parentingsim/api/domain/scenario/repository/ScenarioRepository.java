package lomayd.parentingsim.api.domain.scenario.repository;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Integer> {
}
