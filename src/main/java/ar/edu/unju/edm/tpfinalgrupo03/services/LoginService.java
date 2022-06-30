package ar.edu.unju.edm.tpfinalgrupo03.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.UserRepository;

@Service
public class LoginService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String idCard) throws UsernameNotFoundException {

        ar.edu.unju.edm.tpfinalgrupo03.models.User userFound = new ar.edu.unju.edm.tpfinalgrupo03.models.User();

        userFound = userRepository.findByIdCard(Integer.parseInt(idCard)).orElseThrow(() -> new UsernameNotFoundException("User not found")); 

        List <GrantedAuthority> roles = new ArrayList<>(); 
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFound.getRole());
        roles.add(grantedAuthority);

        UserDetails activeUser = new User(idCard, userFound.getPassword(), roles); 
        
        System.out.println("User loged: " + activeUser.getUsername());

        return activeUser;
    }
}
