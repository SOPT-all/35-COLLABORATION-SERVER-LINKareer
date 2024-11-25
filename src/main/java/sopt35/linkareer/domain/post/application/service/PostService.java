package sopt35.linkareer.domain.post.application.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.domain.post.application.dto.response.PostsServiceResponse;
import sopt35.linkareer.domain.post.application.vo.PostVo;
import sopt35.linkareer.domain.post.infra.Post;
import sopt35.linkareer.domain.post.infra.category.Job;
import sopt35.linkareer.domain.post.infra.category.Jobs;
import sopt35.linkareer.domain.post.infra.category.PostCategory;
import sopt35.linkareer.domain.post.infra.repository.PostRepository;
import sopt35.linkareer.global.exception.LinkareerException;
import sopt35.linkareer.global.util.TimeCalculator;

@Service
public class PostService {

    private static final String CUSTOM_USER_JOB_NAME = "UX/UI";

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private List<Post> findPostsByCategory(final PostCategory postCategory) {
        if (postCategory == PostCategory.INTEREST) {
            return postRepository.findPostsByJobIn(Jobs.getJobNamesRelateWith(CUSTOM_USER_JOB_NAME));
        } else if (postCategory == PostCategory.JOB) {
            return postRepository.findPostsByJob(CUSTOM_USER_JOB_NAME);
        }

        throw new LinkareerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    @Transactional(readOnly = true)
    public PostsServiceResponse getPosts(final PostCategory category) {
        List<Post> findPosts = findPostsByCategory(category);
        List<PostVo> postVos = findPosts.stream()
                .map(post -> PostVo.of(
                        post,
                        TimeCalculator.BETWEEN(post.getCreatedAt(), LocalDateTime.now())
                )).toList();

        return PostsServiceResponse.toPostsServiceResponse(postVos);
    }
}
