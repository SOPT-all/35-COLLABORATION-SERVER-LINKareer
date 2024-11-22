package sopt35.linkareer.domain.chatting.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt35.linkareer.domain.chatting.infra.ChattingEntity;

public interface ChattingRepository extends JpaRepository<ChattingEntity, Long> {

}
