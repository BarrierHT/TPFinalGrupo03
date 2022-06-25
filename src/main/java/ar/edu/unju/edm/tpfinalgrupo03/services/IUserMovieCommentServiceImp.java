package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.relations.UserMovieComment;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.UserMovieCommentRepository;

@Service
public class IUserMovieCommentServiceImp implements IUserMovieCommentService{

    @Autowired
    UserMovieComment userMovieComment;

    @Autowired
    UserMovieCommentRepository userMovieCommentRepository;

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
    public void editUserMovieComment(UserMovieComment userMovieComment) {
        
    }

    @Override
    public void deleteUserMovieComment(Integer id) throws Exception {
    }

    @Override
    public UserMovieComment getUserMovieComment(Integer id) throws Exception {
        return userMovieCommentRepository.findById(id).orElseThrow(() -> new Exception("UserMovieComment not found"));
    } 
}
