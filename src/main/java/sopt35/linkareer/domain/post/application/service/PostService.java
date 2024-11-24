package sopt35.linkareer.domain.post.application.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt35.linkareer.domain.post.application.dto.response.PostsServiceResponse;
import sopt35.linkareer.domain.post.application.vo.PostVo;
import sopt35.linkareer.domain.post.infra.repository.PostRepository;
import sopt35.linkareer.global.util.TimeCalculator;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public PostsServiceResponse getPosts() {
        return PostsServiceResponse.toPostsServiceResponse(postRepository.findAll().stream()
                .map(post -> PostVo.of(
                        post,
                        TimeCalculator.BETWEEN(post.getCreatedAt(), LocalDateTime.now())
                )).toList()
        );
    }
}
