package sopt35.linkareer.domain.post.infra.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt35.linkareer.domain.post.infra.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByJobIn(final List<String> jobNames);
    List<Post> findPostsByJob(final String jobName);
}
