package JibberJabber.Posts.controller;

import JibberJabber.Posts.model.Post;
import JibberJabber.Posts.services.PostService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {this.postService = postService;}

    @GetMapping
    List<Post> getAll() {return postService.getAllPosts();}

    @PostMapping
    Post save(@RequestBody Post newPost) {
        return postService.save(newPost);
    }

    @GetMapping("/{id}")
    Post find(@PathVariable Long id) {
        return postService.find(id);
    }

    @PutMapping("/{id}")
    Post replace(@RequestBody Post newPost, @PathVariable Long id) {
        return postService.replace(newPost, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
