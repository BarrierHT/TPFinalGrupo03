package ar.edu.unju.edm.tpfinalgrupo03;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class Auth implements AuthenticationSuccessHandler{

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
        Boolean user = false;
        Boolean admin = false;

        Collection<?extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for(GrantedAuthority grantedAuthority:authorities){
            if(grantedAuthority.getAuthority().equals("ADMIN")){
                admin = true;
                break;        
            }else{
                if(grantedAuthority.getAuthority().equals("CLIENT")){
                    user = true;
                    break;
                }
            }
        }
        
        if(admin){
            redirectStrategy.sendRedirect(request, response, "/getUsers");
        }else{
            if(user){
                redirectStrategy.sendRedirect(request, response, "/getMovies");
            }
        }
    }
}
