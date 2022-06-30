package ar.edu.unju.edm.tpfinalgrupo03.relations;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize.NA;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Component
@Entity
@Table
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieId")
    private Movie movie;

    // @Past(message = "Ingrese una fecha posible")
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    private Integer tickets = 0;

    @Min(value = 1, message = "La valoracion minima es de 1")
    @Max(value = 5, message = "La valoracion maxima es de 5")
    private Integer valoration;

    public UserMovie() {
    }

    public UserMovie(Integer id, User user, Movie movie, LocalDate createdAt, Integer tickets, Integer valoration) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.createdAt = createdAt;
        this.tickets = tickets;
        this.valoration = valoration;
    }

    public Integer getId() {
        return id;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public Integer getValoration() {
        return valoration;
    }

    public void setValoration(Integer valoration) {
        this.valoration = valoration;
    }

}
