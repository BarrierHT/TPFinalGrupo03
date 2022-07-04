package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.models.Movie;
import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovieComment;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.UserMovieCommentRepository;

@Service
public class IUserMovieCommentServiceImp implements IUserMovieCommentService {

    @Autowired
    UserMovieComment userMovieComment;

    @Autowired
    UserMovieCommentRepository userMovieCommentRepository;

    @Autowired
    IMovieService movieService;

    @Override
    public UserMovieComment newUserMovieComment() {
        return userMovieComment;
    }

    @Override
    public void saveUserMovieComment(UserMovieComment userMovieComment) {
        userMovieCommentRepository.save(userMovieComment);
    }

    @Override
    public List<UserMovieComment> getUserMovieComments() {
        return (List<UserMovieComment>) userMovieCommentRepository.findAll();
    }

    @Override
    public List<UserMovieComment> getUserMovieCommentsByMovie(Integer id) {
        List<UserMovieComment> commentsMapped = new ArrayList<>();

        try {

            List<UserMovieComment> comments = this.getUserMovieComments();

            for (int i = 0; i < comments.size(); i++) {
                if (comments.get(i).getMovie().getId() == id)
                    commentsMapped.add(comments.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return commentsMapped;
    }

    @Override
    public void editUserMovieComment(UserMovieComment userMovieComment) {

    }

    @Override
    public void deleteUserMovieComment(Integer id) throws Exception {
        userMovieCommentRepository.deleteById(id);
    }

    @Override
    public UserMovieComment getUserMovieComment(Integer id) throws Exception {
        return userMovieCommentRepository.findById(id).orElseThrow(() -> new Exception("UserMovieComment not found"));
    }
}
