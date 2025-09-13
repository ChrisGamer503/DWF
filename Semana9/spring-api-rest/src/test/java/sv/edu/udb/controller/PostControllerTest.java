package sv.edu.udb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sv.edu.udb.controller.response.PostResponse;
import sv.edu.udb.repository.domain.Post;
import sv.edu.udb.service.PostService;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PostControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
        this.objectMapper = new ObjectMapper();

        // 👇 Esta línea es clave para evitar el error con LocalDate
        this.objectMapper.findAndRegisterModules();

        this.post = Post.builder()
                .id(1L)
                .title("testing post")
                .postDate(LocalDate.of(2024, 9, 28))
                .build();
    }

    @Test
    @DisplayName("Get all posts")
    void findAllPost_when_performGetRequest() throws Exception {
        final List<PostResponse> expectedList = List.of(
                PostResponse.builder()
                        .title(post.getTitle())
                        .postDate(post.getPostDate())
                        .build()
        );

        when(postService.findAll()).thenReturn(expectedList);

        this.mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(expectedList)));
    }
}
