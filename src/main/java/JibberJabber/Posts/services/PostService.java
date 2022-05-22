package JibberJabber.Posts.services;

import JibberJabber.Posts.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post save(Post newPost);

    Post find(Long id);

    Post replace(Post newPost, Long id);

    void delete(Long id);
}
