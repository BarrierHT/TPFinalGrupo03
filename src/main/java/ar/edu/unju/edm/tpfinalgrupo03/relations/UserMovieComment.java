package ar.edu.unju.edm.tpfinalgrupo03.relations;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Component
@Entity
@Table
public class UserMovieComment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieId")
    private Movie movie;

    private String comment;

    public UserMovieComment() {
    }

    public UserMovieComment(Integer id, User user, Movie movie, String comment) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
