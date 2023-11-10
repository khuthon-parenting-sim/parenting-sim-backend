package lomayd.parentingsim.api.domain.user.repository;

import lomayd.parentingsim.api.domain.user.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, Integer> {
}
