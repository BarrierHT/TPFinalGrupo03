package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.UserRepository;

@Service
public class IUserServiceImp implements IUserService {

    private static final Log LOGGER = LogFactory.getLog(IUserServiceImp.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User incomingUser) {

        userRepository.save(incomingUser);
    }

    @Override
    public List<User> getUsers() {

        List<User> auxList = new ArrayList<>();

        auxList = (List<User>) userRepository.findAll();

        for (int i = 0; i < auxList.size(); i++) {
            auxList.get(i).setPassword(null);
        }

        return auxList;
    }

    @Override
    public void editUser(User incomingUser) {

        User userSaved = userRepository.findById(incomingUser.getId()).get();
        userSaved.setName(incomingUser.getName());
        userSaved.setSurname(incomingUser.getSurname());
        userRepository.save(userSaved);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {

        User userFound = this.getUser(id);
        LOGGER.info("User name: " + userFound.getName());

        userRepository.delete(userFound);
    }

    @Override
    public User getUser(Integer id) throws Exception {

        User userFound = new User();
        userFound = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        return userFound;
    }

    @Override
    public User getUserByIdCard(Integer idCard) throws Exception {

        User userFound = new User();
        userFound = userRepository.findById(idCard).orElseThrow(() -> new Exception("User not found"));
        return userFound;
    }
}