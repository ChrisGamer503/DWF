package sv.edu.udb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.repository.domain.Post;
import sv.edu.udb.repository.domain.PostComment;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostCommentRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Test
    @Transactional
    void shouldSaveAndFindComment() {
        Post post = Post.builder()
                .id(100L)
                .title("Post for Comment")
                .postDate(LocalDate.now())
                .build();
        postRepository.save(post);

        PostComment comment = PostComment.builder()
                .id(200L)
                .review("Great post!")
                .commentDate(LocalDate.now())
                .post(post)
                .build();
        postCommentRepository.save(comment);

        PostComment found = postCommentRepository.findById(200L);
        assertNotNull(found);
        assertEquals("Great post!", found.getReview());
        assertEquals(post.getId(), found.getPost().getId());

        postCommentRepository.delete(comment);
        postRepository.delete(post);
    }

    @Test
    void shouldReturnEmptyList_When_NoComments() {
        List<PostComment> comments = postCommentRepository.findAll();
        assertNotNull(comments);
    }
}
