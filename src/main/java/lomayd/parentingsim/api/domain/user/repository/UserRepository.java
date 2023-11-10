package lomayd.parentingsim.api.domain.user.repository;

import lomayd.parentingsim.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
}
