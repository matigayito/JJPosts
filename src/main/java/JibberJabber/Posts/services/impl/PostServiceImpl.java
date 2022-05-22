package JibberJabber.Posts.services.impl;

import JibberJabber.Posts.exceptions.PostNotFoundException;
import JibberJabber.Posts.model.Post;
import JibberJabber.Posts.repositories.PostRepository;
import JibberJabber.Posts.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {this.repository = repository;}

    @Override
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    @Override
    public Post save(Post newPost) {
        return repository.save(newPost);
    }

    @Override
    public Post find(Long id) {
        return repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public Post replace(Post newPost, Long id) {
        return repository.findById(id)
                .map(post -> {
                    post.setLongitude(newPost.getLongitude());
                    post.setMessage(newPost.getMessage());
                    return repository.save(post);
                }).orElseGet(() -> {
                    newPost.setId(id);
                    return repository.save(newPost);
                });
     }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
