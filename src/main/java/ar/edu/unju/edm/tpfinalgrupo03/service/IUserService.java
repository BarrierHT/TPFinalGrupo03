package ar.edu.unju.edm.tpfinalgrupo03.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ar.edu.unju.edm.tpfinalgrupo03.models.User;

@Service
public interface IUserService {

    public void saveUser(User user); 

    public List<User> getUsers(); 

    public void editUser(User user);

    public void deleteUser(Integer id) throws Exception;

    public User getUser(Integer id) throws Exception;

    public User getUserByIdCard(Integer idCard) throws Exception; 
}
