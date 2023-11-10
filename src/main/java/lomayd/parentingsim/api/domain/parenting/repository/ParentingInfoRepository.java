package lomayd.parentingsim.api.domain.parenting.repository;

import lomayd.parentingsim.api.domain.parenting.ParentingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentingInfoRepository extends JpaRepository<ParentingInfo, Integer> {
}
