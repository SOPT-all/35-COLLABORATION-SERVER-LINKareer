package sopt35.linkareer.domain.post.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt35.linkareer.domain.post.infra.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
