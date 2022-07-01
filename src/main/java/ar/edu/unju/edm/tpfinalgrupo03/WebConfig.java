package ar.edu.unju.edm.tpfinalgrupo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.edm.tpfinalgrupo03.services.LoginService;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
	private Auth authenticacion;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/webjars/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/", "/index","/signup","/saveUser").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(authenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("idCard")
				.passwordParameter("password")				
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/login?logout");
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Autowired
	LoginService userDetailsService;

    @Autowired
	public void globalConfig(AuthenticationManagerBuilder auth)
			throws Exception {
            auth.userDetailsService(userDetailsService);
	}
}