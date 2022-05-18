package JibberJabber.Posts.model;


import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
    @GeneratedValue
    @Id
    private Long id;
    private String message;
    private int longitude;

    public Post() {
        longitude = 140;
    }
    public Post(String message) {
        longitude = 140;
        if (message.length() <= longitude) {
            this.message = message;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public int getLongitude() {
        return longitude;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
