package sopt35.linkareer.domain.official.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt35.linkareer.domain.official.infra.Official;
import sopt35.linkareer.domain.official.infra.Official.*;

import java.util.List;

public interface OfficialRepository extends JpaRepository<Official, Long> {
    List<Official> findAllByInterestJob(String interestJob);
    List<Official> findAllByTag(String tag);
}
