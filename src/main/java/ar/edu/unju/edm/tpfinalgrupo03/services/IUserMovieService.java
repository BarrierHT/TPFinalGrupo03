package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovie;

@Service
public interface IUserMovieService {
    public UserMovie newUserMovie();

    public void saveUserMovie(UserMovie userMovie); // Add an user

    public List<UserMovie> getUserMovies(); // get User List

    public void editUserMovie(UserMovie userMovie);

    public void deleteUserMovie(Integer id) throws Exception;

    public UserMovie getUserMovie(Integer id) throws Exception;
}
