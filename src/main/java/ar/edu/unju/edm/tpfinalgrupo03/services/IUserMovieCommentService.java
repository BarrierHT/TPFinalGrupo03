package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovieComment;

@Service
public interface IUserMovieCommentService {
    public UserMovieComment newUserMovieComment();

    public void saveUserMovieComment(UserMovieComment userMovieComment);

    public List<UserMovieComment> getUserMovieComments();

    public void editUserMovieComment(UserMovieComment userMovieComment);

    public void deleteUserMovieComment(Integer id) throws Exception;

    public UserMovieComment getUserMovieComment(Integer id) throws Exception;
}
