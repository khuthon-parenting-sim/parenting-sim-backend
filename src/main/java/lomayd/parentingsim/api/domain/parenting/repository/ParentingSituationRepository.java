package lomayd.parentingsim.api.domain.parenting.repository;

import lomayd.parentingsim.api.domain.parenting.ParentingSituation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentingSituationRepository extends JpaRepository<ParentingSituation, Integer> {
}
