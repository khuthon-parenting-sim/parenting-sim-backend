package lomayd.parentingsim.api.domain.parenting.repository;

import lomayd.parentingsim.api.domain.parenting.ParentingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentingInfoRepository extends JpaRepository<ParentingInfo, Integer> {

    @Query("select p from ParentingInfo p where p.title like %:search%")
    List<ParentingInfo> findAllByTitle(String search);

    @Query("select p from ParentingInfo p where p.detail like %:search%")
    List<ParentingInfo> findAllByDetail(String search);

    @Query("select p from ParentingInfo p where p.tag like %:search%")
    List<ParentingInfo> findAllByTag(String search);

    @Query(value = "select * from parenting_sim.ParentingInfo order by RAND() limit 1", nativeQuery = true)
    List<ParentingInfo> findRandom();
}
